package com.PAM.jan1223.cars;

public class Car {
	private String name;
	private int idnum;


	Car(String name, int idnum) {
		super();
		this.name = name;
		this.idnum = idnum;
	}
	
	public void printinfo(){
		System.out.println(name);
		System.out.println(idnum);
	}
}