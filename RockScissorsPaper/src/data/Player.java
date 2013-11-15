package data;

public class Player {

	private String name = null;
	private int score = 0;
	private Hand hand = null;
	private int port;
	private String ipAddress = null;
	
	public Player(int id, String name, int port,
			String ipAddress) {
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

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}