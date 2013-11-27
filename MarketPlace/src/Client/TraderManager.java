package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Server.IMarketPlace;
import Server.Item;
import Server.MarketPlace;

public class TraderManager extends Observable implements IGui {

	Trader me = null;
	IMarketPlace remoteMarketPlace = null;

	public static void main(String args[]) throws RemoteException,
			NotBoundException, MalformedURLException {

	}

	public TraderManager() {
	}

	@Override
	public void login(String name) {
		Trader me;
		try {
			me = new Trader(this, name);
			remoteMarketPlace = (IMarketPlace) Naming
					.lookup("rmi://localhost/marketPlace");
			remoteMarketPlace.registerTrader(me);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			System.out.println("Coud not register trader.");
			e.printStackTrace();
		}

	}

	@Override
	public void logout() {
		try {
			remoteMarketPlace.unregisterTrader(me);
		} catch (RemoteException e) {
			System.out.println("coud not unregister trader.");
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Item> getItemList() {
		ArrayList<Item> itemList = null;
		try {
			itemList = remoteMarketPlace.getItemList();
		} catch (RemoteException e) {
			System.out
					.println("could not get itemlist from remote marketplace.");
			e.printStackTrace();
		}
		return itemList;
	}

	@Override
	public void sellItem(Item item) {
		try {
			remoteMarketPlace.sellItem(me, item.getName(), item.getPrice());
		} catch (RemoteException e) {
			System.out.println("could not sell item: " + item.getName());
			e.printStackTrace();
		}
	}

	@Override
	public void buyItem(Item item) {
		try {
			remoteMarketPlace.buyItem(me, item);
		} catch (RemoteException e) {
			System.out.println("coud not buy item: " + item.getName());
			e.printStackTrace();
		}
	}
	
	public void notifyChangesToGui(){
		setChanged();
		notifyObservers();
	}
}
