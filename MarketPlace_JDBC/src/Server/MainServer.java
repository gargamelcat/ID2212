package Server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class MainServer {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			new MarketPlace();
			DBDriver dbDriver = new DBDriver("ideasrec_rmi");
			dbDriver.addProduct("albert", new Item("whiskey", 20), 1);
			
		} catch (RemoteException re) {
			System.out.println(re);
			System.exit(1);
		} catch (MalformedURLException me) {
			System.out.println(me);
			System.exit(1);
		}
	}
}