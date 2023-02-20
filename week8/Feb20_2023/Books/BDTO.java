package com.PAM.Feb20_2023.Books;

import java.util.ArrayList;
import java.util.Date;

public class BDTO {
	private ArrayList<String> authors;
	private String contents;
	private Date datetime;
	private String price;
	private String thumbnail;
	private String title;
	public BDTO() {
		authors = new ArrayList<>();
		contents = "";
		datetime = new Date();
		price = "0";
		thumbnail = "thumb";
		title = "title";
	}
	public BDTO(ArrayList<String> authors, String contents, Date datetime, String price, String thumbnail,
			String title) {
		super();
		this.authors = authors;
		this.contents = contents;
		this.datetime = datetime;
		this.price = price;
		this.thumbnail = thumbnail;
		this.title = title;
	}
	public ArrayList<String> getAuthors() {
		return authors;
	}
	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		return String.format("=====\n작가-%s\n컨텐츠-%s\n시간=%s\n가격-%s\n썸네일-%s\n타이틀-%s", authors.toString(), contents, datetime.toString(), price, thumbnail, title);
	}
	
}
