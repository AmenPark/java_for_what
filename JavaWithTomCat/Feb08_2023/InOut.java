package com.PAM.InputOutput;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InOut
 */
@WebServlet("/InOut")
public class InOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		String html = "<html><head><meta charset=\"EUC-KR\"><title>HTMLStudy</title></head><body>";
		PrintWriter pw = response.getWriter();
		Humans signs = Humans.getInstance();
		signs.add(request.getParameter("name"));
		pw.print(html);

		for (int i = 0; i < signs.getLength(); i++) {
			pw.printf("<h1>이름:%s</h1><br>", signs.getName(i));
		}

		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		request.setCharacterEncoding("euc-kr");
		String html = "<html><head><meta charset=\"EUC-KR\"><title>HTMLStudy</title></head><body>";
		PrintWriter pw = response.getWriter();
		pw.print(html);
		pw.printf("<h1>id %s, 이름 %s, 위치는 %s, 사는곳은 %s</h1>", request.getParameter("id"),
				request.getParameter("name"), request.getParameter("loc"), request.getParameter("house"));
		String[] hobbies = request.getParameterValues("hobby");
//		checkbox는 name이 같은건 묶어서 string[]꼴로 받을 수 있다. 체크박스가 0개 체크일 경우 null로 들어온다.

		pw.print("</body></html>");
	}

}
