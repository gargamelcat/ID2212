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
		Player playerToUpdate = getPlayerBySocketAddress(socketAddress);
		playerToUpdate.setMove(move);
		System.out.println("notify observers after adding following move"+ playerToUpdate.getName() + "/" + playerToUpdate.getMove().toString());
		dataChanged();
	}

	@Override
	public void deleteMove(InetSocketAddress socketAddress) {
		System.out.println("set all moves back to UNDEF and notify observers");
		Player playerToUpdate = getPlayerBySocketAddress(socketAddress);
		playerToUpdate.setLastMove(playerToUpdate.getMove());
		playerToUpdate.setMove(Move.UNDEF);
		dataChanged();
	}

	@Override
	public boolean didEveryonePlay() {
		boolean result = true;

		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getMove() == Move.UNDEF) {
				result = false;
			}
		}
		return result;
	}

	@Override
	public void updatePlayersScore(InetSocketAddress socketAddress, int score) {
		getPlayerBySocketAddress(socketAddress).setScore(score);
		dataChanged();
		continueWithGame();
	}

	@Override
	public synchronized ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
		dataChanged();
	}

	@Override
	public synchronized Game getGame() {
		return this;
	}

	@Override
	public Player getPlayerBySocketAddress(InetSocketAddress socketAddress) {
		Player searchedPlayer = new Player(null, socketAddress);

		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).comparePlayerBySocketAddress(searchedPlayer)) {
				searchedPlayer = playerList.get(i);
			}
		}
		if (searchedPlayer.getName() == null) {
			System.out
					.println("player with this socket address does not exist: "
							+ socketAddress.getAddress() + "/"
							+ socketAddress.getPort());
		}
		return searchedPlayer;
	}

	@Override
	public Player getPlayerByName(String name) {
		Player searchedPlayer = null;

		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getName().equals(name)) {
				searchedPlayer = playerList.get(i);
			}
		}
		if (searchedPlayer == null) {
			System.out.println("player with this name does not exist: " + name);
		}
		return searchedPlayer;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	private void dataChanged() {
		setChanged();
		notifyObservers();
	}
	
	private void continueWithGame(){
		setChanged();
		notifyObservers("continue");
	}
	
	@Override
	public void deleteScore(){
		ArrayList<Player> tempPlayerList = getPlayerList();
		
		for(int i = 0; i < tempPlayerList.size(); i++){
			tempPlayerList.get(i).setScore(0);
		}
	}
}
