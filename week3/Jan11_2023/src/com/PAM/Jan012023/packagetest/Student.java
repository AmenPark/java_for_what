package com.PAM.Jan012023.packagetest;

public class Student {
	String name;
	int age;
	static Coffee CoffeMachine = new Coffee("커피123", 300000);
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public static void drinkCoffee() {
		CoffeMachine.make();
	}
}
