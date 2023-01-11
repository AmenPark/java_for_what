package com.PAM.Jan012023.packagetest;

public class Coffee {
	String modelName;
	int price;
	public Coffee(String modelName, int price) {
		super();
		this.modelName = modelName;
		this.price = price;
	}
	
	public void make() {
		System.out.println("커피만들기 하는중");
	}
}
