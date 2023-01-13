package com.PAM.testPack;

public class Student extends Human{
	private int sid;

	public Student(String name, int sid) {
		super(name);
		this.sid = sid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
}
