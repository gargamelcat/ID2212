package data;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Observer;


/**
 * This interface defines every data that needs to be saved during a game.
 * @author Joel Rolli
 * @version 1.0
 */

public interface IData {

	
	/**
	 * This method will add a player to the existing 
	 * @param An object of the new player.
	 * @return True if it worked well, false if not.
	 */	
	void addPlayer (Player newPlayer);
	
	void removePlayer (Player Player);

		/**
	 * This method will update the score of a player with IP address given by parameter.
	 * @param id Id of the player that has to be updated.
	 * @param score New sbcore that will be updated.
	 */	
	void updatePlayersScore (InetSocketAddress socketAddress, int score);
	
	
	/**
	 * This method will  update the move that the player played.
	 * @param round TODO
	 * @param Player with updated information.
	 * @return DTOcustomer
	 */	
	void addMove(InetSocketAddress socketAddress, Move move);
	
	/**
	 * This method will return an object of Game. That contains all information about an actual game.
	 * @return The actual game.
	 */	
	Game getGame();

		/**
	 * This method will return a player list of all players that play the game right now.
	 * @return  ArrayList<Player> Arraylist with all players.
	 */	
	ArrayList<Player> getPlayerList();
	
		/**
	 * Returns a player that is identified by his socket address.
	 * @param InetSocketAddress Socket address of the player you are looking for.
	 * @return Player you are looking for.
	 */	
	Player getPlayerBySocketAddress(InetSocketAddress socketAddress);
	
	
		/**
	 * Returns a player taht is identified by name given by parameter.
	 * @param name Name of the player you are looking for.
	 * @return Player you are looking for.
	 */	
	Player getPlayerByName(String name);
	
		/**
	 * This method returns the actual playing mode. Player versus player or Player versus AI.
	 * @return Returns the mode.
	 */	
	Mode getMode();
	
		/**
	 * Sets the game mode. AI or PVP
	 * @param Game mode.
	 */	
	void setMode(Mode mode);
	
		/**
	 * This method adds an observer to the data model. As soon some data changes, this observer will be notified.
	 * @param Observer
	 */	
	void addObserver(Observer observer);
	
		/**
	 * This method sets the move back to UNDEF for the player with the socket address given by parameter.
	 * @param Socketaddress
	 */	
	void deleteMove(InetSocketAddress socketAddress);

			/**
	 * This method deletes the score for all players
	 * @param Socketaddress
	 */	
	void deleteScore();
	
	
	
		/**
	 * This method checks if everyone did play during this round.
	 * @return Boolean if everyone has played.
	 */	
	boolean didEveryonePlay();
	
	
	
}