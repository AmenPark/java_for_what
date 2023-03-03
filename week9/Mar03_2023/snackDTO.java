package com.PAM.Mar03_2023.Notice;

import java.math.BigDecimal;
import java.util.Date;

public class snackDTO {
	private String s_name;
	private BigDecimal s_price;
	private Date exp;
	public snackDTO(String name, BigDecimal price, Date exp) {
		super();
		this.s_name = name;
		this.s_price = price;
		this.exp = exp;
	}
	public snackDTO() {
		super();
	}
	public String getName() {
		return s_name;
	}
	public void setName(String name) {
		this.s_name = name;
	}
	public BigDecimal getPrice() {
		return s_price;
	}
	public void setPrice(BigDecimal price) {
		this.s_price = price;
	}
	public Date getExp() {
		return exp;
	}
	public void setExp(Date exp) {
		this.exp = exp;
	}
	
	
}
