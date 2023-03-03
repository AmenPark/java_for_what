package com.PAM.Mar03_2023.Notice;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.PAM.mybatisDAOHelper.MybatisDAOHelper;

public class snackDAO {
	private static snackDAO instance;
	private SqlSession ss;
	private SqlSessionFactory sfb;
	private int ct;
	
	private snackDAO() throws Exception {
		sfb = MybatisDAOHelper.getInstance().getSsf("com/PAM/Mar03_2023/Notice/mappool.xml");
		
		
		ss=sfb.openSession();
		ct= ss.selectOne("SnackQ.selectCount");
	}
	
	
	public void selectSnack(HttpServletRequest request) {
		request.setAttribute("snacks", selectAllSnack());
		request.setAttribute("ct", ct);
	}
	
	public void insertSnack(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String name = request.getParameter("name");
		BigDecimal bd = new BigDecimal(Integer.parseInt(request.getParameter("price")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date d = sdf.parse(request.getParameter("date"));
			snackDTO snack = new snackDTO(name,bd,d);
			tryinsertSnack(snack);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("ct", ct);
	}
	
	private void tryinsertSnack(snackDTO snack) {
		ss = sfb.openSession();
		int r = ss.insert("SnackQ.InsertQ", snack);
		if(r==1) {
			System.out.println("등록 성공");
			ss.commit();
			ct++;
		}
		ss.close();
	}
	
	private List<snackDTO> selectAllSnack() {
		ss = sfb.openSession();
		List<snackDTO> al = ss.selectList("SnackQ.selectAll");
		ss.close();
		return al;
		
	}
	
	
	public static snackDAO getInstance() {
		if(instance==null) {
			try {
				instance = new snackDAO();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
}
