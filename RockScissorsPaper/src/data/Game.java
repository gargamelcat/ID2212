package data;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class Game {

	
	private ArrayList<Round> roundList = null;
	private ArrayList<Player> playerList = null;
	private int round;

	public Game() {
		playerList = new ArrayList<Player>();
		round = 1;
	}

	public void addPlayer(Player newPlayer) {
		playerList.add(newPlayer);

	}
	
	public void removePlayer(Player Player) {
		playerList.add(Player);

	}

	public void updateMove(InetSocketAddress socketAddress, Move move) {
		getPlayerBySocketAddress(socketAddress).setMove(move);
	}

	public void updatePlayersScore(InetSocketAddress socketAddress, int score) {
		getPlayerBySocketAddress(socketAddress).setScore(score);
	}

	private Player getPlayerBySocketAddress(InetSocketAddress ipAddress) {

		Player searchedPlayer = null;

		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getSocketAddress() == ipAddress) {
				searchedPlayer = playerList.get(i);
			}
		}
		return searchedPlayer;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public Game getGame() {
		return this;
	}
}
