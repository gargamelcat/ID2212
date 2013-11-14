package business;

import data.Game;
import data.Player;

/**
 * This interface defines every data that the GUI layer needs to performe the game.
 * @author Joel Rolli
 * @version 1.0
 */

public interface IGui {
	
	/**
	 * This method will set the player information about the player on this computer.
	 * @param An object of the new player.
	 */
	void setPlayerInfo(Player me);
	
	/**
	 * This method will add a player to the game.
	 * @param An object of the new player.
	 */
	void addFriend(Player you);

	/**
	 * This method will start a new game.
	 * @param An object of the new player.
	 */
	void startGame();

	/**
	 * This method will return an object of the actual game.
	 * @param An object of the new player.
	 */
	Game getGame();
}