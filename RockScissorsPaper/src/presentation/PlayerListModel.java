package presentation;

import javax.swing.table.AbstractTableModel;

import data.Game;
import data.IData;

public class PlayerListModel extends AbstractTableModel {

	private IData game = null;

	public PlayerListModel() {
		game = new Game();
	}

	public IData getGame() {
		return game;
	}

	public void setGame(IData game) {
		this.game = game;
		System.out.println("in player list model: " + this.game.getPlayerList().get(0).getName());
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		game.getPlayerList().size();
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String result = null;
		int temp;
		
		switch(columnIndex){
		case 0:
			result = game.getPlayerList().get(rowIndex).getName();
			break;
		case 1:
			result = game.getPlayerList().get(rowIndex).getSocketAddress().getHostString().toString();
			break;
		case 2:
			temp = game.getPlayerList().get(rowIndex).getSocketAddress().getPort();
			result = Integer.toString(temp);
			break;
		case 3:
			temp = game.getPlayerList().get(rowIndex).getScore();
			result = Integer.toString(temp);
			break;
		case 4:
			result = game.getPlayerList().get(rowIndex).getMove().toString();
			break;
		default:
			throw new IllegalArgumentException(String.format("Column {0} does not exist", columnIndex));	
		}
		return result;
	}
	
    public String getColumnName(int column) {
        switch (column) {
        case 0:
            return "Name.";
        case 1:
            return "Ip address";
        case 2:
            return "Port";
        case 3:
            return "Score";
        case 4:
            return "Move";
        default: 
            throw new IllegalArgumentException(String.format("Column {0} does not exist", column));
        }
    }	

}
