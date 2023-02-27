package com.PAM.refgManager;

public class UserDTO {
	private String userid;
	private String managerName;
	private String userimage;
	private String area;
	public UserDTO(String userid, String managerName, String userimage, String area) {
		super();
		this.userid = userid;
		this.managerName = managerName;
		this.userimage = userimage;
		this.area = area;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getUserimage() {
		return userimage;
	}
	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
}
