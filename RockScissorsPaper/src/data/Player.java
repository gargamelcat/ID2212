package data;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class Player {

	private String name = null;
	private int score = 0;
	private Hand hand = null;
	private InetSocketAddress socketAddress = null;

	public Player(int id, String name, InetSocketAddress socketAddress) {
		super();
		this.name = name;
		this.score = 0;
		this.hand = Hand.UNDEF;
		this.socketAddress = socketAddress;
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

	public InetSocketAddress getSocketAddress() {
		return socketAddress;
	}

	public void setSocketAddress(InetSocketAddress socketAddress) {
		this.socketAddress = socketAddress;
	}

}