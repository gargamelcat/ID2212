package Server;
 
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
 
public class MainServer {
 
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(1099);
        IMarketPlace remoteMarketplace = new IMarketPlaceImpl();
        Naming.rebind("server.Hello", remoteMarketplace);
        System.out.println("server.RMI Server is ready.");
        /**
    	Registry registry = LocateRegistry.getRegistry("localhost");
        try {
        	
        	if(registry.lookup("client.Hello") != null){
                ITrader remoteTrader = (ITrader) registry.lookup("client.Hello");
                remoteTrader.notifySeller(new Trader("albert"), new Item("beer", 1000));
        	}
			
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       **/ 
        
    }
}