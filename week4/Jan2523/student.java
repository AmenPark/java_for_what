package com.PAM.JAN2523.UC;

public class student {
	private String name;
	private int kr;
	private int eng;
	private int math;
	
	
	public String getName() {
		return name;
	}
	

	public student(String name, int kr, int eng, int math) {
		this.name = name;
		this.kr = kr;
		this.eng = eng;
		this.math = math;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKr() {
		return kr;
	}


	public void setKr(int kr) {
		this.kr = kr;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public void printinfo() {
		System.out.println(name);
		System.out.println(kr+" " + eng + " " + math);
	}
}
