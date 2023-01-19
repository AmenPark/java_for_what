package com.PAM.Jan1923.WeatherHTTP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//open weather map 기반으로 받아오는 데이터
//json형식을 파싱하기 위해 maven repository에서 json.simple을 다운받는다. 최신버전, bundle로.

public class WeatherMain {
	public static void main(String[] args) {
		double lat = 37.5211419;
		double lon = 127.0346289;
		String id = Secrets.WEATHERKEY;
		String units = "metric";
		JSONParser p = new JSONParser();
		JSONObject jo = null;

		HttpsURLConnection huc = null;
		String u = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s&units=%s&lang=kr", lat,
				lon, id, units);
		BufferedWriter bw = null;
		try {
			URL url = new URL(u);
			huc = (HttpsURLConnection) url.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			jo = (JSONObject) p.parse(line);
			System.out.println(jo);
			JSONArray w = (JSONArray) jo.get("weather");
			JSONObject w0 = (JSONObject) w.get(0);
			System.out.println(jo.get("main"));
			System.out.println(w0.get("description"));

			// 날짜시간, 날씨명, 지금온도, 습도 기록하기.
			JSONObject main_var = (JSONObject) jo.get("main");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,HH");
			String date = sdf.format(new Date());
			String ret = String.format("%s,%s,%s,%s\n", date, w0.get("main"), main_var.get("temp"),
					main_var.get("humidity"));
			
			FileOutputStream fos = new FileOutputStream("D://weathersdata//weatherinfo.csv",true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			bw.write(ret);
			bw.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		huc.disconnect();
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
