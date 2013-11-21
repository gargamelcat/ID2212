package data;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class Game implements IData {

	private ArrayList<Player> playerList = null;

	public Game() {
		playerList = new ArrayList<Player>();
	}

	@Override
	public void addPlayer(Player newPlayer) {
		newPlayer.setScore(0);
		newPlayer.setMove(Move.UNDEF);
		playerList.add(newPlayer);

	}

	@Override
	public void removePlayer(Player player) {
		playerList.remove(player);
	}

	@Override
	public void addMove(InetSocketAddress socketAddress, Move move) {
		getPlayerBySocketAddress(socketAddress).setMove(move);
	}

	@Override
	public void updatePlayersScore(InetSocketAddress socketAddress, int score) {
		getPlayerBySocketAddress(socketAddress).setScore(score);
	}

	@Override
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	@Override
	public Game getGame() {
		return this;
	}

	@Override
	public Player getPlayerBySocketAddress(InetSocketAddress socketAddress) {
		Player searchedPlayer = new Player(null , socketAddress);

		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).comparePlayerBySocketAddress(searchedPlayer)) {
				searchedPlayer = playerList.get(i);
			}
		}
		if(searchedPlayer.getName() == null){
			System.out.println("player with this socket address does not exist: "+ socketAddress.getAddress()+"/"+socketAddress.getPort());
		}
		return searchedPlayer;
	}
}
