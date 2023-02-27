package com.PAM.refgManager;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;


// 중복 제거 전략 토큰 생성. 페이지에 토큰부여-제출. 토큰이 중복이라면 거부?
// 그냥 시간에 따른 토큰 생성. 최근성공토큰만 저장한 이후 그것보다 이전의 토큰을 무효처리한다면?
public class TokenGenerator {
	private static int num = 0;
	private static Date d;
	public static void generate(HttpServletRequest req) {
		Date now = new Date();
		if(d.equals(now)) {
			num+=1;
		}else {
			d = now;
			num = 0;
		}
		req.setAttribute("token",new SimpleDateFormat("YYYYMMDDHHmmssSS").format(new Date()) + num);
		
	}
}
