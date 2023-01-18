package com.PAM.Jan1823.libs;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class subwayMain {
	public static void main(String[] args) {

		final String SPLITER = "\t";
		String startDate = "20150101";
		String endDate = "20221231";
		String baseUrl = "http://openapi.seoul.go.kr:8088/"+Secrets.SECRET_KEY+"/xml/CardSubwayStatsNew/1/1000/";

		String nowUrl = null;
		HttpURLConnection huc = null;
		SimpleDateFormat sdfBefore = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdfAfter = new SimpleDateFormat("yyyy" + SPLITER + "MM" + SPLITER + "dd");
		BufferedWriter bw = null;
		Date d = new Date();
		Date stdDate;
		String[] tags = { "USE_DT", "LINE_NUM", "SUB_STA_NM", "RIDE_PASGR_NUM", "ALIGHT_PASGR_NUM" };
		try {
			stdDate = sdfBefore.parse(startDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			stdDate = new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(stdDate);
		URL url = null;
		InputStream is = null;
		XmlPullParserFactory xppf;
		XmlPullParser xpp;
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		String tagName = null;
		String t = null;
		int type;
		while (!sdfBefore.format(cal.getTime()).equals(endDate)) {
			d = cal.getTime();
			nowUrl = baseUrl + sdfBefore.format(d);
			System.out.println(nowUrl);
			try {
				url = new URL(nowUrl);

				huc = (HttpURLConnection) url.openConnection();

				is = huc.getInputStream();

				xppf = XmlPullParserFactory.newInstance();
				xpp = xppf.newPullParser();
				xpp.setInput(is, "utf-8");

				fos = new FileOutputStream("D://dataetc//Subway.csv", true);
				osw = new OutputStreamWriter(fos);
				bw = new BufferedWriter(osw);

				// 시작태그, 텍스트태그, 종료태그중 하나.
				type = xpp.getEventType();

				while (type != XmlPullParser.END_DOCUMENT) {
					if (type == XmlPullParser.START_TAG) {
						// 태그이름.
						tagName = xpp.getName();
					} else if (type == XmlPullParser.TEXT) {
						// 텍스트 이름
						for (int i = 0; i < tags.length; i++) {
							t = tags[i];
							if (tagName.equals(t)) {
								if (!t.equals(tags[0])) {
									bw.write(SPLITER);
									bw.write(xpp.getText());
								} else {
									d = sdfBefore.parse(xpp.getText());
									bw.write(sdfAfter.format(d));
								}
								break;
							}
						}
					} else if (type == XmlPullParser.END_TAG) {
						tagName = "";
						if (xpp.getName().equals(tags[tags.length - 1])) {
							bw.write('\n');
							bw.flush();
						}
					}
					xpp.next();
					type = xpp.getEventType();
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			cal.add(Calendar.DATE, 1);
		}

		try {
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
