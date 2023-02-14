package com.PAM.Feb14.VMCModel;

public class UCResult {
	private String unit1;
	private String what;
	private String unit2;
	private String result;
	private int c;
	public UCResult(String unit1, String what, String unit2, String result, int c) {
		super();
		this.unit1 = unit1;
		this.what = what;
		this.unit2 = unit2;
		this.result = result;
		this.c = c;
	}
	public String getUnit1() {
		return unit1;
	}
	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}
	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}
	public String getUnit2() {
		return unit2;
	}
	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	
	
	
}
