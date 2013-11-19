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
		if (args.length == 3){
			try {
				me = new Player(args[0], new InetSocketAddress(InetAddress.getByName(args[1]), Integer.parseInt(args[2])));
				//GameLeader serverLeader = new GameLeader(me);
				//serverLeader.listen();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		else System.out.println("This programs needs three argumenst to start the game: Player_name IP PORT");
	}

}
