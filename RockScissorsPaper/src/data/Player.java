package data;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.util.ArrayList;

public class Player {

	private String name = null;
	private int score = 0;
	private Hand hand = null;
	private int port;
	private InetAddress ipAddress = null;
	
	public Player(int id, String name, int port,
			InetAddress ipAddress) {
		super();
		this.name = name;
		this.score = 0;
		this.hand = Hand.UNDEF;
		this.port = port;
		this.ipAddress = ipAddress;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Hand getLastHand() {
		return hand;
	}

	public void setLastHand(Hand lastHand) {
		this.hand = lastHand;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public InetAddress getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(InetAddress ipAddress) {
		this.ipAddress = ipAddress;
	}
	
}