package com.PAM.Jan012023.packagetest;

public class Laptop extends Computer{
	double weight;
	int capacity;
	public Laptop(String name, int price, String cpu, int ram, int hdd, double weight, int capacity) {
		super(name, price, cpu, ram, hdd);
		this.weight = weight;
		this.capacity = capacity;
	}
	
	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		super.printinfo();
		System.out.println(weight);
		System.out.println(capacity);
	}
}
