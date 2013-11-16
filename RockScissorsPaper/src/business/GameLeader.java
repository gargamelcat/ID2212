package business;

import data.Game;
import data.Hand;
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
		messageProcessor = new MessageProcessor();
		messageProcessor.start();
	}
	
	public void listen(){
		
		peerHandler.listen();
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
		mainGame = new Game();
	}
	@Override
	public Game getGame() {
		return mainGame.getGame();
	}

	@Override
	public void playRound(Player me, Hand hand) {
		
		mainGame.updatePlayersLastHand(me.getIpAddress(), hand);
	}


	@Override
	public void startGame() {
		
	}

}
