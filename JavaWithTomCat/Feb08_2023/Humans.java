package com.PAM.InputOutput;

import java.util.ArrayList;

public class Humans {
	ArrayList<String> human;
	static Humans instance = new Humans();
	
	public static Humans getInstance() {
		return instance;
	}
	
	private Humans() {
		human = new ArrayList<>();
	}
	
	public void add(String name) {
		human.add(name);
	}
	
	public int getLength() {
		return human.size();
	}
	
	public String getName(int i) {
		return human.get(i);
		
	}
}
