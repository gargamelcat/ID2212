package presentation;

import javax.swing.table.AbstractTableModel;

import data.IData;

public class PlayerListModel extends AbstractTableModel {

	private IData game = null;

	public PlayerListModel() {

	}

	public IData getGame() {
		return game;
	}

	public void setGame(IData game) {
		this.game = game;
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
		
		switch(columnIndex){
		case 0:
			game.getPlayerList().get(rowIndex).getName();
			break;
		case 1:
			game.getPlayerList().get(rowIndex).getSocketAddress().getAddress();
			break;
		case 2:
			game.getPlayerList().get(rowIndex).getSocketAddress().getPort();
			break;
		case 3:
			game.getPlayerList().get(rowIndex).getScore();
			break;
		case 4:
			game.getPlayerList().get(rowIndex).getMove();
			break;
		default:
			throw new IllegalArgumentException(String.format("Column {0} does not exist", columnIndex));	
		}
		
		return null;
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
