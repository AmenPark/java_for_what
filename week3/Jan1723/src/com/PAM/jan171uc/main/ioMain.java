package com.PAM.jan171uc.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class ioMain {

	public static void outputTest() {
		Scanner _in = new Scanner(System.in);
		BufferedWriter bw = null;
		Random _r = new Random();
		try {
			System.out.println("품목, 유통기한, 가격, 중량 입력");
			FileOutputStream fos = new FileOutputStream("d:/test/food.csv");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
//			String[] d;
//			String x;
			for (int i = 0; i < 10; i++) {
//				x = _in.nextLine();
//				d[] = x.split(",");

				String d0 = "abcdefghijklmnopqrstuvwxyz";
				int d1 = (_r.nextInt(5) + 2020) * 10000 + (_r.nextInt(12) + 1) * 100 + (_r.nextInt(28) + 1);
				int d2 = _r.nextInt(100)*1000+1000;
				int d3 = _r.nextInt(1000)+1;
				String data = String.format("%s, %d, %d, %d\r\n", d0.charAt(_r.nextInt(d0.length())), d1, d2, d3);
				bw.write(data);
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		_in.close();
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void inputTest() {
		Date d2 = new Date();
		String[] items = { "품명", "유통기한", "가격", "중량" };
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("d:/test/food.csv");
			InputStreamReader fsr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(fsr);
			String line = null;
			Date d;

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd(E)");
			while ((line = br.readLine()) != null) {
				String[] l = line.split(",");

				for (int i = 0; i < 4; i++) {
					System.out.printf("%s : %s\n", items[i], l[i]);
				}
				System.out.printf("g당 가격: %f\n", Integer.parseInt(l[2].trim()) / Double.parseDouble(l[3].trim()));
				
				System.out.println("************");
				d = sdf.parse(l[1].trim());

				if (d.before(d2)) {
					System.out.println("유통기한 지남");
				} else {
					System.out.println("유통기한 안지남");
				}
				System.out.println("===========");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("END");
	}

	public static void main(String[] args) {
		outputTest();
		inputTest();
	}

}
