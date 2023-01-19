package com.PAM.Jan1923.WeatherHTTP;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// json 은 length가 아니라 size를 쓴다.
public class usingKAKAOMain {
	public static void main(String[] args) {
		String BASEURL = "https://dapi.kakao.com/v2/local/search/keyword.json"
				+ "?x=127.0266709&y=37.5053693&radius=20000";
		HttpsURLConnection huc = null;
		try {
			Scanner _in = new Scanner(System.in);
			System.out.print("질문입력\t:");
			String keyword = _in.next();
			_in.close();

			keyword = URLEncoder.encode(keyword, "utf-8");
			URL url = new URL(BASEURL + "&query=" + keyword);
			huc = (HttpsURLConnection) url.openConnection();
			huc.setRequestProperty("Authorization", "KakaoAK " + Secrets.MY_KAKAO_API_KEY);
			huc.setRequestMethod("GET");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();

			JSONParser jp = new JSONParser();
			JSONArray origin = (JSONArray) ((JSONObject) jp.parse(line)).get("documents");
			// 거리 번호 이름 주소
			JSONObject jo = null;
			for (Object obj : origin) {
				jo = (JSONObject) obj;
				System.out.printf("이름: %20s\t거리: %s\t 번호: %s\t 주소:%s\n", jo.get("place_name"), jo.get("distance"),
						jo.get("phone"), jo.get("road_address_name"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		huc.disconnect();

	}
}
