package com.PAM.JAN2523.datas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

/*
 * list - ArrayList<내부타입> 방식으로 자료형 선언.
 * size -> list의 크기. length쓰던 []방식과 다르다.
 * 인덱스 값 가져오기는 get으로 한다.
 * 정렬시에는 comparator을 이용해서 정렬. overrider이다. generic<>을 동일하게.
 * 
 * 스레드 사용시 - thread를 상속받는 것도 가능하나 실질적인 상속 개념을 쓰기 위해 인터페이스 사용.
 * runnable 을 implement한다. run()을 override한다.
 * 익명내부함수를 이용하여 바로정의도 가능하나 그럼 상속을 못해서... 약하다.
 * run은 실행동안 진행할것을 의미하는듯.
 * thread.start()를 통해서 스레드 실행.
 * 
 * socket - 실시간 통신용. 서버->클라이언트로도 뭔가 보내기 가능.
 * socket s = new socket(localhost, "1234")와 같이 클라이언트에서 접속.
 * 서버측에서는 ServerSocket(1234)와 같이 생성. 1234가 일치해야만 접속 가능하다. 포트 일치시키기. 0~65535(16bit).
 * ServerSocket.accept() -> 소켓에 누군가 접속시. 
 * 
 */

public class subwayMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("D:\\dataetc\\Subway.csv");
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			br = new BufferedReader(isr);
			
			String line = null;
			ArrayList<SubwayStationInfo> ssiList = new ArrayList<>();
			while((line = br.readLine())!=null) {
				if (line.startsWith("2015\t01\t11")){
					break;
				}
				try {
					ssiList.add(new SubwayStationInfo(line));					
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				
			}
			
			System.out.println(ssiList.size());
			
			long onSum = 0;
			long offSum = 0;
			for (SubwayStationInfo ssi : ssiList) {
				onSum += ssi.getGet_on();
				offSum += ssi.getGet_off();
			}
			System.out.println(onSum+" "+offSum);
			
			ssiList.sort(new Comparator<SubwayStationInfo>() {
				@Override
				public int compare(SubwayStationInfo o1, SubwayStationInfo o2) {
					// TODO Auto-generated method stub
					return o1.getGet_on() + o1.getGet_off() - o2.getGet_on() - o2.getGet_off();
				}
				
			});
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
