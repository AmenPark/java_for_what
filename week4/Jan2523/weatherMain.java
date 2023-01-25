package com.PAM.JAN2523.datas;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class weatherMain {
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
			String[] tags = { "hour","day" ,"temp"};
			String tagName = null;
			weatherInfo wi = null;
			ArrayList<weatherInfo> wis = new ArrayList<>();
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals("data")) {
						wi = new weatherInfo();
					}
				} else if (type == XmlPullParser.TEXT) {
					// 텍스트 이름
					if (tagName.equals(tags[0])){
						wi.setHour(xpp.getText());
					} else if(tagName.equals(tags[1])) {
						wi.setDay(xpp.getText());
					} else if(tagName.equals(tags[2])) {
						wi.setTemp(xpp.getText());
					}
					
					
				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
					if (xpp.getName().equals("data")) {
						wis.add(wi);
					}
				}
				xpp.next();
				type = xpp.getEventType();
			}
			
			wis.sort(new Comparator<weatherInfo>() {

				@Override
				public int compare(weatherInfo o1, weatherInfo o2) {
					if (o1.getTemp()>=o2.getTemp()) {
						return 1;
					} else if(o1.getTemp() == o2.getTemp()) {
						return 0;
					}
					return -1;
				}
				
			});
			wis.get(0).printinfo();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		huc.disconnect();
	}
}

