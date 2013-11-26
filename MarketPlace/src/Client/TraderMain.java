package Client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.MalformedURLException; 

import Server.IMarketPlace;
import Server.Trader;
 
public class TraderMain {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
    	
    	Registry registry = LocateRegistry.getRegistry("localhost");
        IMarketPlace remoteMarketPlace = (IMarketPlace) registry.lookup("server.Hello");
        
        //ITrader remoteTrader = new ITraderImpl();
       //Naming.rebind("server.Hello", remoteTrader); 
        
        remoteMarketPlace.registerTrader(new Trader("joel"));
    }
}