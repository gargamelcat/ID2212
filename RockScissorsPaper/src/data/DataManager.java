package data;

public class DataManager implements IData {
	
	private Game game = null;
	
	public DataManager(){
		game = new Game();
	}
	
	@Override
	public void addPlayer(Player newPlayer) {
		game.addPlayer(newPlayer);
	}

	@Override
	public void updatePlayersScore(int id, int score) {
		game.updatePlayersScore(id, score);
		
	}

	@Override
	public void updatePlayersLastHand(int id, Hand lastHand) {
		game.updatePlayersLastHand(id, lastHand);
	}
	
	@Override
	public Game getGame() {
		return game;
	}
	
}
