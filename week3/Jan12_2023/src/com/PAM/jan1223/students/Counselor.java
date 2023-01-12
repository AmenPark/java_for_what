package com.PAM.jan1223.students;

public class Counselor {
	private int stdct;
	private static final Counselor instance = new Counselor();
	
	public static Counselor getInstance() {
		return instance;
	}
	
	public Student makeStudent(String name, int age, String from) {
		return new Student(stdct++, name, age, from);
	}
	
	
}
