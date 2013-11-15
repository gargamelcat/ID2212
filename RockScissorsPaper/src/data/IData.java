package data;

import java.net.InetAddress;


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
	 * @param score New score that will be updated.
	 */	
	void updatePlayersScore (InetAddress ipAddress, int score);
	
	
	/**
	 * This method will  update the last hand that the player played.
	 * @param Player with updated information.
	 * @return DTOcustomer
	 */	
	void updatePlayersLastHand(InetAddress ipAddress, Hand lastHand);
	
	/**
	 * This method will return an object of Game. That contains all information about an actual game.
	 * @return The actual game.
	 */	
	Game getGame();

}
