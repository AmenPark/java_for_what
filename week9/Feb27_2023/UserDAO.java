package com.PAM.refgManager;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UserDAO {
	private static UserDAO instance;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psmt;

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
	public ArrayList<ItemConvInfoDTO> getRelationInfo(HttpServletRequest request, HttpServletResponse response){
		
		ArrayList<ItemConvInfoDTO> rt = new ArrayList<>();
		String area = request.getParameter("area");
		String itemList = request.getParameter("itemList");
		try {
			if(area==null) {
				area="";
			}
			if(itemList==null) {
				return null;
			}
			String query = String.format(
					"select managerName, area, itemName, quantities, event "
					+ "from stock left join item on item.itemid = stock.itemid "
					+ "left join CONV_USER on conv_user.userid = stock.userid "
					+ "where conv_user.area = '%s' and itemName in %s",area.trim(), itemList);
			selectQueryWithoutClose(query);
			ItemConvInfoDTO data = null;
			while(rs.next()) {
				data = new ItemConvInfoDTO();
				data.setConvName(rs.getString("managerName"));
				data.setArea(rs.getString("area"));
				data.setItemName(rs.getString("itemName"));
				data.setQuantities(rs.getInt("quantities"));
				data.setEvent(rs.getInt("event"));
				rt.add(data);
			}
			
		} catch (Exception e) {
			System.out.println("에러남");
			e.printStackTrace();
			return null;
		} finally {
			disconn();
		}
		
		return rt;
	}
	
	
	public void searchItem(HttpServletRequest request) {
		if (!isLogined(request)) {
			return;
		}
		
		if(request.getParameterNames().hasMoreElements()) {
			if(request.getParameter("search") == null
					|| (request.getParameter("search").equals(((String)request.getSession().getAttribute("search")))
							&& request.getParameter("s").equals(request.getSession().getAttribute("s")))
					) {
				// 키워드가 없거나 기존과 같은경우. 재검색이 필요없다
				request.setAttribute("rows",request.getParameter("rows"));
				request.setAttribute("rownum",
						request.getParameter("pageNum")==null?0:request.getParameter("pageNum"));
				if ("itemtype".equals(request.getParameter("s"))) {
					request.setAttribute("itemtypechecked", "checked=\"checked\"");
					request.getSession().setAttribute("s", "itemtype");
				}else {
					request.getSession().setAttribute("s", "itemname");
					
				}
				
			} else {
				UserDAO.getInstance().getItems(request);				
			}
			
		} else {
			UserDAO.getInstance().getItemFirst(request);
		}
	}

	private void getItems(HttpServletRequest request) {
		String where = "";
		if ("itemtype".equals(request.getParameter("s"))) {
			request.setAttribute("itemtypechecked", "checked=\"checked\"");
			request.getSession().setAttribute("s", "itemtype");
		} else {
			request.getSession().setAttribute("s", "itemname");
		}
		if (request.getParameter("search") != null) {
			String kw = request.getParameter("search");
			where = " and " + request.getParameter("s") + " like '%" + kw + "%' ";
		}
		UserDTO user = (UserDTO) (request.getSession().getAttribute("User"));
		String query = getItemsQuery(user.getUserid(), where);
		request.setAttribute("rows",request.getParameter("rows"));
		request.getSession().setAttribute("search",request.getParameter("search"));
		selectItemQuery(request,query);

	}

	private void getItemFirst(HttpServletRequest request) {
		UserDTO user = (UserDTO) (request.getSession().getAttribute("User"));
		String query = String.format(
					"select itemname, itemprice, itemtype, quantities, event, rownum as rn from ITEM left join stock on item.itemid = stock.itemid where userid='%s' order by itemname",user.getUserid());
		request.setAttribute("rows",5);
		request.getSession().setAttribute("search","");
		request.getSession().setAttribute("s", "itemname");
		selectItemQuery(request,query);
	}
	
	private void selectItemQuery(HttpServletRequest request, String query) {
		try {
			selectQueryWithoutClose(query);
			ArrayList<ItemDTO> items = new ArrayList<>();
			while (rs.next()) {
				items.add(new ItemDTO(rs.getString("itemname"), rs.getString("itemtype"), rs.getInt("itemprice"),
						rs.getInt("quantities"), rs.getInt("event")));
			}
			request.getSession().setAttribute("items", items);
			request.getSession().setAttribute("itemnum", items.size());
			request.setAttribute("rownum",0);


		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "DB접속이 힘듭니다.");
		} finally {
			disconn();
		}
	}

	private String getItemsQuery(String userid, String where) {
		String query = String.format(
				"select * from (select itemname, itemprice, itemtype, quantities, event, rownum as rn from ITEM left join stock on item.itemid = stock.itemid where userid='%s'%s order by itemname)",
				userid, where);
		return query;
	}

	public void withdrawal(HttpServletRequest request) {
		String imgpath = request.getSession().getServletContext().getRealPath("img/profile");

		if (isLogined(request)) {
			UserDTO user = (UserDTO) request.getSession().getAttribute("User");
			String query = String.format("delete from conv_user where userid='%s'", user.getUserid());
			int row = updateQuery(query);
			if (row == 1) {
				request.setAttribute("message", "삭제 완료");
				if (user.getUserimage() != null) {
					File f = new File(imgpath + "/" + user.getUserimage());
					f.delete();
				}

			} else if (row == 0) {
				request.setAttribute("message", "없는 계정");
			}
			request.getSession().setAttribute("User", null);

		} else {
			request.setAttribute("message", "잘못된 접근");
		}
	}

	public void chaingeUserInfo(HttpServletRequest request) {
		MultipartRequest mr = null;
		if (!isLogined(request)) {
			return;
		}
		String imgpath = request.getSession().getServletContext().getRealPath("img/profile");
		try {
			mr = new MultipartRequest(request, imgpath, 11000000, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			request.setAttribute("message", "파일이 너무 커요!");
			return;
		}

		String name = mr.getParameter("name");
		String pw = mr.getParameter("oripw");
		String newpw = mr.getParameter("newpw");
		String file = mr.getFilesystemName("file");

		UserDTO user = (UserDTO) request.getSession().getAttribute("User");
		if (checkPw(request, pw)) {
			String query = "update conv_user set"
					+ (name != null && name.length() > 0 ? String.format(" managername='%s',", name) : "")
					+ (newpw != null && newpw.length() > 0 ? String.format(" userpw='%s',", newpw) : "")
					+ (file != null && file != "" ? String.format(" userimage='%s',", file) : "")
					+ (String.format(" up_to_date=sysdate where userid='%s'", user.getUserid()));
			if (updateQuery(query) == 1) {
				request.setAttribute("message", "변경성공!");
				if (user.getUserimage() != null && mr.getFilesystemName("file") != null) {
					File f = new File(imgpath + "/" + user.getUserimage());
					f.delete();
					user.setUserimage(file);
				}
				if (name != null && name.length() > 0) {
					user.setManagerName(name);
				}

			} else if (updateQuery(query) == 0) {
				request.setAttribute("message", "변경오류! 없는 계정입니다!");
				if (file != null) {
					File f = new File(imgpath + "/" + mr.getFilesystemName("file"));
					f.delete();
				}
			}
		} else {
			request.setAttribute("message", "올바르지 못한 비밀번호");
			if (file != null) {
				File f = new File(imgpath + "/" + mr.getFilesystemName("file"));
				f.delete();
			}
		}

	}

	private int updateQuery(String query) {
		makeconn();
		int row = 0;
		try {
			psmt = con.prepareStatement(query);
			row = psmt.executeUpdate();
		} catch (Exception e) {
		}
		disconn();
		return row;
	}

	private boolean checkPw(HttpServletRequest request, String pw) {
		UserDTO user = (UserDTO) request.getSession().getAttribute("User");
		try {
			selectQueryWithoutClose(
					String.format("select userid, userpw from conv_user where userid='%s'", user.getUserid()));
			if (rs.next()) {
				if (pw.equals(rs.getString("userpw"))) {
					return true;
				}
			} else {
				request.setAttribute("message", "이상한 에러가 떴습니다.");
				return false;
			}
		} catch (Exception e) {
			request.setAttribute("message", "DB연결실패!");
		} finally {
			disconn();
		}
		return false;
	}

	public boolean isLogined(HttpServletRequest request) {
		if (request.getSession().getAttribute("User") == null) {
			request.setAttribute("log", "jsp/login.jsp");
			return false;
		} else {
			request.setAttribute("log", "jsp/logout.jsp");
			return true;
		}
	}

	public void loginUser(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		try {
			request.getSession().setAttribute("User", SignInUser(id, pw, request));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "서버가 불안정해 연결할 수 없습니다.");
		}
	}

	private UserDTO SignInUser(String id, String pw, HttpServletRequest request) throws Exception {
		UserDTO user = null;
		try {
			selectQueryWithoutClose(String.format(
					"select userid, userpw, managername, userimage, area  from conv_user where userid = '%s'", id));

			if (rs.next()) {
				if (rs.getString("userpw").equals(pw)) {
					user = new UserDTO(rs.getString("userid"), rs.getString("managername"), rs.getString("userimage"),
							rs.getString("area"));
				} else {
					request.setAttribute("message", "패스워드 불일치");
				}
			} else {
				request.setAttribute("message", "없는 id입니다");

			}
		} catch (Exception e) {
			throw e;
		} finally {
			disconn();
		}
		return user;
	}

	public void SignUpUser(HttpServletRequest request) {
		MultipartRequest mr = null;
		String imgpath = request.getSession().getServletContext().getRealPath("img/profile");
		try {
			mr = new MultipartRequest(request, imgpath, 11000000, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			request.setAttribute("message", "파일이 너무 커요!");
			return;
		}
		String id = String.format("'%s'", mr.getParameter("id"));
		String pw = String.format("'%s'", mr.getParameter("pw"));
		String name = String.format("'%s'", mr.getParameter("name"));
		String area = String.format("'%s'", mr.getParameter("area"));
		String fileName = mr.getFilesystemName("file") == null ? "Null"
				: String.format("'%s'", mr.getFilesystemName("file"));
		try {
			int t = insertUser(id, pw, name, area, fileName);
			if (t == 1) {
				request.getSession().setAttribute("User", new UserDTO(mr.getParameter("id"), mr.getParameter("name"),
						mr.getFilesystemName("file"), mr.getParameter("area")));
			} else {
				request.setAttribute("message", "아이디 중복");
				// 파일삭제
				if (mr.getFilesystemName("file") != null) {
					File f = new File(imgpath + "/" + mr.getFilesystemName("file"));
					f.delete();
				}
			}
		} catch (Exception e) {
			if (mr.getFilesystemName("file") != null) {
				File f = new File(imgpath + "/" + mr.getFilesystemName("file"));
				f.delete();
			}
			request.setAttribute("message", "서버연결실패");
		}
	}

	private void selectQueryWithoutClose(String query) throws SQLException {
		makeconn();
		rs = null;
		psmt = con.prepareStatement(query);
		rs = psmt.executeQuery();

	}

	private int insertUser(String id, String pw, String name, String area, String fileName) {
		String query = String.format("insert into conv_user values(%s, %s, %s, %s, %s, sysdate, sysdate)", id, pw, name,
				area, fileName);
		return insertQuery(query);
	}

	private int insertQuery(String query) {
		makeconn();
		rs = null;
		psmt = null;
		int row = 0;
		try {
			psmt = con.prepareStatement(query);
			row = psmt.executeUpdate();

		} catch (Exception e) {

		}
		disconn();
		return row;
	}

	private void makeconn() {
		con = null;
//		자바에서 하지만 톰캣 설정파일을 참조해서 시작하므로 아래처럼만 써줘도 작동. context.xml뭐시기 할 필요는 없다.
		Context ctx;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/ConvPool");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		설정파일에 여러가지 존재 가능하다. 이름으로 찾는다. java:comp/env/이름 을 string으로 줘서 찾음.
	}

	private void disconn() {
		try {
			rs.close();
		} catch (Exception e) {
		}
		try {
			psmt.close();
		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}
	}
}
