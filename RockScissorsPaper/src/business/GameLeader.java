package business;

import java.net.InetAddress;
import java.net.InetSocketAddress;

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
	public void startGame(String name, String ipAddress, int port) {
		InetSocketAddress tempSocketAddr = new InetSocketAddress(ipAddress, port);
		Player tempPlayer = new Player(name,tempSocketAddr);
		mainGame.addPlayer(tempPlayer);
		peerHandler = new PeerHandler(tempPlayer);
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
	public void playRound(Player me, Move move) {
		//@Joel check, need to be changed, round is fix right now
		mainGame.addMove(me.getSocketAddress(), move);
	}
}
