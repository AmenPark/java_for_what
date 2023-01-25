package com.PAM.JAN2523.datas;

public class weatherInfo {
	private int hour;
	private int day;
	private double temp;

	public weatherInfo() {
	}

	public weatherInfo(int hour, int day, double temp) {
		this.hour = hour;
		this.day = day;
		this.temp = temp;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setHour(String hour) {
		this.hour = Integer.parseInt(hour);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public void setDay(String day) {
		this.day = Integer.parseInt(day);
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}
	
	public void setTemp(String temp) {
		this.temp = Double.parseDouble(temp);
	}

	public void printinfo() {
		System.out.println(day + "일 뒤 " + hour + "시 온도는" + temp);
	}
	
	@Override
	public int hashCode() {
		return (day*100+hour);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.hashCode() == this.hashCode()) {
			return true;
		}else {
			return false;
		}
	}

}
