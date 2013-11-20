package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.UIManager;

import business.GameLeader;
import business.IGui;

public class MainController {

	private MainController mainController = null;
	LoginView loginView = null;
	MainView mainView = null;
	IGui gameLeader = null;

	/**
	 * Main method for MainController.
	 * 
	 * @param args
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

	/**
	 * New MainView and LoginController.
	 */
	public MainController() {
		mainController = this;
		gameLeader = new GameLeader();
		loginView = new LoginView(new connectListener());
		mainView = new MainView(new playMmoveListener(), new addPlayerListener(), new exitListener());
		loginView.setVisible(true);

	}

	class connectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			gameLeader.startGame(loginView.getUserName(), loginView.getIpAddress(), Integer.parseInt(loginView.getPort()));
			loginView.setVisible(false);
			mainView.setUserName(loginView.getUserName());
			mainView.setIpAddress(loginView.getIpAddress());
			mainView.setPort(loginView.getPort());
			mainView.setVisible(true);
		}
	}

	class playMmoveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			loginView.setVisible(false);
		}
	}

	class addPlayerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			loginView.setVisible(false);
		}
	}

	class exitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			loginView.setVisible(false);
		}
	}

}
