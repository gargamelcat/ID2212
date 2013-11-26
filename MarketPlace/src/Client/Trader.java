package Client;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Server.Item;

public  class Trader implements ITrader, Serializable{

	private static final long serialVersionUID = 1L;
	
	String name = null;

	public Trader(String name) throws RemoteException{
		this.name = name;
	}
	
	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	@Override
	public synchronized boolean notifySeller(Item item)
			throws RemoteException {
		System.out.println("Name: " + item.getName() + " Price: "+ item.getPrice());
		return false;
	}

	@Override
	public synchronized boolean notifyWish(Item item) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
