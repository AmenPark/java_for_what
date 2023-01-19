package com.PAM.Jan1923.WeatherHTTP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//20180614 데이터없음. 20180629 20180714 20181028
//20190423 부터 다시.
public class UCMain {
	public static void main(String[] args) {
		String baseUrl = "http://openapi.seoul.go.kr:8088/" + Secrets.SECRET_KEY + "/json/CardBusStatisticsServiceNew/";

		final String SPLITER = ",";
		String startDate = "20190423";
		String endDate = "20230101";

		String nowUrl = null;
		HttpURLConnection huc = null;
		SimpleDateFormat sdfBefore = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdfAfter = new SimpleDateFormat("yyyy" + SPLITER + "MM" + SPLITER + "dd");
		BufferedWriter bw = null;
		Date d = new Date();
		Date stdDate;
		String[] tags = { "BUS_ROUTE_NO", "BUS_STA_NM", "RIDE_PASGR_NUM", "ALIGHT_PASGR_NUM" };
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

		FileOutputStream fos = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		OutputStreamWriter osw = null;
		JSONParser jp = new JSONParser();
		JSONObject origin = null;
		JSONArray jarr = null;
		int total_data_count = 0;
		String nowdayNForm = null;
		String nowdayCForm = null;
		String tmp = null;
		while (!sdfBefore.format(cal.getTime()).equals(endDate)) {
			d = cal.getTime();
			nowdayNForm = sdfBefore.format(d);
			nowdayCForm = sdfAfter.format(d);
			nowUrl = baseUrl + "0/1/" + nowdayNForm;
			try {
				url = new URL(nowUrl);

				huc = (HttpURLConnection) url.openConnection();
				is = huc.getInputStream();
				isr = new InputStreamReader(is, "utf-8");
				br = new BufferedReader(isr);
				origin = (JSONObject) jp.parse(br.readLine());
				total_data_count = Integer.parseInt(
						((JSONObject) origin.get("CardBusStatisticsServiceNew")).get("list_total_count").toString());
				br.close();
				
				fos = new FileOutputStream("D://dataetc//bus//" + nowdayNForm+"BUS.csv");
				osw = new OutputStreamWriter(fos);
				bw = new BufferedWriter(osw);
				for (int i = 0; i <= total_data_count; i+=1000) {
					nowUrl = String.format("%s%d/%d/%s", baseUrl,i+1,i+1000,nowdayNForm);
					url = new URL(nowUrl);
					huc = (HttpURLConnection) url.openConnection();
					is = huc.getInputStream();
					isr = new InputStreamReader(is, "utf-8");
					br = new BufferedReader(isr);
					origin = (JSONObject) jp.parse(br.readLine());
					jarr = (JSONArray)((JSONObject) origin.get("CardBusStatisticsServiceNew")).get("row");
					for(Object obj: jarr) {
						bw.write(nowdayCForm);
						for (String t :tags) {
							bw.write(",");
							if (t.endsWith("NUM")){
								tmp = ((JSONObject)obj).get(t).toString();
								bw.write(tmp.substring(0,tmp.length()-2));
							}else {
								bw.write(((JSONObject)obj).get(t).toString());
							}
						}
						bw.write("\r\n");
					}
					bw.flush();
				}
				bw.close();
				System.out.println(nowUrl+"----DONE");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(sdfBefore.format(cal.getTime()));
				cal.add(Calendar.DATE, 1);
				continue;
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
