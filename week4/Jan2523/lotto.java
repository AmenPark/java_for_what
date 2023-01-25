package com.PAM.JAN2523.datas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class lotto {
	public static void main(String[] args) {
		Random _r = new Random();
		HashSet<Integer> nums = new HashSet<>();

		while (nums.size() < 45) {
			nums.add(_r.nextInt(45) + 1);
		}
		ArrayList<Integer> outputs = new ArrayList<>(nums);
		outputs.sort((o1, o2) -> (o1 - o2));
		System.out.println(outputs);
		

	}
}
