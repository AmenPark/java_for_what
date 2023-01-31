package com.PAM.oopMain;

public class Controller_ {
	public static void dataUpload(View v) {
		restArea r = new restArea();
		try {
			r = v.getInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		v.print(r);
		
		DAO.regist(r);
	}
		// 휴게소 이름, 방향, 위치, 주차대수
	
	public static void findData(View v, String query) {
		v.print(DAO.getInfo(query));
	}
	
	public static void main(String[] args) {
		View v = new View();
//		dataUpload(v);
		DAO.makeConn();
		findData(v, "select * from rest group by r_name");
		
		v.destroy();
		
	}
	

	
}
