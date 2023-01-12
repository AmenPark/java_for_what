package com.PAM.Jan1223.ThisIsJAVA;

/**
 * IronMan.
 * @author ImadeIt
 * 
 *
 */
public class IronMan implements Hero, Flier{
	
	@Override
	public void shootBeam() {
		// TODO Auto-generated method stub
		System.out.println("Beaaaaam");
		
	}
	
	@Override
	public void shootBeam(int iterationNum) {
		// TODO Auto-generated method stub
		System.out.println("Beeeeaaaaam " + iterationNum + " times");
		
	}
	
	@Override
	public void fly() {
		System.out.println("time flies like an arrow.");
	}
	
}


