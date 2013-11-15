package business;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import data.Player;

public class PeerHandler {

	boolean listening = true;
	ServerSocket serverSocket = null;
	Player player = null;

	public PeerHandler(Player player) {
		this.player = player;
	}

	public void listen() {

		try {
			serverSocket = new ServerSocket(player.getPort());
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + player.getPort() + ".");
			System.exit(1);
		}

		try {
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
