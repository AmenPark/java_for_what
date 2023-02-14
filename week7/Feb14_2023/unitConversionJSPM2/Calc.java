package com.PAM.Feb14.VMCModel;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class Calc {
	public static void calculate(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("EUC-KR");
		double input_value = Double.parseDouble(request.getParameter("input"));
		String[] c = request.getParameter("choice").split(",");
		double result = Double.parseDouble(c[2]) * input_value + Double.parseDouble(c[3]);
		
		int v=0;
		if(c[0].startsWith("c")) {
			v=1;
		}else if(c[0].startsWith("㎡")) {
			v=2;
		}else if(c[0].startsWith("k")) {
			v=3;
		}else {
			v=4;
		}
		UCResult res = new UCResult(c[0], request.getParameter("input"), c[1], String.format("%.1f",result), v);
		request.setAttribute("result", res);
	}
}
