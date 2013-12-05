package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import Client.Trader;

@SuppressWarnings("serial")
public class DBDriver {

	public static final String TABLE_USERS = "Users";
	public static final String TABLE_ITEMS = "Items";
	public static final String TABLE_WISHES = "Wishes";
	public static final String TABLE_SALES = "Sales";

	private PreparedStatement registerUserStatement;
	private PreparedStatement findUserStatement;
	private PreparedStatement unregisterUserStatement;

	private PreparedStatement getSalesStatement;
	private PreparedStatement setSaleStatement;
	private PreparedStatement insertItemStatement;
	private PreparedStatement addSellerLinkStatement;
	private PreparedStatement deleteSaleStatement;

	private PreparedStatement addWishStatement;
	private PreparedStatement findWishStatement;

	private String datasource;
	private Connection connection;

	public DBDriver(String datasource) throws RemoteException,
			ClassNotFoundException, SQLException {
		super();
		this.datasource = datasource;
		connect();
		createDatasource();
		prepareStatements();
	}

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://ideasrecursivas.com:3306/" + datasource,
				"ideasrec_rmi", "ideasrec_rmi");
	}

	private void createDatasource() throws ClassNotFoundException, SQLException {
		boolean exist = false;
		int tableNameColumn = 3;
		DatabaseMetaData dbm = connection.getMetaData();
		for (ResultSet rs = dbm.getTables(null, null, null, null); rs.next();) {
			if (rs.getString(tableNameColumn).equals("Users")
					|| rs.getString(tableNameColumn).equals("Items")
					|| rs.getString(tableNameColumn).equals("Wishes")
					|| rs.getString(tableNameColumn).equals("Sales")) {
				System.out.println("Tables exists! Not being created :)");
				exist = true;
				rs.close();
				break;
			}
		}
		if (!exist) {
			System.out.println("HELLO LETS CREATE TABLES!");
			Statement statement = connection.createStatement();
			statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS"
							+ TABLE_USERS
							+ "("
							+ "`name` varchar(16) COLLATE latin1_general_ci NOT NULL,"
							+ "`password` varchar(16) COLLATE latin1_general_ci NOT NULL,"
							+ "`sales` int(11) NOT NULL,"
							+ "`purchases` int(11) NOT NULL,"
							+ "PRIMARY KEY (`name`)" + ")");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS" + TABLE_ITEMS
					+ "(" + "`itemID` int(11) NOT NULL auto_increment,"
					+ "`name` varchar(16) COLLATE latin1_general_ci NOT NULL,"
					+ "`price` int(11) NOT NULL,"
					+ "`amount` int(11) NOT NULL," + "PRIMARY KEY (`itemID`)"
					+ ")");
			statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS"
							+ TABLE_WISHES
							+ "("
							+ "`fkw_name` varchar(16) COLLATE latin1_general_ci NOT NULL,"
							+ "`fkw_itemID` int(11) NOT NULL,"
							+ "FOREIGN KEY (fkw_name) REFERENCES Users(name),"
							+ "FOREIGN KEY (fkw_itemID) REFERENCES Items(itemID),"
							+ "primary key (fkw_name, fkw_itemID)" + ")");
			statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS"
							+ TABLE_SALES
							+ "("
							+ "`fks_name` varchar(16) COLLATE latin1_general_ci NOT NULL,"
							+ "`fks_itemID` int(11) NOT NULL,"
							+ "FOREIGN KEY (fks_name) REFERENCES Users(name),"
							+ "FOREIGN KEY (fks_itemID) REFERENCES Items(itemID),"
							+ "primary key (fks_name, fks_itemID)" + ")");
		}
	}

	private void prepareStatements() throws SQLException {
		registerUserStatement = connection.prepareStatement("INSERT INTO "
				+ TABLE_USERS + " VALUES (?, ?, 0, 0)");
		findUserStatement = connection.prepareStatement("SELECT * from "
				+ TABLE_USERS + " WHERE NAME = ?");
		unregisterUserStatement = connection.prepareStatement("DELETE FROM "
				+ TABLE_USERS + " WHERE name = ?");

		getSalesStatement = connection.prepareStatement("TO BE DONE");

		insertItemStatement = connection.prepareStatement("INSERT INTO "
				+ TABLE_ITEMS + " ( name, price, amount) VALUES"
				+ "( ?, ?, ? )", Statement.RETURN_GENERATED_KEYS);

		addSellerLinkStatement = connection.prepareStatement("INSERT INTO "
				+ TABLE_SALES + "( fks_name, fks_itemID ) VALUES" + "(?,?)");

		deleteSaleStatement = connection.prepareStatement("DELETE FROM "
				+ TABLE_SALES + " WHERE fks_name = ?");

		findWishStatement = connection.prepareStatement("SELECT fkw_name from "
				+ TABLE_WISHES + " WHERE fkw_itemID = ?");

		addWishStatement = connection.prepareStatement("INSERT INTO "
				+ TABLE_WISHES + " VALUES (?, ?)");
	}

	public void addProduct(String seller, Item item, int amount) {
		int affectedRows = 0;
		ResultSet generatedKeys = null;

		if (checkIfTraderExists(seller)) {
			try {
				insertItemStatement.setString(1, item.getName());

				insertItemStatement.setInt(2, item.getPrice());
				insertItemStatement.setInt(3, amount);
				affectedRows = insertItemStatement.executeUpdate();

				if (affectedRows == 0) {
					throw new SQLException(
							"Creating user failed, no rows affected.");
				}

				generatedKeys = insertItemStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					addSellerLinkStatement.setString(1, seller);
					addSellerLinkStatement.setInt(2, generatedKeys.getInt(1));
					addSellerLinkStatement.executeUpdate();
				} else {
					throw new SQLException(
							"Creating user failed, no generated key obtained.");
				}

				System.out.println("id of " + item.getName() + " is: "
						+ generatedKeys.getInt(1));

			} catch (SQLException e) {
				System.out.println("could not insert product");
				e.printStackTrace();
			}

		} else {
			System.out.println("Following trader does not exist: " + seller);
		}

	}

	public boolean checkIfTraderExists(String name) {
		boolean traderExists = false;
		try {
			findUserStatement.setString(1, name);

			ResultSet trader = findUserStatement.executeQuery();
			if (trader.next()) {
				traderExists = true;
			}

		} catch (SQLException e) {
			System.out.println("Could not find user: " + name);
			e.printStackTrace();
		}
		return traderExists;
	}

	public void addTrader(Trader trader) {
		if (checkIfTraderExists(trader.getName())) {
			try {
				registerUserStatement.setString(1, trader.getName());
				registerUserStatement.setString(2, trader.getPassword());
				registerUserStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("could not create trader: "
						+ trader.getName());
				e.printStackTrace();
			}

		} else {
			System.out.println("Following trader does not exist: "
					+ trader.getName());
		}
	}

	public boolean checkPassword(Trader trader) {
		boolean passwordIsCorrect = false;
		String passwordInDB = null;
		try {
			findUserStatement.setString(1, trader.getName());

			ResultSet resultSetOfTrader = findUserStatement.executeQuery();
			if (resultSetOfTrader.next()) {
				passwordInDB = resultSetOfTrader.getString("password");
				if (passwordInDB.equals(trader.getPassword())) {
					passwordIsCorrect = true;
				}

			} else {
				System.out.println("Following trader does not exist: "
						+ trader.getName());
			}
		} catch (SQLException e) {
			System.out.println("Could not check password for followin trader: "
					+ trader.getName());
			e.printStackTrace();
		}
		return passwordIsCorrect;
	}

}
