package com.PAM.jan1223.heros;

public class Herk extends Hero{
	String name;
	int age;
	int size;

	public Herk(String name, int age) {
		this.name = name;
		this.age = age;
		this.size = 99;
	}
	
	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		System.out.println(size);
	}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("고무고무~~~");
	}
	

}
