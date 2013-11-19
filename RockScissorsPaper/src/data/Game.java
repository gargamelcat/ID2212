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
		playerList.add(newPlayer);
		System.out.println(newPlayer.getName());
		System.out.println(newPlayer.getSocketAddress().getAddress());
		System.out.println(newPlayer.getSocketAddress().getPort());

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
		Player searchedPlayer = null;

		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getSocketAddress() == socketAddress) {
				searchedPlayer = playerList.get(i);
			}
		}
		return searchedPlayer;
	}		// TODO Auto-generated method stub
}
