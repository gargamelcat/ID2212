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

	private ArrayList<Item> itemList = new ArrayList<Item>();
	IBank bank = new BankImpl("UBS");

	public MarketPlace() throws RemoteException, MalformedURLException {
		super();

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
		if (dbDriver.checkIfTraderExists(trader.getName()) == false) {
			dbDriver.addTrader(trader);
			registrationSuccessful = true;
		}
		return registrationSuccessful;
	}

	@Override
	public void unregisterTrader(ITrader trader) throws RemoteException {
		//todo
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
		return loginSuccessful;
	}

	@Override
	public void sellItem(ITrader trader, String itemName, Integer price, Integer amount){
		
			try {
				dbDriver.addProduct(trader.getName(), itemName, price, amount);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		notifyChangesToAllTraders();
	}

	@Override
	public boolean buyItem(ITrader trader, Item item) throws RemoteException {
		/** TODO Auto-generated method stub
		ITrader seller = null;
		boolean bought = false;
		for (Entry<ITrader, ArrayList<Item>> tempMap : clientList.entrySet()) {
			if (tempMap.getValue() != null) {
				for (int k = 0; k < tempMap.getValue().size(); k++) {
					if (tempMap.getValue().get(k).getName()
							.equals(item.getName())) {
						if (bank.getAccount(trader.getName()).getBalance() >= item
								.getPrice()) {
							seller = tempMap.getKey();
							try {
								bank.getAccount(trader.getName()).withdraw(
										item.price);
								bank.getAccount(seller.getName()).deposit(
										item.price);
								seller.balanceChanged();
								trader.balanceChanged();
							} catch (RejectedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							tempMap.getValue().remove(k);
							seller.notifySeller(item);
							bought = true;
						}
					}
				}
			}
		}
		notifyChangesToAllTraders();
		**/
		return false;
	}

	@Override
	public void addWish(ITrader trader, String wish) throws RemoteException {
		/**Item tempItem = new Item(wish, 0);
		if (wishList.containsKey(trader)) {
			wishList.get(trader).add(tempItem);
		} else {
			ArrayList<Item> tempWishList = new ArrayList<Item>();
			tempWishList.add(tempItem);
			wishList.put(trader, tempWishList);
		}
**/
	}

	@Override
	public ArrayList<Item> getItemList() throws RemoteException {
		/** TODO Auto-generated method stub
		if (clientList.values() == null) {
			System.out.println("There is no items to buy");
			return null;
		}
		ArrayList<Item> tempList = new ArrayList<Item>();
		for (ArrayList<Item> lista : clientList.values()) {
			if (lista != null) {
				tempList.addAll(lista);
			}
		}**/
		return null;
	}

	private void notifyChangesToAllTraders() {
	}
}