package data;

import java.util.ArrayList;

public class Round {

	private int roundNo;
	private ArrayList<Result> resultList = null;
	
	public Round(int roundNo){
		this.roundNo = roundNo;
	}
	
	public void addResult(Player player, int score){
		resultList.add(new Result(player, score));
	}
}
