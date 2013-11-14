package data;


/**
 * This interface defines every data that needs to be saved during a game.
 * @author Joel Rolli
 * @version 1.0
 */

public interface IData {

	
	/**
	 * This method will add a player to the existing game.
	 * @param An object of the new player.
	 * @return True if it worked well, false if not.
	 */	
	void addPlayer (Player newPlayer);
	
	/**
	 * This method will  update a players information. That includes the last move.
	 * @param Player with updated information.
	 * @return DTOcustomer
	 */	
	void updatePlayer(Player existingPlayer);
	
	/**
	 * This method will return an object of Game. That contains all information about an actual game.
	 * @return The actual game.
	 */	
	Game getGame();

}
