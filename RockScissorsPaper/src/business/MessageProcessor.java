package business;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import data.Game;
import data.IData;
import data.MessageQueue;
import data.Move;
import data.Player;

public class MessageProcessor extends Thread {

	private GameLeader gameLeader = null;

	public MessageProcessor(GameLeader gameLeader) {
		this.gameLeader = gameLeader;

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
		
		System.out.println("messageProcessor got name: " + name);
		System.out.println("messageProcessor got address: " + ipAddress);
		System.out.println("messageProcessor got address: " + port);
		
		
		if (command.length == 6) {
			if (command[1].equals("add")) {
					gameLeader.addFriend(name, ipAddress, port);
					System.out.println("yeeeaaah i got the message: "+ name + "/" + ipAddress + "/"+ port);
			} else if (command[1].equals("remove")) {
					gameLeader.removeFriend(name, ipAddress, port);
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

		name = command[1];
		ipAddress = command[2];
		port = Integer.parseInt(command[3]);
		moveAsString = command[4];
		move = convertStringToMove(moveAsString);
		round = command[5];
		
		if(command.length == 6){
			try {
				InetSocketAddress tempSocketAddress = new InetSocketAddress(InetAddress.getByName(ipAddress), port);
				gameLeader.playMove(gameLeader.getGame().getPlayerBySocketAddress(tempSocketAddress), move);
				System.out.println("yeaahh2 got move"+ move);
			} catch (UnknownHostException e) {
				System.out.println("Following socket address is corrupt"+ ipAddress + "/" + port);
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
