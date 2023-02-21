package com.PAM.Feb21_2023_login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userDAO {
	private static userDAO instance = new userDAO();
	
	private userDAO() {
	}
	
	public static userDAO getInstance() {
		return instance;
	}
	
	/* 로그인상태면 true, 아니면 false.*/
	public boolean isLogined(HttpServletRequest request) {
		return request.getSession().getAttribute("loginID")!=null;
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("euc-kr");
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			if(id.equals("test") && pw.equals("123")) {
				System.out.println("login");
				request.getSession().setAttribute("loginID", "test");
				request.getSession().setAttribute("id", id);
				request.getSession().setMaxInactiveInterval(10);
				Cookie c = new Cookie("id", id);
				c.setMaxAge(60*60*24);
				response.addCookie(c);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
