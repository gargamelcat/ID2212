package Server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class MainServer {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			new MarketPlace();
			
		} catch (RemoteException re) {
			System.out.println(re);
			System.exit(1);
		} catch (MalformedURLException me) {
			System.out.println(me);
			System.exit(1);
		}
	}
}
