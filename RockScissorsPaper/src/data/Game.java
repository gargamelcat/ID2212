package data;

import java.util.ArrayList;

public class Game {

	ArrayList<Player> playerList = null;

	public Game() {
		playerList = new ArrayList<Player>();
	}

	public void addPlayer(Player newPlayer) {
		playerList.add(newPlayer);

	}

	public void updatePlayersLastHand(int id, Hand lastHand) {
		getPlayerById(id).setLastHand(lastHand);
	}

	public void updatePlayersScore(int id, int score) {
		getPlayerById(id).setScore(score);
	}

	private Player getPlayerById(int id) {

		Player searchedPlayer = null;

		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getId() == id) {
				searchedPlayer = playerList.get(i);
			}
		}
		return searchedPlayer;
	}
}
