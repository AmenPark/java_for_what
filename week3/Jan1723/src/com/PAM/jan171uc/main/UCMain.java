package com.PAM.jan171uc.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/* 서버
 * 클라이언트
 * 아파치 체험하기.
 * 
 * 통신
 * socket - 실시간 통신. 내가 받고자 할때가 아니라 저기서 원할때 주는방식.
 * http - 요청-응답. 내가 원할때만 받음.
 * 
 */
public class UCMain {
	public static void main(String[] args) {
		DefaultHttpClient dhc = new DefaultHttpClient();
		
		
		HttpGet hg = new HttpGet("https://www.naver.com/");
		try {
			HttpResponse hr = dhc.execute(hg);
			System.out.println(hr.getStatusLine());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(hr.getEntity().getContent()));
			String line = null;
//			while ((line=br.readLine())!=null) {
//				System.out.println(line);
//			}
			br.close();
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dhc.close();
		// session : 시간제한. 시간 지나면 자동으로 끊김. 혹은 HTTP서버에서 끊음.
		
	}
}
