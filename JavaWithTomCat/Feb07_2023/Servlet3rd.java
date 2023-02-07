package com.PAM.Feb07.studyServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet3rd
 */
@WebServlet("/Servlet3rd")
public class Servlet3rd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet3rd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		String html = "<html>" + "<head>" + "<meta charset=\"UTF-8\">" + "<title>multiplicationTable</title>" + "</head>"
				+ "<body>" + "<table border=\"1\">";

		pw.write(html);
		pw.print("<tr>");
		for (int j = 2; j < 10; j++) {
			pw.printf("<td>%dth table</td>", j);
		}
		pw.print("</tr>");
		for (int i = 1; i < 10; i++) {
			pw.print("<tr>");
			for (int j = 2; j < 10; j++) {
				pw.printf("<td>%d * %d = %d</td>", j, i, j * i);
			}
			pw.print("</tr>");

		}

		pw.write("</table></body></html>");

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
