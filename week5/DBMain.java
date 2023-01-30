package tryQuery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DBMain {
	public static void select() {
		Connection conn = null;
		String addr = "jdbc:oracle:thin:@" + SECRET.ip + ":" + SECRET.port + ":" + SECRET.sid;
		PreparedStatement pstmt = null;

		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); 자동으로 요즘엔 해줌.
//			pstmt를 이용하면 ?부분을 자동으로 채워준다. set부분을 통해 뭘 넣을지, 그리고 몇번째에 넣을지를 정해야함.
//			select의 경우 null을 해당 타입의 기본? 으로 처리한다. 숫자면 0. 문자열은 null.
//			재밌는건 insert into할때 ""는 null처리하면서 가져올때는 ""으로 안가져옴.
			conn = DriverManager.getConnection(addr, SECRET.uid, SECRET.upw);
			String sql = "select * from testtable order by aid";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("aid"));
				System.out.println("-----");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * statement 부터 닫고 connection을 닫아야 한다.
		 */
		try {
			pstmt.close();
		} catch (Exception e) {	}

		try {
			conn.close();
		} catch (Exception e) {
		}
	}
	
	public static void update() {
		Connection conn = null;
		String addr = "jdbc:oracle:thin:@" + SECRET.ip + ":" + SECRET.port + ":" + SECRET.sid;
		PreparedStatement pstmt = null;

		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); 자동으로 요즘엔 해줌.
//			pstmt를 이용하면 ?부분을 자동으로 채워준다. set부분을 통해 뭘 넣을지, 그리고 몇번째에 넣을지를 정해야함.
			conn = DriverManager.getConnection(addr, SECRET.uid, SECRET.upw);
			String sql = "update testtable set aid = 80";
			pstmt = conn.prepareStatement(sql);

			if (pstmt.executeUpdate()>=1) {
				System.out.println(pstmt);
				System.out.println("성공");
			}
			System.out.println("-----");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * statement 부터 닫고 connection을 닫아야 한다.
		 */
		try {
			pstmt.close();
		} catch (Exception e) {	}

		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public static void insert() {
		/*
		 * db와 연결하기. db에 따라서 방법이 다 다르다. data source explorer에서 원하는 db connections에서
		 * properties - connectionURL로 찾기 가능.
		 */
		Connection conn = null;
		String addr = "jdbc:oracle:thin:@" + SECRET.ip + ":" + SECRET.port + ":" + SECRET.sid;
		PreparedStatement pstmt = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); 자동으로 요즘엔 해줌.
//			pstmt를 이용하면 ?부분을 자동으로 채워준다. set부분을 통해 뭘 넣을지, 그리고 몇번째에 넣을지를 정해야함.
			conn = DriverManager.getConnection(addr, SECRET.uid, SECRET.upw);
			String sql = "insert into testtable values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, -78);
			pstmt.setString(2, "");
			pstmt.setString(3, "");
			pstmt.setDate(4, new Date(37));
			pstmt.setFloat(5, (float) -3.04);

			int row = pstmt.executeUpdate();
			if (row == 1) {
				System.out.println("ok");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * statement 부터 닫고 connection을 닫아야 한다.
		 */
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			conn.close();
		} catch (Exception e) {

		}

	}

	public static void main(String[] args) {
//		insert();
		select();
	}
}
