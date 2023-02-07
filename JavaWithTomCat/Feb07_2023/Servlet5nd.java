package com.PAM.Feb07.studyServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet project. 이클립스에서는 servlet project 생성 눌러주면 자동으로 상속을 만들어준다. server+applet(application).
//WAS에서만 실행 가능함. TomCat을 쓸 예정.
//HTML/CSS를 생성해서 응답해주는 프로그램. 즉, HTML CSS를 자동화.
//sevlet을 톰캣에 등록해야만 쓸 수 있음. 그걸 자동화? 어노테이션을 사용하는데, 컴파일러에게 뭔가 알려주거나 설정하는 등의 용도로 잘 쓴다.
//export web archive 파일 WAR로 내놓아서(특정서버로 최적화는 판단할것) 서버에 옮긴다.

/**
 * Servlet implementation class ServletFirst
 */
@WebServlet("/Servlet5nd")
public class Servlet5nd extends HttpServlet {
	// 작업 버전 표시용.
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet5nd() {
        super();
        // TODO Auto-generated constructor stub
        // 언제 만들어지지? main은 톰캣에서 알아서. 생성자는 알아서 쓰인다. 거의 쓸 일이 없다.
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get 요청에 대한 응답. 톰캣이 호출한다. 
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		String html = "<html><head><meta charset=\"UTF-8\"><title>제목</title></head><body>";
		pw.print(html);
		String bd = request.getParameter("border");
		pw.printf("<table border=\"%s\">",bd);
		int dan = Integer.parseInt( request.getParameter("dan"));
		
		for(int i=1;i<10;i++) {
			pw.printf("<tr><td>%d * %d = %d</td></tr>",dan,i,dan*i);
		}
		pw.print("</table>");
		pw.print(" </body></head> </html>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post 요청");
		doGet(request, response);
	}

}
