package com.PAM.Feb09_2023.calAns;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class imgTrans
 */
@WebServlet("/ImgTrans")
public class ImgTrans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgTrans() {
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
		response.setCharacterEncoding("EUC-KR");
		String html = "<html><head><meta charset=\"EUC-KR\"><title>HTMLStudy</title></head><body>";
		PrintWriter pw = response.getWriter();
		String path = request.getSession().getServletContext().getRealPath("files");
		MultipartRequest mr = new MultipartRequest(request, path,30000000,"euc-kr",new DefaultFileRenamePolicy());
		String fileName = URLEncoder.encode(mr.getFilesystemName("img"),"euc-kr");
		System.out.println(fileName);
		pw.print(html);
		String L = mr.getParameter("L");
		String H = mr.getParameter("H");
		int l = Integer.parseInt(L);
		int h = Integer.parseInt(H);
		pw.printf("<img alt=\"\" src=\"%s\" width=\"%d\" height=\"%d\">", "files\\"+fileName,l,h);
		pw.print("</body></html>");
	}

}
