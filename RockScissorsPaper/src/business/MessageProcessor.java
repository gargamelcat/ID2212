package business;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import data.Game;
import data.MessageQueue;
import data.Move;
import data.Player;

public class MessageProcessor extends Thread {

	private Game game = null;

	public MessageProcessor(Game game) {
		this.game = game;

	}

	public void run() {
		while (true) {

			String message = null;
			while (MessageQueue.getInstance().getSize() == 0) {
			}

			message = MessageQueue.getInstance().getOldestEntry();
			System.out.println(message);

			String[] command = null;
			command = message.split(";");

			switch (command[0]) {
			case "player":
				manipulatePlayer(command);
				break;
			case "move":
				move(command);
				break;
			default:
				System.out.println("recieved illegal command");
			}

		}
	}

	private void manipulatePlayer(String[] command) {
		String name = null;
		InetSocketAddress socketAddress = null;
		String ipAddress = null;
		String portAsString = null;
		int port = 0;

		name = command[2];
		ipAddress = command[3];
		portAsString = command[4];
		port = Integer.parseInt(command[4]);

		if (command.length == 6) {
			if (command[1].equals("add")) {
				try {
					game.addPlayer(new Player(name, new InetSocketAddress(
							InetAddress.getByName(ipAddress), port)));
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
			} else if (command[1].equals("remove")) {
				try {
					game.removePlayer(new Player(name, new InetSocketAddress(
							InetAddress.getByName(ipAddress), port)));
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("The following command is corrupt: "
						+ command);
			}

		} else {
			System.out.println("The following command is corrupt: " + command);
		}
	}


	private void move(String[] command) {
		String name = null;
		InetSocketAddress socketAddress = null;
		String ipAddress = null;
		int port = 0;
		String portAsString = null;
		String moveAsString = null;
		Move move = null;
		String round = null;

		name = command[2];
		ipAddress = command[3];
		port = Integer.parseInt(command[4]);
		moveAsString = command[5];
		move = convertStringToMove(moveAsString);
		round = command[6];
		
		if(command.length == 8){
			try {
				game.addMove(new InetSocketAddress(InetAddress.getByName(ipAddress), port), move, Integer.parseInt(round));
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("The following command is corrupt: " + command);
		}
	}

	private Move convertStringToMove(String moveAsString){
		Move result = null;
		switch(moveAsString){
		case "rock":
			result = Move.ROCK;
			break;
		case "scissors":
			result = Move.SCISSORS;
			break;
		case "paper":
			result = Move.PAPER;
			break;
		default:
			System.out.println("Illegal move: " + moveAsString);
		}
		return result;
	}
}
