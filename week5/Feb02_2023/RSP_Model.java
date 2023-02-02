package com.PAM.lastJaVa;

import java.net.InetAddress;
import java.util.Random;

public class RSP_Model {
	private Random _r;
	
	
	public RSP_Model() {
		this._r = new Random();
	}

	public User getUser() {
		User you = null;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String name =  addr.getHostName();
			String ip = addr.getHostAddress();
			you =  new User(ip, name);
			
		} catch (Exception e) {
			// TODO: handle exception
			String name = "";
			for (int i=0;i<20;i++) {
				name += (char) (_r.nextInt(25)+'A');
			}
			you = new User("Anonymous", name);
		}
		return you;
		
	}
	
	public RSPGameData startGame(User you) {
		RSPGameData data = new RSPGameData(you);
		return data;
	}
	
	public void setBats(String s, RSPGameData data) {
		try {
			data.setBat(Long.parseLong(s));
		}catch (Exception e) {
		}
	}
	
	public String tryRSP(RSPGameData rspgamedata) {
		long score = rspgamedata.getScore();
		long bat = rspgamedata.getBat();
		int judge =(rspgamedata.getUser_choice() - rspgamedata.getCom_choice() + 3)%3;
		if(judge == 0) {
			
			return ("tie");
		} else if (judge == 2) {
			rspgamedata.setScore(score + bat );
			return ("win");
		} else {
			rspgamedata.setScore(score - bat );
			return("lose");
		}
		
	}
	
	public void ComRandomChoice(RSPGameData data) {
		data.setCom_choice(_r.nextInt(3)+1);
	}
	
	public int isValidDigit(String input) {
		if(input.length() == 1) {
			char c = input.charAt(0);
			if (Character.isDigit(c)) {
				int rt = Integer.parseInt(input);
				if(rt>0 & rt<4) {
					return rt;
				}
			}
		}
		return 0;
	}
}
