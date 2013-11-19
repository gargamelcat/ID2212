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
			you = new Player( "listener", new InetSocketAddress(InetAddress.getByName("127.0.0.1"),4344));
			otherPlayer = new Player("bliblabla", new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 4444));
			
			
			
			
			if(you.getSocketAddress().getPort() == otherPlayer.getSocketAddress().getPort()&& you.getSocketAddress().getAddress().equals(otherPlayer.getSocketAddress().getAddress())){
				System.out.println("gleich");
			}else{
				System.out.println("nicht gleich");
			}
				
			System.out.println(you.getSocketAddress().getAddress());
			System.out.println(otherPlayer.getSocketAddress().getAddress());
			//GameLeader clientLeader = new GameLeader(otherPlayer);
			
			//clientLeader.send(otherPlayer, "player;add;joel;127.0.0.1;4444;end");
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
