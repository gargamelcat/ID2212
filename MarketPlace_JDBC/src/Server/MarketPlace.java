package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import Bank.BankImpl;
import Bank.IBank;
import Bank.RejectedException;
import Client.ITrader;
import Client.Trader;

@SuppressWarnings("serial")
public class MarketPlace extends UnicastRemoteObject implements IMarketPlace {
	// private List<ITrader> clientList = new ArrayList<>();
	private DBDriver dbDriver = null;
	private ArrayList<ITrader> onlineTraders = null;

	IBank bank = new BankImpl("UBS");

	public MarketPlace() throws RemoteException, MalformedURLException {
		super();
		onlineTraders = new ArrayList<ITrader>();
		try {
			dbDriver = new DBDriver("ideasrec_rmi");
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println("Connection to database failed.");
			e1.printStackTrace();
		}

		try {
			LocateRegistry.getRegistry(1099).list();
		} catch (RemoteException e) {
			LocateRegistry.createRegistry(1099);
		}
		Naming.rebind("rmi://localhost/marketPlace", this);
		Naming.rebind("rmi://localhost/bank", bank);
	}

	@Override
	public boolean registerTrader(ITrader trader) throws RemoteException {
		boolean registrationSuccessful = false;
		System.out.println(trader.getName());
		System.out.println(trader.getPassword());
		if (dbDriver.checkIfTraderExists(trader.getName()) == false) {
			dbDriver.addTrader(trader);
			registrationSuccessful = true;
		}
		onlineTraders.add(trader);
		return registrationSuccessful;
	}

	@Override
	public void logoutTrader(ITrader trader) throws RemoteException {
		for (int i = 0; i <= onlineTraders.size(); i++) {
			if (onlineTraders.get(i).getName().equals(trader.getName())) {
				onlineTraders.remove(i);
			}
		}
	}

	@Override
	public boolean loginTrader(ITrader trader) throws RemoteException {
		boolean loginSuccessful = false;
		System.out.println(trader.getName());
		System.out.println(trader.getPassword());
		if (dbDriver.checkPassword(trader)) {
			System.out.println("pw ok");
			loginSuccessful = true;
		}
		onlineTraders.add(trader);
		return loginSuccessful;
	}

	@Override
	public void sellItem(ITrader trader, String itemName, Integer price,
			Integer amount) {

		try {
			dbDriver.addProduct(trader.getName(), itemName, price, amount);
		} catch (RemoteException e) {
			System.out.println("could not add following item into the db: "
					+ itemName);
			e.printStackTrace();
		}
		notifyChangesToAllTraders();
	}

	@Override
	public boolean buyItem(ITrader trader, Item item) throws RemoteException {
		boolean bought = false;
		String sellerName = null;
		ITrader sellerObject = null;

		//if (bank.getAccount(trader.getName()).getBalance() >= item.getPrice()) {
			sellerName = dbDriver.getSellerForItem(item);
			dbDriver.removeItem(item);
			//try {
				//bank.getAccount(trader.getName()).withdraw(item.price);
				//bank.getAccount(sellerName).deposit(item.getPrice());
				sellerObject = getTraderObjectByName(sellerName);
				if (sellerObject != null) {
					sellerObject.notifySeller(item);
					sellerObject.balanceChanged();
					trader.balanceChanged();
				} else {
					System.out
							.println("Following seller is not online and can not be notified. He sold a prduct: "
									+ sellerName + "/" + item.getName());

				}
			//} catch (RejectedException e) {
			//	System.out.println("Error in buyItem/MarketPlace");
			//	e.printStackTrace();
			//}
		//}
		notifyChangesToAllTraders();
		return false;
	}

	@Override
	public void addWish(ITrader trader, String wish) throws RemoteException {
		ITrader tempTrader = null;
		try {
			if(dbDriver.addWish(trader.getName(), wish)== true){
				tempTrader = getTraderObjectByName(trader.getName());
				if(tempTrader == null){
					System.out.println("Trader is not online but his wish needs to be notified: " + trader.getName() + "/" + wish);
				}else{
					tempTrader.notifyWish(new Item(wish, 0, 0));
				}
			}
		} catch (RemoteException e) {
			System.out.println("Error in addWish/marketplace");
			e.printStackTrace();
		}
		notifyChangesToAllTraders();
	}

	@Override
	public ArrayList<Item> getItemList() throws RemoteException {
		return dbDriver.getItemList();
	}

	private void notifyChangesToAllTraders() {
		for (ITrader traderToNotify : onlineTraders) {
				try {
					traderToNotify.dataChanged();
				} catch (RemoteException e) {
					System.out.println("Error in notifyChangesToAllTraders/MarketPlace");
					e.printStackTrace();
				}
			}
	}

	private ITrader getTraderObjectByName(String name) {
		ITrader trader = null;
		try {
			for (int i = 0; i < onlineTraders.size(); i++) {

				if (onlineTraders.get(i).getName().equals(name)) {
					trader = onlineTraders.get(i);
				}
			}
		} catch (RemoteException e) {
			System.out.println("Error in GetTraderObjectByName/MarketPlace");
			e.printStackTrace();
		}
		return trader;
	}
}