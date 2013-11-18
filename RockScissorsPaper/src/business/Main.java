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
			me = new Player(4, "bliblabla", new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 4444));
			GameLeader serverLeader = new GameLeader(me);
			serverLeader.listen();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
