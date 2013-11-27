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

	public Trader(String name) throws RemoteException {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void notifySeller(Item item) throws RemoteException {
		System.out.println("You sold following item: " + item.getName());
	}

	@Override
	public void notifyWish(Item item) throws RemoteException {
		System.out.println("Following item in your wishlist is now available in the shop: " + item.getName());
		System.out.println("The price is: " + item.getPrice());
	}
}