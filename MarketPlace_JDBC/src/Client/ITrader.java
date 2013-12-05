package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Server.Item;

/**
 * This interface defines the method that the marketplace can use for call-backs to remote traders..
 * @author Joel Rolli
 * @version 1.0
 */

public interface ITrader extends Remote {
	
	/**
	 * This method will return of the name of this trader.
	 * @return String Traders name.
	 */
    String getName() throws RemoteException;
    
    
	/**
	 * This method will return of the password of this trader.
	 * @return String Traders password.
	 */
    String getPassword() throws RemoteException;
    
    
	/**
	 * This method will notify a trader when his item got sold
	 * @param Item The item that got sold.
	 */
    
	void notifySeller( Item item) throws RemoteException;
	
	/**
	 * This method will notify a trader when a product in his wishlist is available now in the marketplace.
	 * @param Item Wished item that is avaliable now.
	 */
	void notifyWish(Item item) throws RemoteException;
	
	void dataChanged() throws RemoteException;
	void balanceChanged() throws RemoteException;
	 
} 