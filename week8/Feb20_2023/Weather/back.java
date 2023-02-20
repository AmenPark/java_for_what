package com.PAM.Feb202023.Weather;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;



public class back {
	private static back instance = new back();

	private back() {
	}

	public static back getInstance() {
		return instance;
	}

	public void setWeatherInfo(HttpServletRequest request) {
		request.setAttribute("infos",getWeatherInfos());
	}
	
	
	
	private ArrayList<WDTO> getWeatherInfos() {
		HttpURLConnection huc = null;
		ArrayList<WDTO> wis = new ArrayList<>();
		try {
			URL url = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1162058500");

			huc = (HttpURLConnection) url.openConnection();

			InputStream is = huc.getInputStream();

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			// 시작태그, 텍스트태그, 종료태그중 하나.
			int type = xpp.getEventType();
			String tagName = null;
			WDTO wi = null;
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals("data")) {
						wi = new WDTO();
					}
				} else if (type == XmlPullParser.TEXT) {
					// 텍스트 이름
					if (tagName.equals("temp")) {
						wi.setTemp(xpp.getText());
					} else if (tagName.equals("hour")){
						wi.setHour(xpp.getText());
					} else if (tagName.equals("day")) {
						wi.setDay(xpp.getText());
					} else if (tagName.equals("wfEn")) {
						wi.setWfEn(("imgs/"+xpp.getText()+".png").toLowerCase());
					} else if (tagName.equals("wfKor")) {
						wi.setWfKor(xpp.getText());
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

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		huc.disconnect();
		
		System.out.println(wis);
		return wis;
	}

}
