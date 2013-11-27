package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Client.ITrader;
import Client.Trader;

public interface IMarketPlace extends Remote {
    
	void registerTrader(ITrader trader) throws RemoteException;
	void unregisterTrader(ITrader trader) throws RemoteException;
	ArrayList<Item> getItemList() throws RemoteException;
	void sellItem(ITrader trader, Item item) throws RemoteException;
	void buyItem(ITrader trader, Item item) throws RemoteException;
	void addWish(ITrader trader, Item Item) throws RemoteException;  
    
}