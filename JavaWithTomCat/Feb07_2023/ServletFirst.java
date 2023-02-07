package com.PAM.Feb07.studyServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet project. 이클립스에서는 servlet project 생성 눌러주면 자동으로 상속을 만들어준다. server+applet(application).
//WAS에서만 실행 가능함. TomCat을 쓸 예정.
//HTML/CSS를 생성해서 응답해주는 프로그램. 즉, HTML CSS를 자동화.
//sevlet을 톰캣에 등록해야만 쓸 수 있음. 그걸 자동화? 어노테이션을 사용하는데, 컴파일러에게 뭔가 알려주거나 설정하는 등의 용도로 잘 쓴다.

/**
 * Servlet implementation class ServletFirst
 */
@WebServlet("/ServletFirst")
public class ServletFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFirst() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
