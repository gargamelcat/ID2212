package exerciseOne;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class simpleServer {

	public static void main(String[] args) throws IOException {
		boolean listening = true;
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(4444);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 4444.");
			System.exit(1);
		}

		while(listening) {
			Socket clientSocket = serverSocket.accept();
			(new SimpleConnectionHandler(clientSocket)).start();
		}

		serverSocket.close();
	}
}
