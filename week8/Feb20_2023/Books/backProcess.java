package com.PAM.Feb20_2023.Books;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class backProcess {
	private static backProcess instance=new backProcess();
	
	private backProcess() {
		
	}
	
	public static backProcess getInstance() {
		return instance;
	}
	
	public void setData(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("datas", getData(request.getParameter("kw")));
	}
	
	private ArrayList<BDTO> getData(String keyword){
		
		ArrayList<BDTO> al = new ArrayList<>();
		String base_url = "https://dapi.kakao.com/v3/search/book?target=title";
		HttpsURLConnection huc =null;
		try {
			
			String encoded_kw = URLEncoder.encode(keyword,"UTF-8"); 
			
			
			URL url = new URL(base_url+"&query="+encoded_kw);
			huc = (HttpsURLConnection) url.openConnection();
			huc.setRequestProperty("Authorization", "KakaoAK " + Secrets.MY_KAKAO_API_KEY);
			huc.setRequestMethod("GET");
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			
			JSONObject jo = null;
			JSONParser jp = new JSONParser();
			JSONArray ja = (JSONArray)((JSONObject) jp.parse(line)).get("documents");
			BDTO data = null;
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
			ArrayList<String> authors = null;
			for (Object obj : ja) {
				jo = (JSONObject) obj;
				data = new BDTO();
				authors = new ArrayList<>();
				data.setContents(jo.get("contents").toString());
				data.setDatetime(sdf.parse(jo.get("datetime").toString().substring(0,10)));
				data.setPrice(jo.get("price").toString());
				data.setTitle(jo.get("title").toString());
				data.setThumbnail(jo.get("thumbnail").toString());
				for (Object author:(JSONArray)jo.get("authors")) {
					authors.add(author.toString());
				}
				data.setAuthors(authors);
				al.add(data);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		huc.disconnect();
		
		
		return al;
	}
	
}
