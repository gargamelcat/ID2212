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
			//you = new Player( "listener", 4445, InetAddress.getByName("127.0.0.1"));
			otherPlayer = new Player("bliblabla", new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 4444));
			GameLeader clientLeader = new GameLeader(otherPlayer);
			
			clientLeader.send(otherPlayer, "hallo du depp");
			clientLeader.send(otherPlayer, "hallo du gschide siech");
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
