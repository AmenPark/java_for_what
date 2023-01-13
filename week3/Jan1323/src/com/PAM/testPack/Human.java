package com.PAM.testPack;

public class Human {
	private String name;
	private Hero hero;

	public Human(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public void scream() {
		this.hero.attack();
	}
	
	
}
