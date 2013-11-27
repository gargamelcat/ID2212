package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Server.IMarketPlace;
import Server.Item;

@SuppressWarnings("serial")
public class Trader extends UnicastRemoteObject implements ITrader {
	private String name;

	public Trader(String id) throws RemoteException {
		super();
		this.name = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean notifySeller(Item item) throws RemoteException {
		System.out.println("item got sold: " + item.getName());
		return false;
	}

	@Override
	public boolean notifyWish(Item item) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}