package com.PAM.Feb07.studyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

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
@WebServlet("/ServletSecond")
public class ServletSecond extends HttpServlet {
	// 작업 버전 표시용.
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSecond() {
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
		Random _r = new Random();
		response.setCharacterEncoding("UTF-8");
		String html = "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>title</title>"
				+ "</head>"
				+ "<body>"
				+ "	<table id=\"siteTitle\" border=\"1\">"
				+ "		<tr>"
				+ "			<td align=\"center\">"
				+ "				<table id=\"siteTitle\">"
				+ "					<tr>"
				+ String.format("						<td style=\"font-size:40px\">%d</td>",_r.nextInt(15))
				+ "					</tr>"
				+ "				</table>"
				+ "			</td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td align=\"left\">"
				+ "				<table id=\"siteMenu\">"
				+ "					<tr>"
				+ "						<td><a href=\"https://www.naver.com\"> 한국어</a></td>"
				+ "						<td><a href=\"https://www.naver.com\"> Link2</a></td>"
				+ "						<td><a href=\"https://www.naver.com\"> LinkOut</a></td>"
				+ "					</tr>"
				+ "				</table>"
				+ "			</td>"
				+ "		</tr>"
				+ "	</table>" 
				+ " </head> </html>";
		PrintWriter pw = response.getWriter();
		pw.print(html);
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
