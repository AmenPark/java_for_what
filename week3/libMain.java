import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.print.PrintService;

/*
 * string에 concat - 메모리 부하가 있다.
 * 자주 문자열변경을 한다면 stringbuffer을 사용하자.
 * 정형 데이터는 split을 이용하면 좋고, 비정형은 stringTokenizer을 이용하는것이 좋다.
 * StringTokenizer(String, ",")하면 콤마 단위로 나온다.
 * 
 * int, double 등은 기본형이라서 메소드가 없다?
 * 
 * autoboxing. 기본형->객체형.
 * 객체형 -> 기본형도 가능. Int로 선언된걸 int로 받으면 자동으로 해줌.
 * 
 * Parse시리즈를 통해 ParseInt, parseFloat 등 문자열에서 숫자 뽑아내기가 가능하다.
 * 정규표현식을 통해서도 숫자인지 확인 가능하다.
 * 
 * Date객체.
 * get뭐시기가 제대로 작동 안한다. 더이상 사용하지 않는 구객체. 초창기에 만들어진 객체.
 * SimpleDateFormat이라는 객체를 사용한다.
 * SDF를 통해 Date를 활용 가능하도록 바뀌었다.
 * 문자열을 date로 바꿀때도 SimpleDateFormat을 통해서 바꾼다.
 */
public class libMain {
	public static void stringBufferTest() {
		StringBuffer sb = new StringBuffer();
		sb.append(1324);
		sb.append("abcde");
		System.out.println(sb.toString());
	}

	public static void stringArrayTest() {
		String[] s4 = "abc de fgh".split(" ");
		System.out.println(s4[0]);
	}

	public static void stringTokenizerTest() {
		String s = "abcdefg1234567";
		StringTokenizer st = new StringTokenizer(s);
		System.out.println(st.nextToken());
	}

	public static void testAutoBoxing() {
		boolean e = false;
		Boolean ee = e;
		Double cc = new Double(123.11);
		double c = cc.doubleValue();
		System.out.println(ee);
		System.out.println(c);

		int g = 123;
		String gg = String.valueOf(g);
		System.out.println(gg);
	}

	public static void testArrayMain() {
		String x = "1,2,3,4,5,16,zb,32";
		String[] s = x.split(",");
		int sumvar = 0;
		for (String k : s) {
			try {
				sumvar += Integer.parseInt(k);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(sumvar);
		}
	}

	public static void testDate() {
		Date n = new Date();
		System.out.println(n);
		// 옛날에 만들어진것이라 제대로 작동하지 않음.
		System.out.println(n.getYear());
		System.out.println(n.getMonth());
		System.out.println(n.getDay());
		System.out.println(n.getMinutes());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(n));

		// 특정 시간날자
		try {
			String d = "2020-02-02";
			SimpleDateFormat d2 = new SimpleDateFormat("yyyy-MM-dd");
			Date d3 = d2.parse(d);
			System.out.println(d3);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void streamTest() {
		/*
		 * input stream, Output stream. Output - 프로그램에서 장치로 보냄. Input - 장치에서 프로그램으로 보냄.
		 * 기준이 프로그램이다.
		 * 
		 * InputStream, OutputStream - 1바이트 단위 InputStreamWriter, OutputStreamReader -
		 * 2byte
		 * 
		 * BufferedWriter - 1String 단위...? BufferedReader - 1스트링 단위. 줄단위 처리.
		 * 
		 * 개조형 FileReader : 파일입출력? PrintStream : 다양한 메소드 추가 등등 정말 많다. FileWriter - 윈도우는
		 * / 리눅스는 \이다. 근데 머리좋게 그거 다 알아먹음.
		 * 
		 * BufferWriter - Filewriter 등을 넣어서, inputStreamWriter의 개조형을 넣는다. BufferWriter
		 * bw = new B~(FileWriter객체); bw.write(STRING) - bw로 string 보내기. Bw.flush() -
		 * 데이터 보내기. 최종적으론 bw.close()로 닫아줘야한다. try-catch를 쓴다면 finally에 쓰자. 연관된 얘들은 한번에
		 * 닫힘.
		 */

		PrintStream ps = System.out;
		ps.println("abc");

		InputStream is = System.in;
		Scanner _in = new Scanner(is);

		// 순차적인 접근. 작은단위 Stream, 이후 Writer, Buffer 큰단위까지 열어준다.
		// 덩어리 처리가 아니라 작은 데이터를 다룰 줄 알아야함.
		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream("a.txt.");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);

			String k = _in.nextLine();
			bw.append(k);
			bw.flush();
			bw.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

//  	FileOutputStream - OutputStream 개조형. 1byte단위.
//		보통은 utf-8 사용한다.
	}
	
	public static void streamReadTest() {
		/*
		 * 파일 읽기.
		 * 윈도우에서는 대소문자를 구별하지 않는다.
		 * 리눅스는 파일 대소문자를 구별한다.
		 * 
		 */
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("A.TXT");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine())!=null) {
				System.out.println(line);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
//		stringBufferTest();
//		stringArrayTest();
//		stringTokenizerTest();
//		testAutoBoxing();
//		testArrayMain();
//		testDate();
//		streamTest();
		streamReadTest();
	}
}
