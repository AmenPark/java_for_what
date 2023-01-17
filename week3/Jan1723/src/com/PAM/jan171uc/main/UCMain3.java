package com.PAM.jan171uc.main;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class UCMain3 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		try {
			URL url = new URL("http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/25");
			
			huc = (HttpURLConnection) url.openConnection();

			InputStream is = huc.getInputStream();

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			// 시작태그, 텍스트태그, 종료태그중 하나.
			int type = xpp.getEventType();
			String[] tags = { "MSRSTE_NM", "IDEX_NM", "MSRRGN_NM","PM10","PM5" };
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
