package data;

public class Result {
	
	private Player player = null;
	private int roundScore;
	
	public Result(Player player, int roundScore){
		this.player = player;
		this.roundScore = roundScore;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getRoundScore() {
		return roundScore;
	}

	public void setRoundScore(int roundScore) {
		this.roundScore = roundScore;
	}

	
	
}
