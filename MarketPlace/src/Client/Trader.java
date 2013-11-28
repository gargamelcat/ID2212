package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Server.IMarketPlace;
import Server.Item;

@SuppressWarnings("serial")
public class Trader extends UnicastRemoteObject implements ITrader {
	private String name;
	private TraderManager traderManger = null;

	public Trader(TraderManager traderManager, String name)
			throws RemoteException {
		super();
		this.name = name;
		this.traderManger = traderManager;
	}

	public String getName() {
		return name;
	}

	@Override
	public void notifySeller(Item item) throws RemoteException {
		traderManger.addMessageToLog("You sold following item: "
				+ item.getName());
	}

	@Override
	public void notifyWish(Item item) throws RemoteException {
		traderManger
				.addMessageToLog("Following item in your wishlist is now available in the shop: "
						+ item.getName()
						+ "\n"
						+ "The price is: "
						+ item.getPrice());
	}

	@Override
	public void dataChanged() throws RemoteException {
		traderManger.notifyChangesToGui("serverData");
	}
	
	@Override
	public void balanceChanged() throws RemoteException {
		traderManger.notifyChangesToGui("balance");
	}	
}