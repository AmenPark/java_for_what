package com.PAM.feb14_2023.JSPModelMain;

import javax.servlet.http.HttpServletRequest;

public class calc {
	public static void add(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		request.setAttribute("sum", x+y);
		
	}
}
