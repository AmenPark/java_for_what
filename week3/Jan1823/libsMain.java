package com.PAM.Jan1823.libs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class libsMain {
	public static int makeFile() {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		OutputStreamWriter osw = null;
		SimpleDateFormat sdfBefore = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat sdfAfter = new SimpleDateFormat("yyyy,MM,dd,HH");

		BufferedWriter bw2 = null;
		Date d = new Date();
		Date latestDate = new Date();
		try {
			FileInputStream fis = new FileInputStream("d://weathersdata//time.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			latestDate = sdfBefore.parse(br.readLine());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			URL url = new URL(
					"http://openapi.seoul.go.kr:8088/"+Secrets.SECRET_KEY+"/xml/RealtimeCityAir/1/25");
			huc = (HttpURLConnection) url.openConnection();
			InputStream is = huc.getInputStream();
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");
			// 시작태그, 텍스트태그, 종료태그중 하나.

			FileOutputStream fos = new FileOutputStream("D://weathersdata//seoul_weathers.csv", true);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);

			int type = xpp.getEventType();
			String[] tags = { "MSRDT", "MSRRGN_NM", "MSRSTE_NM", "PM10", "PM25", "IDEX_NM" };
			String tagName = null;
			boolean duplchecker = true;
			String t = null;
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					// 태그이름.
					tagName = xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					// 텍스트 이름

					for (int i = 0; i < tags.length; i++) {
						t = tags[i];
						if (tagName.equals(t)) {
							if (i != 0) {
								bw.write(",");
								bw.write(xpp.getText());
							} else {
								d = sdfBefore.parse(xpp.getText());
								if (duplchecker) {
									if (sdfBefore.format(latestDate).equals(sdfBefore.format(d))) {
										return -1;
									} else {
										duplchecker = true;
									}
									bw.write(sdfAfter.format(d));
								}
							}
							break;
						}
					}
				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
					if (xpp.getName().equals(tags[tags.length - 1])) {
						bw.write("\r\n");
					}
				}
				xpp.next();
				type = xpp.getEventType();
			}


			bw.flush();
			FileOutputStream fos2 = new FileOutputStream("d://weathersdata//time.txt");
			OutputStreamWriter osw2 = new OutputStreamWriter(fos2);
			bw2 = new BufferedWriter(osw2);
			bw2.write(sdfBefore.format(d));
			bw2.flush();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			try {
				bw2.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}

		}
//		try {
//			bw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return 0;
	}

	public static void main(String[] args) {
		makeFile();
	}
}
