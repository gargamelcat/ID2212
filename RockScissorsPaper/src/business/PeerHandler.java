package business;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import data.Player;

public class PeerHandler extends Thread{

	boolean listening = true;
	ServerSocket serverSocket = null;
	Player player = null;

	public PeerHandler(Player player) {
		this.player = player;
	}

	public void run() {

		try {
			serverSocket = new ServerSocket(player.getSocketAddress().getPort());
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + player.getSocketAddress().getPort() + ".");
			System.exit(1);
		}

		try {
			System.out.println("Waiting for Connection...please wait");
			while (listening) {
				Socket clientSocket = serverSocket.accept();
				(new Peer(clientSocket)).start();
			}
			serverSocket.close();
		} catch (IOException e) {
			System.out.println("Problem in PeerListener: " + e.toString());
		}
	}

}
