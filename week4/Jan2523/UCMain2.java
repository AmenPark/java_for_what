package com.PAM.JAN2523.datas;
/*
 * 데이터 여럿 - 기본배열 []는 잘 안씀.
 * 주력으로 쓰는 list - arrayList<Type> 꼴로 잘 쓰임.
 * set 계열이 존재. HashSet : 중복은 무시. 순서가 없다. hash의 특징.
 * Map 계열. 또는 dictionary계열이라고도 한다.(타 언어 기준)
 * java에서는 Map이다.
 * 대표적으로 HashMap이 있고, 그 외에도 TreeMap 등이 존재.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UCMain2 {
	public static void main(String[] args) {
		
		HashSet<Integer> hs = new HashSet<>();
		hs.add(13);		hs.add(37);		hs.add(24);		hs.add(13);
		System.out.println(hs);
		System.out.println(hs.size()); // 중복을 무시한다.
		ArrayList<Integer> al = new ArrayList<>(hs); // set -> arrayList.
		System.out.println(al);
		
		System.out.println("==========");
		
		ArrayList<String> al2 = new ArrayList<>();
		al2.add("abc");	al2.add("abcde");	al2.add("bcd");
		al2.add("abc"); al2.add("bcd");
		System.out.println(al2);
		HashSet<String> hs2 = new HashSet<>(al2);
		System.out.println(hs2);
		
		
		System.out.println("===============");
		HashSet<weatherInfo> hsw = new HashSet<>();
		weatherInfo wi = new weatherInfo();
		hsw.add(wi);
		hsw.add(new weatherInfo(0,1,1.0));
		hsw.add(new weatherInfo(0,0,0.0));
		hsw.add(new weatherInfo(0,1,1.0));
		hsw.add(new weatherInfo(0,1,1.0));
		hsw.add(new weatherInfo(0,1,1.0));
		hsw.add(wi);
		System.out.println(hsw.size());
		
		
		System.out.println("==========");
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("abc", 155);
		hm.put("abc", 111);
		hm.put("ab", 145);
		hm.put("ac", 195);
		System.out.println(hm);	// 마찬가지로 중복제거. 동일키에 대한 값 put시 update된다.
		System.out.println(hm.size());
		System.out.println(hm.get("ab"));
		System.out.println(hm.keySet());	// <- hashSet이 아니라 그냥 Set으로 준다.
		Set<String> s = hm.keySet();
		
		hm.remove("abc");
		System.out.println(hm);
		
	}

	
}
