package business;

import data.Game;
import data.Move;
import data.Player;


public class ScoreCalculator extends Thread {

	Game game = null;
	
	public ScoreCalculator(Game gameTemp){
		game = gameTemp;
		
	}
	
	public void run (){
		System.out.println("hello i am a thread");
		waitMoves(20000);
	}
	
	public Game calcScore(){
		
		int sizeArray = game.getPlayerList().size(); 
		for(int i = 0 ;i < sizeArray ;i++) {
			Move temp = game.getPlayerList().get(i).getMove();
			int points = game.getPlayerList().get(i).getScore();
			for(int k = 0; k < sizeArray; k++) {
				if(i != k) {
					Move other = game.getPlayerList().get(k).getMove(); 
					if(temp == Move.PAPER) {
						points += (other == Move.ROCK ? 1 : 0);
					}
					if(temp == Move.ROCK) {
						points += (other == Move.SCISSORS ? 1 : 0);
					}
					if(temp == Move.SCISSORS) {
						points += (other == Move.PAPER ? 1 : 0);
					}
				}
			}
			game.updatePlayersScore(game.getPlayerList().get(i).getSocketAddress(), points);
		}	
		for(int z = 0 ;z < sizeArray ;z++) game.addMove(game.getPlayerList().get(z).getSocketAddress(), Move.UNDEF); //Reset moves to UNDEF

		return game;
		
	}
	
	public void waitMoves (int timeOut){
		long t= System.currentTimeMillis();
		long end = t+timeOut;
		boolean ready = true;	
		while(end > System.currentTimeMillis()) {
			for(int i=0; i < game.getPlayerList().size(); i++) {
				if(game.getPlayerList().get(i).getMove()!=null){
					if(game.getPlayerList().get(i).getMove() == Move.UNDEF) {
						ready = false;
					}
				}
				if(ready){
					System.out.println("calculating score now");
					calcScore();
					end = System.currentTimeMillis() + timeOut;
				}
			}
			ready = true;
		}
	}
	
}

