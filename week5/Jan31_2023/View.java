package com.PAM.oopMain;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	private Scanner _in;
	public View() {
		_in = new Scanner(System.in);
	}
	
	public restArea getInfo () throws Exception {
		System.out.print("이름");
		String name = _in.next();
		System.out.print("방향");
		String arrow = _in.next();
		System.out.print("위치");
		String loc = _in.next();
		System.out.print("차량숫자");
		int parkingnum = _in.nextInt();
		restArea rt = new restArea(name,arrow,loc,parkingnum);
		return rt;
	}
	
	public void destroy() {
		_in.close();
	}
	
	public void print(restArea data) {
		System.out.printf("%s, %s, %s, %d\n", data.getName(), data.getArrow(), data.getLocation(), data.getParkingnum());
	}
	
	public void print(ArrayList<restArea> rA) {
		for (restArea restArea : rA) {
			this.print(restArea);
		}
	}
}
