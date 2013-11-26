package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class IMarketPlaceImpl extends UnicastRemoteObject implements
		IMarketPlace {
	

	Trader trader = null;
    
	public IMarketPlaceImpl() throws RemoteException {
		
	}

	@Override
	public boolean registerTrader(Trader trader) throws RemoteException {
		System.out.println("This trader is now registered: " + trader.getName());
		this.trader = trader;
		return true;
	}

	@Override
	public boolean unregisterTrader(Trader trader) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Item> getItemList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sellItem(Trader trader, Item item) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buyItem(Trader trader, Item item) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWish(Trader trader, Item Item) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}