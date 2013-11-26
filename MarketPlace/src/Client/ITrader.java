package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Server.Item;

public interface ITrader extends Remote {
	
	boolean notifySeller( Item item) throws RemoteException;
	boolean notifyWish(Item item) throws RemoteException;
	
}
