package data;

import java.net.InetAddress;

public class DataManager implements IData {
	
	private Game game = null;
	
	public DataManager(){
		game = new Game();
	}
	
	@Override
	public void addPlayer(Player newPlayer) {
		game.addPlayer(newPlayer);
	}

	@Override
	public void updatePlayersScore(InetAddress ipAddress, int score) {
		game.updatePlayersScore(ipAddress, score);
		
	}

	@Override
	public void updatePlayersLastHand(InetAddress ipAddress, Hand lastHand) {
		game.updatePlayersLastHand(ipAddress, lastHand);
	}
	
	@Override
	public Game getGame() {
		return game;
	}
}
