package com.PAM.Feb21_2023.DBWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class snackDAO {
	private static final snackDAO instance = new snackDAO();
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psmt;

	private snackDAO() {
	}

	public static snackDAO getInstance() {
		return instance;
	}

	public void useSnack(HttpServletRequest request) {
		insertSnack(request);
	}
	
	public void setSnackInfo(HttpServletRequest request) {
		request.setAttribute("snacks", getSelectSnack(1,10));
	}

	private ArrayList<snackDTO> getSelectSnack(int i, int j) {
		selectQueryWithoutClose(String.format("select s_name, s_price from snack where s_no>=%d and s_no<=%d order by s_no",i,j));
		ArrayList<snackDTO> al = new ArrayList<>();
		snackDTO data = null;
		try {
			while(rs.next()) {
				data = new snackDTO(rs.getString("s_name"), rs.getInt("s_price"));
				al.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disconn();
		return al;
		
	}
	
	private void selectQueryWithoutClose(String query) {
		makeconn();
		rs = null;
		psmt = null;
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertSnack(HttpServletRequest request) {
		String name = request.getParameter("input");
		int price = Integer.parseInt(request.getParameter("price"));
		String query = String.format("insert into snack values(snack_seq.nextval, '%s', %d)", name, price);
		int t = insertQuery(query);
		request.setAttribute("result", t == 0 ? "failed" : "success");
	}

	private int insertQuery(String query) {
		makeconn();
		rs = null;
		psmt = null;
		int row = 0;
		try {
			psmt = con.prepareStatement(query);
			row = psmt.executeUpdate();

		} catch (Exception e) {

		}
		disconn();
		return row;
	}

	private void makeconn() {
		con = null;
//		자바에서 하지만 톰캣 설정파일을 참조해서 시작하므로 아래처럼만 써줘도 작동. context.xml뭐시기 할 필요는 없다.
		Context ctx;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/ConnectionOraclePool");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		설정파일에 여러가지 존재 가능하다. 이름으로 찾는다. java:comp/env/이름 을 string으로 줘서 찾음.
	}

	private void disconn() {
		try {
			rs.close();
		} catch (Exception e) {
		}
		try {
			psmt.close();
		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}
	}
}
