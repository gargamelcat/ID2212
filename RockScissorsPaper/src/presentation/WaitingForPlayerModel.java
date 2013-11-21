package presentation;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import data.Game;
import data.IData;
import data.Move;
import data.Player;



public class WaitingForPlayerModel extends AbstractTableModel {

	private IData game = null;

	public WaitingForPlayerModel() {
		game = new Game();
	}

	public IData getGame() {
		return game;
	}

	public void setGame(IData game) {
		this.game = game;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		//int waitingForPlayerCount = 0;
		
		ArrayList<Player> tempPlayerList = game.getPlayerList();

		/**
		for(int i = 0; i < tempPlayerList.size(); i++){
			if(tempPlayerList.get(i).getMove()== Move.UNDEF){
				waitingForPlayerCount++;
			}
		}
		return waitingForPlayerCount;
		
		**/
		
		return tempPlayerList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	
		ArrayList<Player> tempPlayerList = game.getPlayerList();
		
		/**	String name = null;
			
		for(int i = 0; i < tempPlayerList.size();i++){
			if(tempPlayerList.get(i).getMove()== Move.UNDEF && rowIndex == 0){
				name = tempPlayerList.get(i).getName();
			}
		}
		return name;
		
		**/
	
		return tempPlayerList.get(rowIndex);
	}
	
    public String getColumnName(int column) {
    	return "name";
    }	

}
