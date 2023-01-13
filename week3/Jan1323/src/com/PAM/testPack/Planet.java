package com.PAM.testPack;

public class Planet {
	private String name;
	private int size;
	private boolean observable;
	private Human resident;
	
	
	public Planet(String name) {
		super();
		this.name = name;
	}

	public Planet(String name, int size, boolean observable) {
		super();
		this.name = name;
		this.size = size;
		this.observable = observable;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isObservable() {
		return observable;
	}
	public void setObservable(boolean observable) {
		this.observable = observable;
	}
	
	public void enroll(Human h) {
		this.resident = h;
		System.out.println(resident.getName()+"이 등록했다");
	}
	
	
}
