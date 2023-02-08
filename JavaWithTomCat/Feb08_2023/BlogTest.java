package com.PAM.InputOutput;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BlogTest
 */
@WebServlet("/BlogTest")
public class BlogTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		//서버 내 경로 획득하기.
		String path = request.getSession().getServletContext().getRealPath("imgs");
		System.out.println(path);
//												리퀘스트, 파일저장경로, 파일사이즈, 인코딩방식, 파일명중복처리. 이놈은 숫자 0,1,2,...
		MultipartRequest mr = new MultipartRequest(request, path,30000000, "euc-kr", new DefaultFileRenamePolicy());
		String html = "<html><head><meta charset=\"EUC-KR\"><title>HTMLStudy</title></head><body>";
		PrintWriter pw = response.getWriter();
		pw.print(html);
//		pw.printf("<h1>제목 : %s</h1>", mr.getParameter("title"));
		
		System.out.println("완료");
		pw.print("</body></html>");
	}

}
