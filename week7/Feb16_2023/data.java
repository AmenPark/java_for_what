package com.PAM.Feb16_2023.NumberBaseBall;

public class data {
	private int turn;
	private String log;
	private int best_score;
	
	public data() {
		super();
		turn=0;
		log="";
		best_score=0;
	}
	


	public int getTurn() {
		return turn;
	}
	public void addTurn() {
		this.turn++;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public String getLog() {
		return log;
	}
	
	public void addLog(String val, String log) {
		this.log = String.format("<tr><td>%s</td><td>%s</td></tr>", val,log) + this.log;
	}

	public void setLog(String log) {
		this.log = log;
	}


	public int getBest_score() {
		return best_score;
	}

	public void setBest_score(int best_score) {
		this.best_score = best_score;
	}
	
	
}
