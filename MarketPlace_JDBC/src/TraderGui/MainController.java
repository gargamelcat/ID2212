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
	RegisterView registerView = null;
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
		loginView = new LoginView(new LoginListener(), new ShowRegisterWindowListener());
		registerView = new RegisterView(new CreateNewUserListener(), new CancelRegistrationListener());
		productModel = new ProductModel();
		mainView = new MainView(new BuyItemListener(), new SellItemListener(), new ExitListener(), new UpdateListener(), new DepositMoneyListener(), new WishListener(), productModel);
		loginView.setVisible(true);
	}

	class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(traderManager.login(loginView.getUserName(), loginView.getPassword())){
			
			loginView.setVisible(false);
			productModel.fireTableDataChanged();
			productModel.setItemList(traderManager.getItemList());
			mainView.setUserName(loginView.getUserName());
			mainView.setVisible(true);
			}
			else{
				loginView.deleteTextFields();
				System.out.println("Password or user name is wrong. Try again.");
			}
		}
	}

	
	
	class ShowRegisterWindowListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			loginView.setVisible(false);
			registerView.setVisible(true);	
		}
	}
	
	class CreateNewUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(traderManager.registerUser(registerView.getUserName(), registerView.getPassword())){
			
			registerView.setVisible(false);
			productModel.fireTableDataChanged();
			productModel.setItemList(traderManager.getItemList());
			mainView.setUserName(registerView.getUserName());
			mainView.setVisible(true);
			}
			else{
				registerView.deleteTextFields();
				System.out.println("Could not register user. Name may be used already.");
			}
		}
	}
	
	class CancelRegistrationListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			loginView.setVisible(true);
			registerView.setVisible(false);	
		}
	}

	class SellItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String itemName = mainView.getProductName();
			int itemPrice = mainView.getProductPrice();
			int amount = mainView.getAmount();
			if(itemName.length() >= 3 && itemPrice >= 1 && amount >= 1){
			traderManager.sellItem(new Item(itemName, itemPrice, amount));
			productModel.setItemList(traderManager.getItemList());
			productModel.fireTableDataChanged();
			mainView.clearProductFields();
			}else{
				System.out.println("Name is less than 3 digits or price/amount is 0. Please complete information and try again.");
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