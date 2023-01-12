package com.PAM.jan1223.heros;

public class IronMan extends Hero{
	String name;
	int age;
	String sct;

	public IronMan(String name, int age) {
		this.name = name;
		this.age = age;
		this.sct = "Javis";
	}
	
	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		System.out.println(sct);
	}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("빔 발사!======>>>>>");
	}
	
	
}
