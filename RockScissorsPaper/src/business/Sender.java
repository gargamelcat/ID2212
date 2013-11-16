package business;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import data.Player;

public class Sender {

	Socket clientSocket = null;

	public Sender() {

	}

	public void sendMessageTo(Player player, String message) {

		try {
			clientSocket = new Socket(player.getIpAddress(), player.getPort());
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: "
					+ player.getIpAddress() + ".");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: "
					+ player.getIpAddress() + "");
			System.exit(1);
		}

		BufferedInputStream in = null;
		BufferedOutputStream out = null;

		try {
			in = new BufferedInputStream(clientSocket.getInputStream());
			out = new BufferedOutputStream(clientSocket.getOutputStream());

			byte[] toServer = message.getBytes();
			out.write(toServer, 0, toServer.length);
			out.flush();

			byte[] fromServer = new byte[toServer.length];
			int n = in.read(fromServer, 0, fromServer.length);
			if (n != fromServer.length) {
				System.out.println("Some data are lost ...");
			}

			out.close();
			in.close();
			clientSocket.close();
		} catch (IOException e) {
			System.out.println(e.toString());
			System.exit(1);
		}
	}
}
