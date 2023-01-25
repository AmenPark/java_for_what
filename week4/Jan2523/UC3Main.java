package com.PAM.JAN2523.UC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UC3Main {
	public static void main(String[] args) {
		Scanner _in = new Scanner(System.in);
		System.out.print("번호 : ");
		int n = _in.nextInt();
		
		ArrayList<student> stds = new ArrayList<>();
		stds.add(new student("홍길동", 100, 50, 80));
		stds.add(new student("박길동", 80, 70, 90));
		stds.add(new student("금길동", 70, 70, 100));
		stds.add(new student("흥길동", 60, 100, 100));
		stds.add(new student("허행홍", 80, 20, 40));
		stds.add(new student("허야홍", 90, 80, 60));
		
		stds.get(n-1).printinfo();
		
		int sum = 0;
		for (student s : stds) {
			sum+=s.getEng()+s.getKr()+s.getMath();
		}
		double avg = sum/3.0/stds.size();
		System.out.println(avg);
		
		
		HashMap<String, student> n2s = new HashMap<>();
		for (student s : stds) {
			n2s.put(s.getName(), s);
		}
	}
}
