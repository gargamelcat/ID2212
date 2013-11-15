package business;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import javax.swing.text.PlainDocument;

import data.Player;

public class MainTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player you = null;
		Player otherPlayer = null;
		try {
			//you = new Player(1, "listener", 4445, InetAddress.getByName("127.0.0.1"));
			otherPlayer = new Player(4, "bliblabla", 4444, InetAddress.getByName("127.0.0.1"));
			GameLeader clientLeader = new GameLeader(otherPlayer);
			clientLeader.send(otherPlayer, "hallo du depp");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
