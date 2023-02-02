package com.PAM.lastJaVa;

public class ScoreData {
	private String username;
	private long score;

	public ScoreData(String username, long score) {
		this.username = username;
		this.score = score;
	}

	public ScoreData(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

}
