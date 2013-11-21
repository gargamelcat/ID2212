package business;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import presentation.MainView;
import presentation.PlayerListModel;

import data.Game;
import data.IData;
import data.Mode;
import data.Move;
import data.Player;


public class GameLeader implements IGui {

	IData mainGame = null;
	ScoreCalculator scoreCalc = null;
	PeerHandler peerHandler = null;
	Sender sender = null;
	MessageProcessor messageProcessor = null;

	public GameLeader(Observer dataObserver) {
		scoreCalc = new ScoreCalculator();
		sender = new Sender();
		mainGame = new Game();
		mainGame.addObserver(dataObserver);
		messageProcessor = new MessageProcessor(this);
	}

	public void listen() {

		messageProcessor.start();
		peerHandler.start();
	}

	public void send(Player player, String message) {
		sender.sendMessageTo(player, message);
	}

	@Override
	public Player startGame(String name, String ipAddress, int port) {
		InetSocketAddress tempSocketAddr = new InetSocketAddress(ipAddress,
				port);
		Player tempPlayer = new Player(name, tempSocketAddr);
		mainGame.addPlayer(tempPlayer);
		try {
			InetSocketAddress AItempSocketAddr = new InetSocketAddress(
					InetAddress.getByName("000.000.000.000"), 0000);
			Player AI = new Player("AI", AItempSocketAddr);
			mainGame.addPlayer(AI);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		peerHandler = new PeerHandler(tempPlayer);
		listen();
		return mainGame.getPlayerBySocketAddress(tempSocketAddr);
	}

	@Override
	public synchronized void addFriend(String name, String ipAddress, int port) {
		if (mainGame.getMode() == Mode.AI) {
			mainGame.removePlayer(mainGame.getPlayerByName("AI"));
			mainGame.setMode(Mode.PVP);
		}
		InetSocketAddress tempSocketAddr = new InetSocketAddress(ipAddress,
				port);
		Player tempPlayer = new Player(name, tempSocketAddr);
		
		if(mainGame.getPlayerByName(name) == null){
			mainGame.addPlayer(tempPlayer);
			distributePlayerList(tempPlayer);
		}
	}

	public synchronized void removeFriend(String name, String ipAddress, int port) {

		try {
			mainGame.removePlayer(new Player(name, new InetSocketAddress(
					InetAddress.getByName(ipAddress), port)));
		} catch (UnknownHostException e) {
			System.out.println("could not remove following player: " + name
					+ "/" + ipAddress + "/" + port);
			e.printStackTrace();
		}
	}

	private void distributePlayerList(Player tempPlayer) {
		ArrayList<Player> tempPlayerList = mainGame.getPlayerList();

		for (int i = 0; i < tempPlayerList.size(); i++) {
			Player playerToDistribute = tempPlayerList.get(i);
			if (!tempPlayer.comparePlayerBySocketAddress(playerToDistribute)) {

				String nameToDistrubite = playerToDistribute.getName();
				String ipAddressToDistribute = playerToDistribute
						.getSocketAddress().getAddress().getHostAddress();
				String portToDistribute = Integer.toString(playerToDistribute
						.getSocketAddress().getPort());
				sender.sendMessageTo(tempPlayer, "player;add;"
						+ nameToDistrubite + ";" + ipAddressToDistribute + ";"
						+ portToDistribute + ";end");
			}
		}
	}

	@Override
	public Game getGame() {
		return mainGame.getGame();
	}

	@Override
	public synchronized void playMove(Player me, Move move) {
		// @Joel check, need to be changed, round is fix right now
		if(me.getMove() == Move.UNDEF){	
			mainGame.addMove(me.getSocketAddress(), move);
			if(mainGame.getMode() == Mode.AI) {
				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(3);
				if(randomInt == 0) mainGame.getPlayerByName("AI").setMove(Move.PAPER);
				else if (randomInt == 1) mainGame.getPlayerByName("AI").setMove(Move.ROCK);
				else if (randomInt == 2) mainGame.getPlayerByName("AI").setMove(Move.PAPER);		
				scoreCalc.calcScore(mainGame.getGame());
			}
			else {
			}
		}
	}


}
