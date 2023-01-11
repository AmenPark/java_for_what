package com.PAM.Jan012023.packagetest;

public class accessRestrictedHuman {
	private String name;
	private int age;
	public accessRestrictedHuman(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void printinfo() {
		System.out.println(name);
		System.out.println(age);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
