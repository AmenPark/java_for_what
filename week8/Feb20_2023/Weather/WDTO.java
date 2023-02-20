package com.PAM.Feb202023.Weather;

public class WDTO {
	private String temp;
	private String hour;
	private String day;
	private String wfEn;
	private String wfKor;
	
	public WDTO() {
		temp = "0";
		hour = "0";
		day = "0";
		wfEn="Clear.png";
		wfKor="맑음";
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getWfEn() {
		return wfEn;
	}

	public void setWfEn(String wfEn) {
		this.wfEn = wfEn;
	}
	
	public String getWfKor() {
		return wfKor;
	}

	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}

	public String toString() {
		return (temp+"-"+hour+"-"+day+"-"+wfEn+"-"+wfKor);
	}
	
}
