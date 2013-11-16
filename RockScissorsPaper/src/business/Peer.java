package business;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import data.MessageQueue;

import data.MessageQueue;

public class Peer extends Thread{

	private Socket clientSocket = null;
	
	
	public Peer(Socket clientSocket){
		this.clientSocket = clientSocket;
	}
	
	public void run() {
		BufferedInputStream in;
		BufferedOutputStream out;

		try {
			in = new BufferedInputStream(clientSocket.getInputStream());
			out = new BufferedOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			System.out.println(e.toString());
			return;
		}

		try {
			byte[] msg = new byte[4096];
			int bytesRead = 0;
			int n;

			while((n = in.read(msg, bytesRead, 256)) != -1) {
				bytesRead += n;
				if (bytesRead == 4096) {
					break;
				}
				if (in.available() == 0) {
					break;
				}
			}
			
			//save messages in queue
			MessageQueue.getInstance().addNewMessage(new String(msg));
			
			
			//send same message back, for debug purposes
			for(int i=0; i<bytesRead; i++) {
				out.write(msg[i]);
			}
			out.flush();

		} catch(IOException e) {
			System.out.println(e.toString());
		}

		try {
			out.close();
			in.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
