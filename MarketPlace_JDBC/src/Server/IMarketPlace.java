package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Client.ITrader;
import Client.Trader;


/**
 * This interface defines the methods that a trader can use on the remote marketplace.
 * @author Joel Rolli
 * @version 1.0
 */



public interface IMarketPlace extends Remote {
   
	/**
	 * This method will register the trader in the marketplace.
	 * @param ITrader Trader to register.
	 * @return boolean depending if password is correct and user exists.
	 */
	boolean registerTrader(ITrader trader) throws RemoteException;
	
	/**
	 * This method will unregister the trader in the marketplace.
	 * @param ITrader Trader to unregister.
	 */
	void unregisterTrader(ITrader trader) throws RemoteException;
	
	
	/**
	 * This method will login the trader in the marketplace. The trader need already to be registered.
	 * @param ITrader Trader to register.
	 * @return Boolean If password or user name is wrong -> false.
	 */
	boolean loginTrader(ITrader trader) throws RemoteException;
	
	/**
	 * This method will return a list with all available items in the marketplace.
	 * @return ArrayList<Item> ArrayList with all available items.
	 */
	ArrayList<Item> getItemList() throws RemoteException;
	
	/**
	 * This method will put a new item into the marketplace.
	 * @param ITrader Trader that want to sell the item.
	 * @param Item Item that will be put into the marketplace.
	 */
	void sellItem(ITrader trader, String itemName, Integer price, Integer amount) throws RemoteException;
	
	/**
	 * This method will puy an item.
	 * @param Item Item that will be bought.
	 * @param ITrader Trader that will buy the item.
	 */
	boolean buyItem(ITrader trader, Item item) throws RemoteException;
	
	/**
	 * This method will add a wish for a trader.
	 * @param ITrader Trader that adds the wish to the marketplace.
	 * @param Item Item that the trader is looking for.
	 */
	void addWish(ITrader trader, String wish) throws RemoteException;  
}