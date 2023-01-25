package com.PAM.JAN2523.datas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class subwayMain2 {
	public static void orderbyDay() {
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("D:\\dataetc\\Subway.csv");
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			br = new BufferedReader(isr);
			
			String line = null;
			ArrayList<SubwayStationInfo> ssiList = new ArrayList<>();
			HashMap<String, Long> ct = new HashMap<>();
			SimpleDateFormat sdf = new SimpleDateFormat("E");
			SubwayStationInfo ssi = null;
			String k = null;
			while((line = br.readLine())!=null) {
				try {
					ssi = new SubwayStationInfo(line);
					ssiList.add(ssi);
					k = sdf.format(ssi.getDate());
					if(ct.get(k)==null) {
						ct.put(k, (long) (ssi.getGet_off()+ssi.getGet_on()));
					} else {
						ct.put(k,ct.get(k)+ssi.getGet_off()+ssi.getGet_on());
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			System.out.println(ct);
			
			
			

			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public static void devideByLine() {
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("D:\\dataetc\\Subway.csv");
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			br = new BufferedReader(isr);
			
			String line = null;
			HashMap<String, Long> ct = new HashMap<>();
			SubwayStationInfo ssi = null;
			String k = null;
			while((line = br.readLine())!=null) {
				try {
					ssi = new SubwayStationInfo(line);
					k = ssi.getSubwayline();
					if(ct.get(k)==null) {
						ct.put(k, (long) (ssi.getGet_off()+ssi.getGet_on()));
					} else {
						ct.put(k,ct.get(k)+ssi.getGet_off()+ssi.getGet_on());
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			
			ArrayList<String> keys = new ArrayList<>(ct.keySet());
			keys.sort(null);
			for (String kvar : keys) {
				System.out.println(kvar+": " + ct.get(kvar));
			}
			
			

			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
//		orderbyDay();
		devideByLine();
		
	}
}
