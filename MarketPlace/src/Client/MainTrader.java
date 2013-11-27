package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import Server.IMarketPlace;

public class MainTrader {
	
	
	public static void main(String args[]) throws RemoteException, 
	NotBoundException, 
	MalformedURLException {
		String myId = "joel";
		Trader me = new Trader(myId);

		IMarketPlace remoteMarketPlace = 
				(IMarketPlace)Naming.lookup("rmi://localhost/marketPlace");
		remoteMarketPlace.registerTrader(me);
		
		remoteMarketPlace.unregisterTrader(me);
	}
}
