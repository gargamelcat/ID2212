package business;

import data.Game;
import data.Move;
import data.Player;

public class GameLeader implements IGui {
	
	Game mainGame = null;
	ScoreCalculator scoreCalc = null;
	PeerHandler peerHandler = null;
	Sender sender = null;
	MessageProcessor messageProcessor = null;
	
	public GameLeader(Player player){
		scoreCalc = new ScoreCalculator();
		peerHandler = new PeerHandler(player);
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
	public void setPlayerInfo(Player me) {
		mainGame.addPlayer(me);
	}
	@Override
	public void addFriend(Player you) {
		mainGame.addPlayer(you);
	}
	@Override
	public void createGame() {
		//@Joel check
	}
	@Override
	public Game getGame() {
		return mainGame.getGame();
	}

	@Override
	public void playRound(Player me, Move move) {
		//@Joel check, need to be changed, round is fix right now
		mainGame.addMove(me.getSocketAddress(), move, 1);
	}


	@Override
	public void startGame() {
		
	}

}
