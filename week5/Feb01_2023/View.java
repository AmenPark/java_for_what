package com.PAM.selectDust;

import java.util.ArrayList;

import com.PAM.dust2DB.dustInfo;

public class View {
	public static void print(ArrayList<dustInfo> datalist) {
		if (datalist!=null) {
		for (dustInfo dustInfo : datalist) {
			print(dustInfo);
		}}
	}

	public static void print(dustInfo data) {
		for(String key:data.getKey()) {
			System.out.print(data.getData(key)+", ");
		}
		System.out.println();
	}
}
