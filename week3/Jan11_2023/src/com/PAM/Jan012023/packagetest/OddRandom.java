package com.PAM.Jan012023.packagetest;
import java.util.Random;

public class OddRandom extends Random {
	@Override
	public int nextInt() {
		// TODO Auto-generated method stub
		int k =super.nextInt();
		return k%2==0?nextInt():k;
	}
	@Override
	public int nextInt(int bound) {
		// TODO Auto-generated method stub
		if(bound==1) {
			return super.nextInt(-1);
		}
		int k =super.nextInt(bound);
		return k%2==0?nextInt(bound):k;
	}
	

}
