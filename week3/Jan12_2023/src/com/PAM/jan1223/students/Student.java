package com.PAM.jan1223.students;

public class Student {
	private int id;
	private String name;
	private int age;
	private String from;
	
	Student(int id, String name, int age, String from) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.from = from;
	}
	
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	private int getAge() {
		return age;
	}
	private void setAge(int age) {
		this.age = age;
	}
	private String getFrom() {
		return from;
	}
	private void setFrom(String from) {
		this.from = from;
	}
	
	public void printinfo() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
		System.out.println(from);
	}
}
