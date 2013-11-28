package Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Server.Item;

public interface IGui {

	void login(String name);
	void logout();
	ArrayList<Item> getItemList();
	void sellItem(Item item);
	void buyItem(Item item);
	void depositMoney(int money);
	int getBalance();
	void addWish(String wish);
	
}
