package com.PAM.Feb09_2023.calAns;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
 * Servlet implementation class calcAnswer
 */
@WebServlet("/calcAnswer")
public class calcAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calcAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("EUC-KR");
		String html = "<html><head><meta charset=\"EUC-KR\"><title>HTMLStudy</title></head><body>";
		PrintWriter pw = response.getWriter();
		pw.print(html);
		String X = request.getParameter("x");
		String Y = request.getParameter("y");
		String oper = request.getParameter("oper");
		int calc=0;
		try {
			int x =Integer.parseInt(X);
			int y = Integer.parseInt(Y);
			if(oper.equals("+")) {
				calc = x+y;
			} else if (oper.equals("-")) {
				calc=x-y;
			}else if(oper.equals("*")) {
				calc=x*y;
			}else if(oper.equals("/")) {
				calc=x/y;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		pw.print("<h1>");
		pw.printf("%s %s %s = %d", X,oper,Y, calc);
		pw.print("</h1>");
		
		pw.print("</body></html>");
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
		String fileName = mr.getFilesystemName("file");
		
		
		pw.print(html);
		String X = mr.getParameter("x");
		String Y = mr.getParameter("y");
		String oper = mr.getParameter("oper");
		int calc=0;
		try {
			int x =Integer.parseInt(X);
			int y = Integer.parseInt(Y);
			if(oper.equals("+")) {
				calc = x+y;
			} else if (oper.equals("-")) {
				calc=x-y;
			}else if(oper.equals("*")) {
				calc=x*y;
			}else if(oper.equals("/")) {
				calc=x/y;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		File f = new File(path+"/"+fileName);
		FileOutputStream fos = new FileOutputStream(f);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write(String.format("연산 결과 %s %s %s = %d", X,oper,Y,calc));
		bw.flush();
		bw.close();
		pw.print("<h1>");
		pw.printf("<a href=\"%s\" download=\"result.txt\">다운받기</a>","files/"+fileName);
		System.out.printf("<a href=\"%s\" download=\"result.txt\">다운받기</a>",path+"/"+fileName);
		pw.print("</body></html>");
	}

}
