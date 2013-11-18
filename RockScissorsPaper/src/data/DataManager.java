package data;

import java.net.InetAddress;
import java.net.InetSocketAddress;

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
	public void removePlayer(Player Player) {
		game.removePlayer(Player);
	}
	
	@Override
	public void updatePlayersScore(InetSocketAddress socketAddress, int score) {
		game.updatePlayersScore(socketAddress, score);
		
	}

	@Override
	public void updateMove(InetSocketAddress socketAddress, Move move) {
		game.updateMove(socketAddress, move);
	}
	
	@Override
	public Game getGame() {
		return game;
	}

	
}
