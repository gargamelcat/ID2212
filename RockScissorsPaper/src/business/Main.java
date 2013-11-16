package business;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import javax.swing.text.PlainDocument;

import data.Player;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Player me;
		try {
			me = new Player(1, "listener", 4444, InetAddress.getLocalHost());
			GameLeader serverLeader = new GameLeader(me);
			serverLeader.listen();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
