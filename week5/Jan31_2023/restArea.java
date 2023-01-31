package com.PAM.oopMain;

public class restArea {
	private String name;
	private String arrow;
	private String location;
	private int parkingnum;
	
	public restArea() {
	}

	public restArea(String name, String arrow, String location, int parkingnum) {
		super();
		this.name = name;
		this.arrow = arrow;
		this.location = location;
		this.parkingnum = parkingnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArrow() {
		return arrow;
	}

	public void setArrow(String arrow) {
		this.arrow = arrow;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getParkingnum() {
		return parkingnum;
	}

	public void setParkingnum(int parkingnum) {
		this.parkingnum = parkingnum;
	}
	
	
}
