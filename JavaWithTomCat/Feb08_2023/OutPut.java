package com.PAM.testOne;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class OutPut
 */
@WebServlet("/OutPut")
public class OutPut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutPut() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get을 처리할때 파라미터가 한글 등이고, euc-kr로 전달되면 이건 톰캣이 자동처리(utf-8)해서 한글깨지는 현상이 있다.
		// 해결하기 위해서는 server.xml파일을 수정해야 한다.
		response.setCharacterEncoding("euc-kr");
		String html = "<html><head><meta charset=\"EUC-KR\"><title>HTMLStudy</title></head><body>";
		PrintWriter pw = response.getWriter();
		pw.print(html);
		pw.print(request.getParameter("a"));
		pw.print(request.getParameter("b"));
		
		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("EUC-KR");
		String html = "<html><head><meta charset=\"EUC-KR\"><title>HTMLStudy</title></head><body>";
		PrintWriter pw = response.getWriter();
		pw.print(html);
		pw.print(request.getParameter("a"));
		pw.print(request.getParameter("b"));
		
		pw.print("</body></html>");
		
	}

}
