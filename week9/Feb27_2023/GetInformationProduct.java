package com.PAM.refgManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetInformationProduct {
	private static GetInformationProduct instance;

	public GetInformationProduct() {
		super();
	}

	public static GetInformationProduct getInstance() {
		if(instance == null) {
			instance = new GetInformationProduct();
		}
		return instance;
	}
	
	public String getAPIData(String url) {
		HttpURLConnection huc = null;
		try {
			URL u = new URL(url);
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			while((line= br.readLine())!= null) {
				System.out.println(line);
			}
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public static void main(String[] args) {
		getInstance().getAPIData("http://192.168.0.140/ConvManager/ConvInfoAPIController?area=%BC%AD%BF%EF&itemList=%28%27%B8%B6%C0%CC%C2%E9%27%2C%27%B8%DE%B7%CE%B3%AA%27%2C%27%BB%F5%C4%DE%B4%DE%C4%DE%27%2C%27%BB%C7%B6%C7%27%29");
		

	}
	
}
