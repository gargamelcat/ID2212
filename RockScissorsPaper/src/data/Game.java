package data;

import java.net.InetAddress;
import java.util.ArrayList;

public class Game {

	private ArrayList<Player> playerList = null;
	private int round;

	public Game() {
		playerList = new ArrayList<Player>();
		round = 1;
	}

	public void addPlayer(Player newPlayer) {
		playerList.add(newPlayer);

	}

	public void updatePlayersLastHand(InetAddress ipAddress, Hand lastHand) {
		getPlayerByAddress(ipAddress).setLastHand(lastHand);
	}

	public void updatePlayersScore(InetAddress ipAddress, int score) {
		getPlayerByAddress(ipAddress).setScore(score);
	}

	private Player getPlayerByAddress(InetAddress ipAddress) {

		Player searchedPlayer = null;

		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getIpAddress() == ipAddress) {
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
}
