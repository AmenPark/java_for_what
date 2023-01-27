package tryQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

public class makeRowMain {
	
	public static String makeInsertQ(String table, int num) {
		Random _r = new Random();
		String name = "";
		for(int i=0;i<4;i++) {
			name += (char)(_r.nextInt(26)+97);
		}
		
		String birth = String.format("%d%02d%02d", _r.nextInt(50)+50,_r.nextInt(12),_r.nextInt(29));
		String home = "";
		for (int i=0;i<5;i++) {
			home += (char)(_r.nextInt(26)+65);
		}
		String query = String.format("INSERT INTO %s values(%d, '%s', %s, '%s')", table, num, name, birth, home);

		return query;
	}
	
	public static String makeInsertQR(String table, int num) {
		Random _r = new Random();
		String name = "";
		for(int i=0;i<7;i++) {
			name += (char)(_r.nextInt(26)+97);
		}
		
		String loc = "";
		for (int i=0;i<7;i++) {
			loc += (char)(_r.nextInt(26)+65);
		}
		
		String branch = "";
		for (int i=0;i<8;i++) {
			branch += (char)(_r.nextInt(26)+65);
		}
		
		int tablenum = _r.nextInt(60)+1;
		String query = String.format("INSERT INTO %s values(%d, '%s', '%s', '%s', %d)", table, num, name,  loc, branch , tablenum);

		return query;
	}
	
	public static String makeInsertQM(String table, int num) {

		Random _r = new Random();
		String name = "";
		for(int i=0;i<3;i++) {
			name += (char)(_r.nextInt(26)+97);
		}
		
		int price = (_r.nextInt(1000)+1)*1000;
		
		int where = _r.nextInt(1000);
		String query = String.format("INSERT INTO %s values(%d, '%s', %d, %d)", table, num, name, price, where);

		return query;
	}
	
	public static String makeInsertIND(String table, int num) {
		Random _r = new Random();
		
		int rest_no = num;
		
		int ceo_no = _r.nextInt(1000);
		String query = String.format("INSERT INTO %s values(%d, '%d', %d)", table, num, rest_no, ceo_no);

		return query;
	}
	
	
	public static void insertQ(Connection conn, int N) {
		Statement stmt = null;
		String query = null;
		
		int rs = 0;
		
		try {
			stmt = conn.createStatement();
			
			for(int i=0;i<N;i++) {
//				query = makeInsertQ("ceo",i);
//				query = makeInsertQR("restraunt",i);
//				query = makeInsertQM("menu",i);
				query = makeInsertIND("indexes",i);
				
				System.out.println(query);
				rs = stmt.executeUpdate(query);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void tryDB() {
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@" + SECRET.ip + ":" + SECRET.port + ":" + SECRET.sid;

		try {
			conn = DriverManager.getConnection(url,SECRET.uid, SECRET.upw);
			insertQ(conn, 1000);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println("end");
		
		
		try {
			conn.close();			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		tryDB();
	}
}
