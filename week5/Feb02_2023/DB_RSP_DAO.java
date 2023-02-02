package com.PAM.lastJaVa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.PAM.dust2DB.SECRET;

// DAO는 static을 쓰지 않는게 좋다.
public class DB_RSP_DAO {
	private Connection conn = null;
	private String addr = null;
	private static DB_RSP_DAO dao = new DB_RSP_DAO();
	private Statement stmt = null;
	private PreparedStatement pstmt = null;

	private DB_RSP_DAO() {
		addr = "jdbc:oracle:thin:@" + SECRET.ip + ":" + SECRET.port + ":" + SECRET.sid;
	}

	public static DB_RSP_DAO getInstance() {
		return DB_RSP_DAO.dao;
	}
	
	public void insertGame(RSPGameData gamedata) {
		String query = String.format("insert into rsp_result values(rsp_no.nextval, %d, 50)", gamedata.getUser().getNo());
		if (insertQuery(query)) {
			setGameid(gamedata);
		}
	}
	
	private void setGameid(RSPGameData gamedata) {
		ResultSet rs = null;
		try {
			openConn();
			String sql = String.format("select r_game_id from (select r_game_id from rsp_result where r_user_id = %d order by 1 desc) where rownum = 1", gamedata.getUser().getNo());
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				gamedata.setNo(rs.getInt("r_game_id"));
			}
		} catch (Exception e) {
		} finally {
			Close();
		}
	}
	
	private void UpdateGame(RSPGameData gamedata) {
		String query = String.format("update rsp_result set r_user_score=%d where r_game_id=%d", gamedata.getScore(),gamedata.getNo());
		insertQuery(query);
	}
	
	public void uploadRSP(RSPGameData gamedata) {
		String query = String.format(
				"insert into rsp values(rsp_no.nextval, %d, %d, %d, %d)",
				gamedata.getNo(), gamedata.getUser_choice(), gamedata.getCom_choice(), gamedata.getBat());
		insertQuery(query);
		UpdateGame(gamedata);
	}	
	
	public ArrayList<ScoreData> getLeaderBoardDataGroupByName(){
		String query = "select u_name, r_user_score from (select u_name, max(r_user_score) as r_user_score from users, RSP_RESULT where u_no = r_user_id group by u_name order by r_user_score desc) where rownum<11";
		return getScoreDatas(query);
	}
	
	public ArrayList<ScoreData> getLeaderBoardData(){
		String query = "select u_name, r_user_score from (select u_name, r_user_score from users, RSP_RESULT where u_no = r_user_id order by r_user_score desc) where rownum<11";
		return getScoreDatas(query);
	}
	
	private ArrayList<ScoreData> getScoreDatas(String query){
		ArrayList<ScoreData> rt = new ArrayList<>();
		try {
			ResultSet rs = selectQueryWithoutClose(query);
			while(rs.next()) {
				rt.add(new ScoreData(rs.getString("u_name"), rs.getLong("r_user_score")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return rt;
	}
	
	private ResultSet selectQueryWithoutClose(String query) {
		ResultSet rs = null;
		try {
			openConn();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception e) {
			return null;
		}
	}

	public void setUserNo(User user) {
		ResultSet rs = null;
		try {
			openConn();
			String sql = String.format("select u_no from users where u_name = '%s' and u_ip = '%s'", user.getName(), user.getIp());
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user.setNo(rs.getInt("u_no"));
			}else {
				insertUser(user);
			}
		} catch (Exception e) {

		} finally {
			Close();
		}
	}

	private void insertUser(User user) {
		
		String query = String.format("insert into users values(user_no.nextVal, '%s', '%s')", user.getIp(), user.getName());
		if (insertQuery(query)) {
			setUserNo(user);
		}
	}

	private boolean insertQuery(String query) {
		try {
			openConn();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			Close();
		}

	}

	private void openConn() throws Exception {
		conn = DriverManager.getConnection(addr, SECRET.uid, SECRET.upw);
	}

	private void Close() {
		try {
			conn.close();
		} catch (Exception e) {
		}
		try {
			stmt.close();
		}catch (Exception e) {
		}
		try {
			pstmt.close();
		}catch (Exception e) {
		}
	}
}
