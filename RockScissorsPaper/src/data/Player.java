package data;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class Player {

	private String name = null;
	private int score = 0;
	private Move move = null;
	private InetSocketAddress socketAddress = null;

	public Player(String name, InetSocketAddress socketAddress) {
		super();
		this.name = name;
		this.score = 0;
		this.move = Move.UNDEF;
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

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public InetSocketAddress getSocketAddress() {
		return socketAddress;
	}

	public void setSocketAddress(InetSocketAddress socketAddress) {
		this.socketAddress = socketAddress;
	}

}