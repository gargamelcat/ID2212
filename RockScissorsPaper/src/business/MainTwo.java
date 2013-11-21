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
			you = new Player( "Albert", new InetSocketAddress(InetAddress.getByName("127.0.0.1"),4445));
			otherPlayer = new Player("Joel", new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 4444));
			
			
			
			
			//GameLeader clientLeader = new GameLeader();
			
			//clientLeader.send(otherPlayer, "player;add;Albert;127.0.0.1;4445;end");
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
