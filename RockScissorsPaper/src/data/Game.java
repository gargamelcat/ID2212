package data;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Observable;

public class Game extends Observable implements IData {

	private ArrayList<Player> playerList = null;
	private Mode mode = null;

	public Game() {
		playerList = new ArrayList<Player>();
		mode = Mode.AI;
	}

	@Override
	public void addPlayer(Player newPlayer) {
		newPlayer.setScore(0);
		newPlayer.setMove(Move.UNDEF);
		playerList.add(newPlayer);
		dataChanged();
	}

	@Override
	public void removePlayer(Player player) {
		playerList.remove(player);
		dataChanged();
	}

	@Override
	public void addMove(InetSocketAddress socketAddress, Move move) {
		getPlayerBySocketAddress(socketAddress).setMove(move);
		dataChanged();
	}

	@Override
	public void updatePlayersScore(InetSocketAddress socketAddress, int score) {
		getPlayerBySocketAddress(socketAddress).setScore(score);
		dataChanged();
	}

	@Override
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
		dataChanged();
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
	
	@Override
	public Player getPlayerByName(String name){
		Player searchedPlayer = new Player();

		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getName().equals(name)) {
				searchedPlayer = playerList.get(i);
			}
		}
		if(searchedPlayer == null){
			System.out.println("player with this name does not exist: " + name );
		}
		return searchedPlayer;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode){
		this.mode = mode;
	}
	
	private void dataChanged(){
		setChanged();
		notifyObservers();
		System.out.println("notified the observers right noww");
	}
}
