package business;

import data.Game;
import data.Hand;
import data.Player;

public class GameLeader implements IGui {
	
	Game mainGame = null;
	ScoreCalculator scoreCalc = null;
	
	public GameLeader(){
		scoreCalc = new ScoreCalculator();
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
