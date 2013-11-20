package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetSocketAddress;

import javax.swing.UIManager;

import data.Move;
import data.Player;

import business.GameLeader;
import business.IGui;

public class MainController {

	private MainController mainController = null;
	LoginView loginView = null;
	MainView mainView = null;
	AddPlayerView addPlayerView = null;
	IGui gameLeader = null;
	Player me = null;

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
		me = new Player("temp", new InetSocketAddress(0));
		loginView = new LoginView(new connectListener());
		mainView = new MainView(new playMoveListener(),
				new addPlayerListener(), new exitListener());
		addPlayerView = new AddPlayerView(new addFriendListener(),
				new cancelListener());
		loginView.setVisible(true);

	}

	class connectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			me = gameLeader.startGame(loginView.getUserName(),
					loginView.getIpAddress(),
					Integer.parseInt(loginView.getPort()));
			loginView.setVisible(false);
			mainView.setUserName(loginView.getUserName());
			mainView.setIpAddress(loginView.getIpAddress());
			mainView.setPort(loginView.getPort());
			mainView.setVisible(true);
		}
	}

	class playMoveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (mainView.isRockSelected()) {
				gameLeader.playMove(me, Move.ROCK);
			} else if (mainView.isScissorsSelected()) {
				gameLeader.playMove(me, Move.SCISSORS);
			} else {
				gameLeader.playMove(me, Move.PAPER);
			}
		}
	}

	class addPlayerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			addPlayerView.setVisible(true);
		}
	}

	class exitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class addFriendListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}

	class cancelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			addPlayerView.setVisible(false);
		}
	}

}
