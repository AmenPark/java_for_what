package com.PAM.dust2DB;
import java.util.ArrayList;

// 미세먼지 -> DB에 올리기.
// 

public class GDMain {
	
	public static void main(String[] args) {
		APIConnSeoul conn = new APIConnSeoul();
		String url = "http://openapi.seoul.go.kr:8088/%s/xml/RealtimeCityAir/1/25/";
		String key = SECRET.key;
		ArrayList<dustInfo> datas = conn.getkxml(url, key);
		DAO.makeConn();
		System.out.println(DAO.registDustInfo(datas));
		DAO.Close();
	}
}
