package com.PAM.jan171uc.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.management.modelmbean.XMLParseException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/*
 * URL 객체. url에 관한 객체.
 * HTTP, HTTPS.
 * 
 * HttpURLConnection 객체는 Object 기반으로 생성자가 짜여져 있기 때문에
 * 형변환이 무조건 필요하다.
 * 
 * HttpUrlConnection 객체는 getInputStream을 통해 InputStream을 생성 가능하다.
 * 
 * JSP, Spring 등이 자바를 이용한 HTTP 서버 만들기.
 * 
 * RSS - Real Simple Syndication.
 * 새글이 자주 올라오는 기상청/블로그/신문기사 등에서 제공하는 경우가 많다.
 * 
 * XML - HTML형식을 빌린 데이터 표현방식.
 * JSON - JS형식으로 표현.
 * XML을 써먹기 위해 mvnrepository.com에서 kxml jar파일을 다운받아서 사용해봄.
 * kxml에서 XmlPullParser은 Factory에서 만들어야만함.
 * input을 세팅할때 inputstream을 넣던지, inputstreamReader을 넣던지 가능.
 * 
 */

public class UCMainAgain {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		try {
			URL url = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1162058500");

			huc = (HttpURLConnection) url.openConnection();

			InputStream is = huc.getInputStream();

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			// 시작태그, 텍스트태그, 종료태그중 하나.
			int type = xpp.getEventType();
			String[] tags = { "hour", "temp", "wfKor" };
			String tagName = null;
			boolean checker = false;
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					// 태그이름.
					for (String t : tags) {
						if (xpp.getName().equals(t)) {
							checker = true;
							tagName = t;
							break;
						}
						;
					}
				} else if (type == XmlPullParser.TEXT) {
					// 텍스트 이름
					if (checker) {
						System.out.printf("%s\t: %s\n", tagName, xpp.getText());
					}
				} else if (type == XmlPullParser.END_TAG) {
					for (String t : tags) {
						if (xpp.getName().equals(t)) {
							checker = false;
							break;
						}
						;
					}
//					System.out.println(xpp.getName());
				}
				xpp.next();
				type = xpp.getEventType();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
