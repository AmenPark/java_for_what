package com.PAM.oopMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * DAO, DTO 패턴.
 * Data Access Object. DB관련 작업하는 Model의 부분.
 * DTO는 방금 만든 데이터. getter, setter 말고는 없는 객체. VO와 차이점은 setter의 유무이다. VO는 read only, DTO는 write도 가능.
 * 
 */
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

	public static ArrayList<restArea> getInfo(String sql) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			restArea ra = null;
			ArrayList<restArea> ret = new ArrayList<>();
			while (rs.next()) {
				ra = new restArea();
				ra.setName(rs.getString("r_name"));
				ra.setLocation(rs.getString("r_where"));
				ra.setArrow(rs.getString("r_direction"));
				ra.setParkingnum(rs.getInt("r_parking"));
				ret.add(ra);
			}
			return ret;
		} catch (Exception e) {

			return null;
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
	}

	public static String regist(restArea ra) {
		try {
			PreparedStatement pstmt = null;
			String sql = "insert into rest values (sec.nextval,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ra.getName());
			pstmt.setString(2, ra.getArrow());
			pstmt.setString(3, ra.getLocation());
			pstmt.setInt(4, ra.getParkingnum());

			if (pstmt.executeUpdate() == 1) {
				return ("성공");
			} else {
				return "실패";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "실패";
		} catch (Exception e) {
			e.printStackTrace();
			return "실패";
		}

	}

}
