package com.PAM.refgManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinControll
 */
@WebServlet("/JoinControll")
public class JoinControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contents", "jsp/join.jsp");
		request.getRequestDispatcher("LoginControll").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("message", "가입 성공!");
			UserDAO.getInstance().SignUpUser(request);			
		} catch (Exception e) {
			request.setAttribute("contents", "jsp/join.jsp");			
		}
		if(request.getSession().getAttribute("User")==null) {
			request.setAttribute("contents", "jsp/join.jsp");
		}else {
			request.setAttribute("contents", "jsp/home.jsp");
		}
		request.getRequestDispatcher("LoginControll").forward(request, response);
		
	}

}
