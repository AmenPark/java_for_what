package com.PAM.lastJaVa;

public class User {
	private int no;
	private String ip;
	private String name;
	public User() {
	}
	public User(String ip, String name) {
		this.ip = ip;
		this.name = name;
	}
	public User(int no, String ip, String name) {
		this.no = no;
		this.ip = ip;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
