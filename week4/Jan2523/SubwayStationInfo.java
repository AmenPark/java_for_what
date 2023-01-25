package com.PAM.JAN2523.datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 하루 쉬고 들어옴. arraylist, socket을 구현했던것 같음. 쓰레드를 이용해본듯?
 */

public class SubwayStationInfo {
	private Date date;
	private String subwayline;
	private String stationName;
	private int get_on;
	private int get_off;
	
	public SubwayStationInfo() {
	}

	public SubwayStationInfo(String subwayline) throws ParseException {
		String[] line2 = subwayline.split("\t");
		String when2 = line2[0] + line2[1] + line2[2];
		date = new SimpleDateFormat("yyyMMdd").parse(when2);
		this.subwayline = line2[3];
		this.stationName = line2[4];
		
		get_on = Integer.parseInt(line2[5]);
		get_off = Integer.parseInt(line2[6]);
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubwayline() {
		return subwayline;
	}

	public void setSubwayline(String subwayline) {
		this.subwayline = subwayline;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getGet_on() {
		return get_on;
	}

	public void setGet_on(int get_on) {
		this.get_on = get_on;
	}

	public int getGet_off() {
		return get_off;
	}

	public void setGet_off(int get_off) {
		this.get_off = get_off;
	}
	
	public void print() {
		System.out.println(new SimpleDateFormat("yyyy/MM/dd(E)").format(date));
		System.out.println(this.stationName);
		System.out.println(this.subwayline);
		System.out.println(this.stationName);
		System.out.println("탄 사람 수 : "+this.get_on);
		System.out.println("내린 사람 수: "+this.get_off);
		System.out.println("---------------");
	}
	
	
	
}
