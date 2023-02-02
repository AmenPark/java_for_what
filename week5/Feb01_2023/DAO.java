package com.PAM.selectDust;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.PAM.dust2DB.SECRET;
import com.PAM.dust2DB.dustInfo;


public class DAO {
	static Connection conn = null;
	static String addr = null;
	
	public static boolean makeConn() {
		addr = "jdbc:oracle:thin:@" + SECRET.ip + ":" + SECRET.port + ":" + SECRET.sid;
		try {
			conn = DriverManager.getConnection(addr, SECRET.uid, SECRET.upw);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void Close() {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}
	
	public static ArrayList<dustInfo> getInfo(String sql) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			dustInfo ra = null;
			ArrayList<dustInfo> ret = new ArrayList<>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			while (rs.next()) {
				ra = new dustInfo();
//				ra.setData("D_MSRDT",sdf.format(rs.getDate("D_MSRDT")));
//				ra.setData("D_MSRRGN_NM", rs.getString("D_MSRRGN_NM"));
				ra.setData("D_MSRSTE_NM", rs.getString("D_MSRSTE_NM"));
//				ra.setData("D_PM25", rs.getString("D_PM25"));
//				ra.setData("D_PM10", rs.getString("D_PM10"));
//				ra.setData("D_INDEX_NM", rs.getString("D_INDEX_NM"));
				ra.setData("AVGVAL", rs.getString("avgvar"));
				ret.add(ra);
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
	}
}
