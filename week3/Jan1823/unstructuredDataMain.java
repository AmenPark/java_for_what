package com.PAM.Jan1823.libs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.PAM.usefulThings.StringCleaner;

public class unstructuredDataMain {
	public static void main(String[] args) {
		final String BASEURL = "https://openapi.naver.com/v1/search/news.xml";
//		BufferedReader br = null;
		HttpsURLConnection huc = null;
		try {
			String searchText = "코로나";
			int display = 20;
			String sortway = "";
			URL url = new URL(String.format( "%s?query=%s&display=%d,sort=%s", BASEURL,URLEncoder.encode(searchText, "utf-8"),display,sortway));
			huc = (HttpsURLConnection) url.openConnection();
			huc.addRequestProperty("X-Naver-Client-Id", Secrets.MY_NAVER_ID);
			huc.addRequestProperty("X-Naver-Client-Secret", Secrets.MY_CLIENT_SECRET);
			huc.setRequestMethod("GET");

			InputStream is = huc.getInputStream();

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");
			
			int type = xpp.getEventType();
			int idnum = -1;
			String t = null;
			String[] tags = {"title", "description"};
			while (type!=XmlPullParser.END_DOCUMENT) {
				if (type==XmlPullParser.START_TAG) {
					t = xpp.getName();
					if (t.equals("item")) {
						idnum += 1;
//						System.out.println(idnum);
					}
				}else if(type==XmlPullParser.TEXT) {
					if(idnum>=0) {
						for(String tag:tags) {
							if (tag.equals(t)) {
								System.out.println(StringCleaner.stringCleaner(xpp.getText()));
							}
						}
					}
					
				}else if(type == XmlPullParser.END_TAG) {
					t="";
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
