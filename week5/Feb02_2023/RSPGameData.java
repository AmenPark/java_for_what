package com.PAM.lastJaVa;

import java.util.Date;

public class RSPGameData {
	public static final String[] CHOICE2STRING = {"","Rock", "Scissors", "Paper"};
	private User user;
	private Date date;
	private int user_choice;		//1,2,3
	private int com_choice;			//1,2,3
	private long bat;
	private long score;
	private int round;
	private int no;
	
	
	
	public RSPGameData(User user) {
		this.user = user;
		this.date = new Date();
		bat = 5;
		score = 50;
		round = 1;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	public int getRound() {
		return round;
	}
	public void addRound() {
		round++;
		if (bat<round) {
			bat = round;
		}
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUser_choice() {
		return user_choice;
	}
	public void setUser_choice(int user_choice) {
		this.user_choice = user_choice;
	}
	public int getCom_choice() {
		return com_choice;
	}
	public void setCom_choice(int com_choice) {
		this.com_choice = com_choice;
	}
	public long getBat() {
		return bat;
	}
	public void setBat(long bat) {
		if (bat <= score & bat >= round) {
			this.bat = bat;
		}
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
}
