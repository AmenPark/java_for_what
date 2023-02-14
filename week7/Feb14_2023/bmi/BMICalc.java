package com.PAM.Feb14.model2VMC;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BMICalc {
	public static void calcbmi(HttpServletRequest request) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("imgs");
		MultipartRequest mr = new MultipartRequest(request, path, 5000000, "euc-kr", new DefaultFileRenamePolicy());
		
		String name = mr.getParameter("name");
		double height = Double.parseDouble(mr.getParameter("height"));
		double weight = Double.parseDouble(mr.getParameter("weight"));
		String fileName = mr.getFilesystemName("file");
		fileName = URLEncoder.encode(fileName, "euc-kr");
		
		double stdWeight = (height - 100) * 0.9;
		double bmi = weight/stdWeight * 100;
		String result = null;
		if(bmi>120) {
			result="비만";
		}else if(bmi>=80) {
			result="정상";
		}else {
			result="저체중";
		}
		
		
		VOBMI d = new VOBMI(name, String.format("%.1f", weight), String.format("%.1f", height), String.format("%.1f", stdWeight), "imgs/"+fileName, String.format("%.1f", bmi),result);
		request.setAttribute("info", d);
	}
}
