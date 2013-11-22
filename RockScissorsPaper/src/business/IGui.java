package business;

import data.Game;
import data.Move;
import data.Player;

/**
 * This interface defines every data that the GUI layer needs to performe the game.
 * @author Joel Rolli
 * @version 1.0
 */

public interface IGui {
	
	/**
	 * This method will add a player to the game.
	 * @param An object of the new player.
	 */
	void addFriend(String name, String ipAddress, int port);

	
	/**
	 * This method will start the game.
	 * @param name Player Name.
	 * @param ipAddress Ip address of the player.
	 * @param port Port of the player.
	 * @return Player an instance of the player on this computer.
	 */
	Player startGame(String name, String ipAddress, int port);
	
	/**
	 * This method will return an object of the actual game.
	 * @param An object of the new player.
	 */
	Game getGame();
	
	/**
	 * This method will return an object of the actual game.
	 * @param Player Player that plays a move.
	 * @param Move The move that the player played.
	 */
	void playMove(Player me, Move move);
}
