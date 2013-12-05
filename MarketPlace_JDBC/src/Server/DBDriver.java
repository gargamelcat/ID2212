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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Client.ITrader;
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
	private PreparedStatement findItemStatement;
	private PreparedStatement addSellerLinkStatement;
	private PreparedStatement deleteSaleStatement;

	private PreparedStatement deleteWishStatement;
	private PreparedStatement addWishStatement;
	private PreparedStatement findWishStatement;
	private PreparedStatement getAllItemsStatement;

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
					.executeUpdate("CREATE TABLE IF NOT EXISTS "
							+ TABLE_USERS
							+ "("
							+ "`name` varchar(16) COLLATE latin1_general_ci NOT NULL,"
							+ "`password` varchar(16) COLLATE latin1_general_ci NOT NULL,"
							+ "`sales` int(11) NOT NULL,"
							+ "`purchases` int(11) NOT NULL,"
							+ "PRIMARY KEY (`name`)" + ")");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_ITEMS
					+ "("
					+ "`name` varchar(16) COLLATE latin1_general_ci NOT NULL,"
					+ "`price` int(11) NOT NULL,"
					+ "`amount` int(11) NOT NULL," + "PRIMARY KEY (`name`)"
					+ ")");
			statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS "
							+ TABLE_WISHES
							+ "("
							+ "`fkw_TraderName` varchar(16) COLLATE latin1_general_ci NOT NULL,"
							+ "`fkw_ItemName` varchar(16) COLLATE latin1_general_ci NOT NULL,"
							+ "FOREIGN KEY (fkw_TraderName) REFERENCES Users(name),"
							+ "FOREIGN KEY (fkw_ItemName) REFERENCES Items(name),"
							+ "primary key (fkw_TraderName, fkw_ItemName)"
							+ ")");
			statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS "
							+ TABLE_SALES
							+ "("
							+ "`fks_TraderName` varchar(16) COLLATE latin1_general_ci NOT NULL,"
							+ "`fks_ItemName` varchar(16) COLLATE latin1_general_ci NOT NULL,"
							+ "FOREIGN KEY (fks_TraderName) REFERENCES Users(name),"
							+ "FOREIGN KEY (fks_ItemName) REFERENCES Items(name),"
							+ "primary key (fks_TraderName, fks_ItemName)"
							+ ")");
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
				+ "( ?, ?, ? )");

		findItemStatement = connection.prepareStatement("SELECT * from "
				+ TABLE_WISHES + " WHERE name = ?");

		getAllItemsStatement = connection.prepareStatement("SELECT * from "
				+ TABLE_ITEMS);

		addSellerLinkStatement = connection.prepareStatement("INSERT INTO "
				+ TABLE_SALES + "( fks_TraderName, fks_ItemName ) VALUES"
				+ "(?,?)");

		deleteSaleStatement = connection.prepareStatement("DELETE FROM "
				+ TABLE_SALES + " WHERE fks_name = ?");

		deleteWishStatement = connection.prepareStatement("DELETE FROM "
				+ TABLE_WISHES + " WHERE fkw_TraderName = ?");

		findWishStatement = connection.prepareStatement("SELECT fkw_name from "
				+ TABLE_WISHES
				+ " WHERE fkw_TraderName = ? AND fkw_ItemName = ?");

		addWishStatement = connection.prepareStatement("INSERT INTO "
				+ TABLE_WISHES + " VALUES (?, ?)");
	}

	public void addProduct(String traderName, String itemName, int price,
			int amount) {
		int affectedRows = 0;

		if (checkIfTraderExists(traderName)) {
			try {
				insertItemStatement.setString(1, traderName);

				insertItemStatement.setInt(2, price);
				insertItemStatement.setInt(3, amount);
				insertItemStatement.executeUpdate();

				if (affectedRows == 0) {
					throw new SQLException(
							"Creating user failed, no rows affected.");
				}

			} catch (SQLException e) {
				System.out.println("could not insert product");
				e.printStackTrace();
			}

		} else {
			System.out.println("Following trader does not exist: ");
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

	public void addTrader(ITrader trader) {
		try {
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
		} catch (RemoteException e) {
			System.out
					.println("Remote exception when trying to add a new trader.");
			e.printStackTrace();
		}
	}

	public boolean checkPassword(ITrader trader) {
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
		} catch (SQLException | RemoteException e) {
			System.out.println("Exception in login trader. Server side");
			e.printStackTrace();
		}
		return passwordIsCorrect;
	}

	public boolean checkIfWishExists(String name, String item) {
		boolean wishExists = false;
		try {
			findWishStatement.setString(1, name);
			findWishStatement.setString(2, item);

			ResultSet wish = findWishStatement.executeQuery();
			if (wish.next()) {
				wishExists = true;
			}

		} catch (SQLException e) {
			System.out.println("You already have this item on the wish list: "
					+ item);
			e.printStackTrace();
		}
		return wishExists;
	}

	public boolean checkItemExists(String name) {
		boolean traderExists = false;
		try {
			findItemStatement.setString(1, name);

			ResultSet itemresult = findWishStatement.executeQuery();
			if (itemresult.next()) {
				traderExists = true;
			}

		} catch (SQLException e) {
			System.out.println("Error checking Item: " + name);
			e.printStackTrace();
		}
		return traderExists;
	}

	public void addWish(Trader trader, Item item) {
		if (!checkIfWishExists(trader.getName(), item.getName())) {
			try {
				addWishStatement.setString(1, trader.getName());
				addWishStatement.setString(2, item.getName());
				addWishStatement.executeUpdate();

				if (!checkItemExists(item.getName())) {
					insertItemStatement.setString(0, item.getName());
					insertItemStatement.setInt(1, 0);
					insertItemStatement.setInt(0, 0);
					insertItemStatement.executeUpdate();
				}

			} catch (SQLException e) {
				System.out.println("could not add wished item: "
						+ item.getName());
				e.printStackTrace();
			}

		} else {
			System.out.println("Following item is already in your wish list: "
					+ item.getName());
		}
	}

	public ArrayList<Item> getItemList() {
		ResultSet rsItemList = null;
		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			rsItemList = getAllItemsStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("Could not get list of traders out of DB.");
			e.printStackTrace();
		}

		try {
			while (rsItemList.next()) {
				String tempName = rsItemList.getString("name");
				int tempPrice = rsItemList.getInt("price");
				int tempAmount = rsItemList.getInt("amount");
				itemList.add(new Item(tempName, tempPrice, tempAmount));
			}
		} catch (SQLException e) {
			System.out
					.println("Could not convert item list from db to arrayList");
			e.printStackTrace();
		}
		return itemList;
	}

}