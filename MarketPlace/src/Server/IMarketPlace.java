package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
 
public interface IMarketPlace extends Remote {
	boolean registerTrader(Trader trader) throws RemoteException;
	boolean unregisterTrader(Trader trader) throws RemoteException;
	ArrayList<Item> getItemList() throws RemoteException;
	boolean sellItem(Trader trader, Item item) throws RemoteException;
	boolean buyItem(Trader trader, Item item) throws RemoteException;
	boolean addWish(Trader trader, Item Item) throws RemoteException;

}