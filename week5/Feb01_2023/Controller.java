package com.PAM.selectDust;

import java.util.ArrayList;

import com.PAM.dust2DB.dustInfo;

public class Controller {
	public static void main(String[] args) {
		DAO.makeConn();
		String sql = "select d_msrste_nm, avg(d_pm10+d_pm25) as avgvar from dustinfo where d_INDEX_NM is not null group by d_msrste_nm order by avgvar desc";
		ArrayList<dustInfo> datalist = DAO.getInfo(sql);

		View.print(datalist);
		DAO.Close();
	}
}
