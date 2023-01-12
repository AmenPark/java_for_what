package com.PAM.jan1223.products;

public class Milk extends Item{
	private int expDate;

	public Milk(String name, int price, String extrainfo, int expDate) {
		super(name, price, extrainfo);
		this.expDate = expDate;
	}

	public int getExpDate() {
		return expDate;
	}

	public void setExpDate(int expDate) {
		this.expDate = expDate;
	}
	
	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		super.printinfo();
		System.out.println("******");
		System.out.println(expDate);
	}
	
	public void test() {
		System.out.println("테스트");
	}
}
