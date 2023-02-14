package com.PAM.Feb14.model2VMC;

public class VOBMI {
	private String name;
	private String weight;
	private String height;
	private String stdweight;
	private String filePath;
	private String bmi;
	private String result;

	public VOBMI(String name, String weight, String height, String stdweight, String filePath, String bmi,
			String result) {
		super();
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.stdweight = stdweight;
		this.filePath = filePath;
		this.bmi = bmi;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getStdweight() {
		return stdweight;
	}

	public void setStdweight(String stdweight) {
		this.stdweight = stdweight;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
