package com.PAM.jan1223.products;

public class Item {
	private String name;
	private int price;
	private String extrainfo;
	
	
	public Item(String name, int price, String extrainfo) {
		super();
		this.name = name;
		this.price = price;
		this.extrainfo = extrainfo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getExtrainfo() {
		return extrainfo;
	}


	public void setExtrainfo(String extrainfo) {
		this.extrainfo = extrainfo;
	}


	public void printinfo() {
		System.out.println(name);
		System.out.println(price);
		System.out.println(extrainfo);
	}
}
