package Client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException; 

import Server.IMarketPlace;
 
public class TraderMain {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
    	
    	Registry registry = LocateRegistry.getRegistry("localhost");
        IMarketPlace remoteMarketPlace = (IMarketPlace) registry.lookup("server.Hello");
        //ITrader remoteTrader = new ITraderImpl();
       //Naming.rebind("server.Hello", remoteTrader); 
       
        Trader trader = new Trader("joel");
        System.out.println("trader created");
        //UnicastRemoteObject.exportObject(trader);
        
        System.out.println("trader exported");
        remoteMarketPlace.registerTrader(trader);
    }
}