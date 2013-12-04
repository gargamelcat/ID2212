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

    public static final String TABLE_NAME = "ACCOUNT";
    private PreparedStatement createAccountStatement;
    private PreparedStatement findAccountStatement;
    private PreparedStatement deleteAccountStatement;
    private String datasource;

    public DataBaseConnection(String datasource)
            throws RemoteException, ClassNotFoundException, SQLException {
        super();
        this.datasource = datasource;
        //Connection connection = createDatasource();
       // prepareStatements(connection);
    }

    private Connection createDatasource() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        boolean exist = false;
        int tableNameColumn = 3;
        DatabaseMetaData dbm = connection.getMetaData();
        for (ResultSet rs = dbm.getTables(null, null, null, null); rs.next();) {
            if (rs.getString(tableNameColumn).equals(TABLE_NAME)) {
                exist = true;
                rs.close();
                break;
            }
        }
        if (!exist) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + TABLE_NAME
                    + " (name VARCHAR(32) PRIMARY KEY, balance FLOAT)");
        }
        return connection;
    }

    public Connection getConnection()
            throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://ideasrecursivas.com:3306/" + datasource, "ideasrec_rmi", "ideasrec_rmi");
            
    }

    private void prepareStatements(Connection connection) throws SQLException {
        createAccountStatement = connection.prepareStatement("INSERT INTO "
                + TABLE_NAME + " VALUES (?, 0)");
        findAccountStatement = connection.prepareStatement("SELECT * from "
                + TABLE_NAME + " WHERE NAME = ?");
        deleteAccountStatement = connection.prepareStatement("DELETE FROM "
                + TABLE_NAME + " WHERE name = ?");
    }

    
}
