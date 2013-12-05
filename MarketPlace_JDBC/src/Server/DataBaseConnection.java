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

@SuppressWarnings("serial")

public class DataBaseConnection {

    public static final String TABLE_USERS = "Users";
    public static final String TABLE_ITEMS = "Items";
    public static final String TABLE_WISHES = "Wishes";
    public static final String TABLE_SALES = "Sales";

    private PreparedStatement registerUser;
    private PreparedStatement findUserStatement;
    private PreparedStatement unregisterUserStatement;
    
    private PreparedStatement getSalesStatement;
    private PreparedStatement setSaleStatement;
    private PreparedStatement deleteSaleStatement;
    
    private PreparedStatement addWishStatement;
    private PreparedStatement findWishStatement;
    
    private String datasource;

    public DataBaseConnection(String datasource)
            throws RemoteException, ClassNotFoundException, SQLException {
        super();
        this.datasource = datasource;
        Connection connection = createDatasource();
       // prepareStatements(connection);
    }

    private Connection createDatasource() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        boolean exist = false;
        int tableNameColumn = 3;
        DatabaseMetaData dbm = connection.getMetaData();
        for (ResultSet rs = dbm.getTables(null, null, null, null); rs.next();) {
            if (rs.getString(tableNameColumn).equals("Users") || rs.getString(tableNameColumn).equals("Items")
            	|| rs.getString(tableNameColumn).equals("Wishes") || rs.getString(tableNameColumn).equals("Sales")) {
            	System.out.println("Tables exists! Not being created :)");
                exist = true;
                rs.close();
                break;
            }
        }
        if (!exist) {
        	System.out.println("HELLO LETS CREATE TABLES!");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS" + TABLE_USERS + "("
            		   + "`name` varchar(16) COLLATE latin1_general_ci NOT NULL,"
            		   + "`password` varchar(16) COLLATE latin1_general_ci NOT NULL,"
            		   + "`sales` int(11) NOT NULL,"
            		   + "`purchases` int(11) NOT NULL,"
            		  + "PRIMARY KEY (`name`)"
            		 + ")"  );
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS" + TABLE_ITEMS +  "("
          		   + "`itemID` int(11) NOT NULL auto_increment,"
         		   + "`name` varchar(16) COLLATE latin1_general_ci NOT NULL,"
         		   + "`price` int(11) NOT NULL,"
         		   + "`amount` int(11) NOT NULL,"
         		  + "PRIMARY KEY (`itemID`)"
         		 + ")"  );
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS" + TABLE_WISHES + "("
          		   + "`fkw_name` varchar(16) COLLATE latin1_general_ci NOT NULL,"
          		   + "`fkw_itemID` int(11) NOT NULL,"
          		   + "FOREIGN KEY (fkw_name) REFERENCES Users(name),"
          		   + "FOREIGN KEY (fkw_itemID) REFERENCES Items(itemID),"
          		   + "primary key (fkw_name, fkw_itemID)"
          		 + ")"  );
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS" + TABLE_SALES + "("
           		   + "`fks_name` varchar(16) COLLATE latin1_general_ci NOT NULL,"
           		   + "`fks_itemID` int(11) NOT NULL,"
          		   + "FOREIGN KEY (fks_name) REFERENCES Users(name),"
          		   + "FOREIGN KEY (fks_itemID) REFERENCES Items(itemID),"
           		   + "primary key (fks_name, fks_itemID)"
           		 + ")"  );
        }
        return connection;
    }

    public Connection getConnection()
            throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://ideasrecursivas.com:3306/"+ datasource , "ideasrec_rmi", "ideasrec_rmi");
            
    }

    private void prepareStatements(Connection connection) throws SQLException {
        registerUser = connection.prepareStatement("INSERT INTO "
                + TABLE_USERS + " VALUES (?, ?, 0, 0)");
        findUserStatement = connection.prepareStatement("SELECT * from "
                + TABLE_USERS + " WHERE NAME = ?");
        unregisterUserStatement = connection.prepareStatement("DELETE FROM "
                + TABLE_USERS + " WHERE name = ?");
        
        
        getSalesStatement = connection.prepareStatement("TO BE DONE");
        
        setSaleStatement = connection.prepareStatement("INSERT INTO "
                + TABLE_SALES + " VALUES (?, ?)");
        
        deleteSaleStatement = connection.prepareStatement("DELETE FROM "
                + TABLE_SALES + " WHERE fks_name = ?");
        
        findWishStatement = connection.prepareStatement("SELECT fkw_name from "
                + TABLE_WISHES + " WHERE fkw_itemID = ?");
        
        addWishStatement = connection.prepareStatement("INSERT INTO "
                + TABLE_WISHES + " VALUES (?, ?)");
        
    }

    
}
