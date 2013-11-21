package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetSocketAddress;
import java.util.Observable;
import java.util.Observer;

import javax.swing.UIManager;

import data.Move;
import data.Player;

import business.GameLeader;
import business.IGui;

public class MainController implements Observer {

	private MainController mainController = null;
	LoginView loginView = null;
	MainView mainView = null;
	AddFriendView addFriendView = null;
	IGui gameLeader = null;
	PlayerListModel playerListModel = null;
	Player me = null;

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

	/**
	 * New MainView and LoginController.
	 */
	public MainController() {
		mainController = this;
		gameLeader = new GameLeader(this);
		me = new Player("temp", new InetSocketAddress(0));
		loginView = new LoginView(new connectListener());
		playerListModel = new PlayerListModel();
		mainView = new MainView(new playMoveListener(),
				new addPlayerListener(), new exitListener(), playerListModel);
		addFriendView = new AddFriendView(new addFriendListener(),
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
			
			playerListModel.setGame(gameLeader.getGame());
			System.out.println(playerListModel.getValueAt(0, 0));
			System.out.println(playerListModel.getValueAt(0, 1));
			System.out.println(playerListModel.getValueAt(0, 2));
			System.out.println(playerListModel.getValueAt(0, 3));
			System.out.println(playerListModel.getValueAt(0, 4));
			playerListModel.fireTableDataChanged();
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
			mainView.setVisible(false);
			addFriendView.setVisible(true);
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
			System.out.println("direct from playerView: "+addFriendView.getName());
			System.out.println("direct from playerView: "+addFriendView.getIpAddress());
			System.out.println("direct from playerView: "+addFriendView.getPort());
			
			gameLeader.addFriend(addFriendView.getName(), addFriendView.getIpAddress(), Integer.parseInt(addFriendView.getPort()));
			addFriendView.setVisible(false);
			mainView.setVisible(true);
		}
	}

	class cancelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			addFriendView.setVisible(false);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		playerListModel.setGame(gameLeader.getGame());
		playerListModel.fireTableDataChanged();
		System.out.println("observed some changes hoho");
		
	}

}
