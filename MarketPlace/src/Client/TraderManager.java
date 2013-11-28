package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import Bank.AccountImpl;
import Bank.IAccount;
import Bank.IBank;
import Bank.RejectedException;
import Server.IMarketPlace;
import Server.Item;
import Server.MarketPlace;

public class TraderManager extends Observable implements IGui {

	Trader me = null;
	IMarketPlace remoteMarketPlace = null;
	LinkedList<String> messageLog = null;
	
	IAccount myBankAccount = null;
	IBank myBank = null;
	
	
	public TraderManager() {
		messageLog = new LinkedList<String>();
	}

	@Override
	public void login(String name) {
		Trader me;
		try {
			me = new Trader(this, name);
			remoteMarketPlace = (IMarketPlace) Naming
					.lookup("rmi://localhost/marketPlace");
			remoteMarketPlace.registerTrader(me);
			
			myBank = (IBank)Naming.lookup("rmi://localhost/bank");
			myBankAccount = myBank.newAccount(me.getName());

		} catch (RemoteException | MalformedURLException | NotBoundException | RejectedException e) {
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

	public void notifyChangesToGui(String sortOfChange) {
		setChanged();
		notifyObservers(sortOfChange);
	}

	public String getNewestLogMessage() {
		String tempMessage = null;
		if (messageLog.size() > 0) {
			tempMessage = messageLog.removeFirst();
		}
		return tempMessage;
	}

	public void addMessageToLog(String message) {
		messageLog.add(message);
		notifyChangesToGui("messageLog");
	}

	@Override
	public void depositMoney(int money) {
		try {
			myBankAccount.deposit(money);
		} catch (RemoteException | RejectedException e) {
			System.out.println("could not deposit money");
			e.printStackTrace();
		}
	}

	@Override
	public int getBalance() {
		int balance = 0;
		try {
			balance = (int) myBankAccount.getBalance();
		} catch (RemoteException e) {
			System.out.println("could not get balance from bank");
			e.printStackTrace();
		}
		return balance;
	}
}
