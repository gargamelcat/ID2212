package TraderGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetSocketAddress;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.UIManager;


import Client.TraderManager;
import Server.Item;
import Server.MarketPlace;

public class MainController implements Observer {

	private MainController mainController = null;
	LoginView loginView = null;
	MainView mainView = null;
	TraderManager traderManager = null;
	ProductModel productModel = null;

	/**
	 * Main method for MainController.
	 * 
	 * @param argsgame
	 */
	public static void main(String[] args) {

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println("Look and feel could not be set.");
		}

		MainController mainController = new MainController();
	}

	public MainController() {
		mainController = this;
		traderManager = new TraderManager();
		traderManager.addObserver(this);
		loginView = new LoginView(new LoginListener());
		productModel = new ProductModel();
		mainView = new MainView(new BuyItemListener(), new SellItemListener(), new ExitListener(), new UpdateListener(), new DepositMoneyListener(), new WishListener(), productModel);
		loginView.setVisible(true);
	}

	class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			traderManager.login(loginView.getUserName());
			loginView.setVisible(false);
			productModel.fireTableDataChanged();
			productModel.setItemList(traderManager.getItemList());
			mainView.setUserName(loginView.getUserName());
			mainView.setVisible(true);
		}
	}

	class SellItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String itemName = mainView.getProductName();
			int itemPrice = mainView.getProductPrice();
			if(itemName.length() >= 3 && itemPrice >= 0){
			traderManager.sellItem(new Item(itemName, itemPrice));
			productModel.setItemList(traderManager.getItemList());
			productModel.fireTableDataChanged();
			mainView.clearProductFields();
			}else{
				System.out.println("Name is less than 3 digits or price is 0. Please complete information and try again.");
			}
		}
	}

	class BuyItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = mainView.getSelectedRow();
			traderManager.buyItem(productModel.getItemInRow(row));
		}
	}
	
	class UpdateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			productModel.setItemList(traderManager.getItemList());
			productModel.fireTableDataChanged();
		}
	}

	class ExitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			traderManager.logout();
			System.exit(0);
		}
	}
	
	
	class DepositMoneyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			traderManager.depositMoney(mainView.getDeposit());
			mainView.clearDepositField();
			mainView.setBalance(traderManager.getBalance());
		}
	}	
	class WishListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			traderManager.addWish(mainView.getWish());
		}
	}	
	
	@Override
	public void update(Observable o, Object arg) {
		
		if(arg == "serverData"){
			productModel.setItemList(traderManager.getItemList());
			productModel.fireTableDataChanged();
		}else if(arg == "messageLog"){
			updateMessageLog();
		}else if(arg == "balance"){
			mainView.setBalance(traderManager.getBalance());
		}

	}

	private void updateMessageLog() {
		boolean updateDone = false;
		String tempMessage = null;
		while(updateDone == false){
			tempMessage = traderManager.getNewestLogMessage();
			if(tempMessage !=null){
				mainView.addMessageToLog(tempMessage);
			}else{
				updateDone = true;
			}
		}
	}
}