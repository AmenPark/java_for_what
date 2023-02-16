package com.PAM.Feb16_2023.NumberBaseBall;

import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Model {
	private static final Model instance=new Model();
	private HashMap<String, data> hm;
	private HashMap<String, String> ansm;
	private Random _r;
	
	private Model() {
		hm = new HashMap<>();
		ansm = new HashMap<>();
		_r = new Random();
	}
	public static Model getInstance() {
		return instance;
	}
	
	private String getAddr(HttpServletRequest request) {
	    return (null != request.getHeader("X-FORWARDED-FOR")) ? request.getHeader("X-FORWARDED-FOR") : request.getRemoteAddr();
	}

	private String makeAns() {
		String ans = "";
		int v = 0;
		while(ans.length()<3) {
			v = _r.nextInt(10);
			if (ans.indexOf(v+"")==-1) {
				ans += v;
			}
		}
		return ans;
	}
	
	public void startGame(HttpServletRequest request) {
		String addr=getAddr(request);
		ansm.put(addr, makeAns());
		if(!hm.containsKey(addr)) {
			hm.put(addr, new data());
		}
	}
	
	public String judge(String input, String answer) {
		int S=0, B = 0;
		String rt="";
		for(int i=0;i<3;i++) {
			if(input.charAt(i) == answer.charAt(i)) {
				S++;
			}else if(answer.indexOf(input.substring(i,i+1))!=-1) {
				B++;
			}
		}
		if (S+B == 0) {
			return "X";
		}
		if(S>0) {
			rt += S+"S ";
		}
		if(B>0) {
			rt+=B + "B ";
		}
		return rt.trim();
	}
	
	public void playGame(HttpServletRequest request) {
		String addr = getAddr(request);
		if(!ansm.containsKey(addr)) {
			ansm.put(addr, makeAns());
		}
		if(!hm.containsKey(addr)) {
			hm.put(addr, new data());
		}
		String input = request.getParameter("input");
		String ans = ansm.get(addr);
		data d = hm.get(addr);
		d.addTurn();
		String j = judge(input,ans);
		
		if (j.startsWith("3S")) {
			hm.remove(addr);
			ansm.put(addr, makeAns());
			ansm.remove(addr);
			hm.put(addr, new data());
			int best_score =0;
			if (d.getBest_score()==0) {
				best_score = d.getTurn();
			}else {
				best_score = Math.min(d.getBest_score(), d.getTurn());
			}
			hm.get(addr).setBest_score(best_score);
		}
		d.addLog(input, j);
		request.setAttribute("data", d);
	}
}
