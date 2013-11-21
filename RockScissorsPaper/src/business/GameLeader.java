package business;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import data.Game;
import data.IData;
import data.Move;
import data.Player;

public class GameLeader implements IGui {
	
	IData mainGame = null;
	ScoreCalculator scoreCalc = null;
	PeerHandler peerHandler = null;
	Sender sender = null;
	MessageProcessor messageProcessor = null;
	
	public GameLeader(){
		scoreCalc = new ScoreCalculator();
		sender = new Sender();
		mainGame = new Game();
		messageProcessor = new MessageProcessor(mainGame);
	}
	
	public void listen(){
		
		messageProcessor.start();
		peerHandler.start();
	}
	
	
	public void send(Player player, String message){
		sender.sendMessageTo(player, message);
	}
	
	@Override
	public Player startGame(String name, String ipAddress, int port) {
		InetSocketAddress tempSocketAddr = new InetSocketAddress(ipAddress, port);
		Player tempPlayer = new Player(name,tempSocketAddr);
		mainGame.addPlayer(tempPlayer);
		try {
			InetSocketAddress AItempSocketAddr = new InetSocketAddress(InetAddress.getByName("000.000.000.000"), 0000);
			Player AI = new Player("AI",AItempSocketAddr);
			mainGame.addPlayer(AI);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		peerHandler = new PeerHandler(tempPlayer);
		return mainGame.getPlayerBySocketAddress(tempSocketAddr);
	}
	
		@Override
	public void addFriend(String name, String ipAddress, int port) {
		InetSocketAddress tempSocketAddr = new InetSocketAddress(ipAddress, port);
		Player tempPlayer = new Player(name,tempSocketAddr);
		mainGame.addPlayer(tempPlayer);
	}
		
	@Override
	public Game getGame() {
		return mainGame.getGame();
	}

	@Override
	public void playMove(Player me, Move move) {
		//@Joel check, need to be changed, round is fix right now
		mainGame.addMove(me.getSocketAddress(), move);
	}
}
