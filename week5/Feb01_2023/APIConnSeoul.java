package com.PAM.dust2DB;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class APIConnSeoul {
	private HttpURLConnection huc;

	public APIConnSeoul() {
		huc = null;
	}

	public ArrayList<dustInfo> getkxml(String urlFormat, String key){
		String u = String.format(urlFormat, key);
		ArrayList<dustInfo> datalist = null;
		try {
			URL url = new URL(u);
			huc = (HttpURLConnection) url.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(br);
			

			int type = xpp.getEventType();
			String[] tags = { "MSRDT", "MSRRGN_NM", "MSRSTE_NM", "PM10", "PM25", "IDEX_NM" };
			String septag = "row";
			String tagName = null;
			dustInfo data = null;
			datalist = new ArrayList<>();

			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals(septag)) {
						data = new dustInfo();
					}

				} else if (type == XmlPullParser.TEXT) {
					for (String t:tags) {
						if (tagName.equals(t)) {
							data.setData(tagName, xpp.getText());
							break;
						}
					}

				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
					if (xpp.getName().equals(septag)) {
						datalist.add(data);
					}
				}
				xpp.next();
				type = xpp.getEventType();
			}

			return datalist;

		} catch (Exception e) {
			return datalist;
		} finally {
			System.out.println("finnally");
			try {
				huc.disconnect();
			} catch (Exception e2) {
			}
		}
	}
}
