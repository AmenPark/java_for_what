package test;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.ConnectionPool;

/**
 * Servlet implementation class TestCon
 */
@WebServlet("/SQLConnWithTomCatSetting")
public class SQLConnWithTomCatSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SQLConnWithTomCatSetting() {
        super();

        // TODO Auto-generated constructor stub
    }

    
//    	sql에 매 요청마다 conn~가져오기가 아니라 connectionpool으로, 미리 con을 만드는 방식을 쓴다.
// 		누군가가 연결해달라 하면 그때 db랑 연결해서 쓰기. 톰캣이 해준다.
//    	톰캣의 설정은 meta-inf에 작성. 프로젝트기준의 개별설정이 가능하다.
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		try {
//			자바에서 하지만 톰캣 설정파일을 참조해서 시작하므로 아래처럼만 써줘도 작동. context.xml뭐시기 할 필요는 없다.
			Context ctx = new InitialContext();
			
//			설정파일에 여러가지 존재 가능하다. 이름으로 찾는다. java:comp/env/이름 을 string으로 줘서 찾음.
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/ConnectionOraclePool");
			
			con = ds.getConnection();
			System.out.println("connected");
			
			//닫을때는 resultSet, pstmt(preparedStatement), connection 순으로 닫는다. 열때의 역순.
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
