package Server;
 
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

import Client.ITrader;
import Client.Trader;
 
public class MainServer {
 
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        try{
        	LocateRegistry.getRegistry(1099).list();
        }
        catch (RemoteException e) {
        	LocateRegistry.createRegistry(1099);       	
        }
        IMarketPlace remoteMarketplace = new IMarketPlaceImpl();
        Naming.rebind("server.Hello", remoteMarketplace);
        System.out.println("server.RMI Server is ready.");
        
    }
}