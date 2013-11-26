package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Server.Item;
import Server.Trader;

public interface ITrader extends Remote {
	
	boolean notifySeller(Trader trader, Item item) throws RemoteException;
	boolean notifyWish(Trader trader, Item item) throws RemoteException;
	
}
