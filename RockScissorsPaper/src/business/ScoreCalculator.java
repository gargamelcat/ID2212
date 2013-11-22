package business;

import java.util.ArrayList;

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
		waitMoves(2000000);
	}
	
	public Game calcScore(){
		
		int winnerPoints = 0;
		int winnerID = -1;
		int sizeArray = game.getPlayerList().size(); 
		for(int i = 0 ;i < sizeArray ;i++) {
			Move temp = game.getPlayerList().get(i).getMove();
			//int points = game.getPlayerList().get(i).getScore();
			int points = 0;
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
			if(points > winnerPoints){
				winnerPoints = points;
				winnerID = i;
			}			
		}
		if(winnerID != -1)game.updatePlayersScore(game.getPlayerList().get(winnerID).getSocketAddress(), game.getPlayerList().get(winnerID).getScore()+1);
		for(int z = 0 ;z < sizeArray ;z++){
			game.deleteMove(game.getPlayerList().get(z).getSocketAddress()); //Reset moves to UNDEF
		}
		
		return game;
		
	}
	/**
	public void waitMoves (int timeOut){
		long t= System.currentTimeMillis();
		long end = t+timeOut;
		boolean ready = true;	
		System.out.println("START WHILE");
		while(end > System.currentTimeMillis()) {
			ArrayList<Player> tempPlayerList =  game.getPlayerList();
			for(int i=0; i < tempPlayerList.size(); i++) {
				if(tempPlayerList.get(i).getMove()!=null){
					if(tempPlayerList.get(i).getMove() == Move.UNDEF) {
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
**/
	
	public void waitMoves(int timeout){
		while(true){
			if(game.didEveryonePlay()){
				System.out.println("waitMoves is true");
				calcScore();
			}
		}
	}
}

