package com.PAM.refgManager;

public class ItemDTO {
	private static String[] events = {"no event", "1+1", "2+1", "3+1", "4+1"};
	private String itemname;
	private String itemtype;
	private int itemprice;
	private int quantities;
	private int event;
	
	public ItemDTO() {
		super();
	}
	public ItemDTO(String itemname, String itemtype, int itemprice, int quantities, int event) {
		super();
		this.itemname = itemname;
		this.itemtype = itemtype;
		this.itemprice = itemprice;
		this.quantities = quantities;
		this.event = event;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemtype() {
		return itemtype;
	}
	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	public int getItemprice() {
		return itemprice;
	}
	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}
	public int getQuantities() {
		return quantities;
	}
	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}
	public String getEvent() {
		return events[event];
	}
	public void setEvent(int event) {
		this.event = event;
	}
	
	
	
	
}
