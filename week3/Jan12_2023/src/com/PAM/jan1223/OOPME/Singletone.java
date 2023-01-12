package com.PAM.jan1223.OOPME;

public class Singletone {
	private static final String name = "안영광";
	private String position;
	private final Singletone instance = new Singletone("주임");
	
	private Singletone(String position) {
		super();
		this.position = position;
	}

	
	public Singletone getInstance() {
		return instance;
	}
	
	
	
}
