package business;

import data.Game;
import data.Move;

public class ScoreCalculator {

	
	public ScoreCalculator(){
		
		
	}
	
	public Game calcScore(Game game){
		
		int points = 0;
		int sizeArray = game.getPlayerList().size(); 
		for(int i = 0 ;i < sizeArray ;i++) {
			Move temp = game.getPlayerList().get(i).getMove();
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
			game.getPlayerList().get(i).setScore(points);
			points = 0;			
		}	
		
		return game;
		
	}
	
	public boolean waitMoves (Game game){
		
		boolean ready = true;		
		for(int i=0; i < game.getPlayerList().size(); i++) {
			if(game.getPlayerList().get(i).getMove() == Move.UNDEF) {
				ready = false;
			}			
		}	
		return ready;
	}
	
	
}
