package business;

import data.Game;
import data.Hand;

public class ScoreCalculator {

	
	public ScoreCalculator(){
		
		
	}
	
	public Game calcScore(Game game){
		
		int points = 0;
		int sizeArray = game.getPlayerList().size(); 
		for(int i = 0 ;i < sizeArray ;i++) {
			Hand temp = game.getPlayerList().get(i).getLastHand();
			for(int k = 0; k < sizeArray; k++) {
				if(i != k) {
					Hand other = game.getPlayerList().get(k).getLastHand(); 
					if(temp == Hand.PAPER) {
						points += (other == Hand.ROCK ? 1 : 0);
					}
					if(temp == Hand.ROCK) {
						points += (other == Hand.SCISSORS ? 1 : 0);
					}
					if(temp == Hand.SCISSORS) {
						points += (other == Hand.PAPER ? 1 : 0);
					}
				}
			}
			game.getPlayerList().get(i).setScore(points);
			points = 0;			
		}	
		
		return game;
		
	}
	
	public boolean waitMoves (Game game){
		
		boolean ready = true;		
		for(int i=0; i < game.getPlayerList().size(); i++) {
			if(game.getPlayerList().get(i).getLastHand() == Hand.UNDEF) {
				ready = false;
			}			
		}
		
		return ready;
	}
	
	
}
