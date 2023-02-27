package com.PAM.refgManager;

public class ItemConvInfoDTO {
	private static String[] events = {"no event", "1+1", "2+1", "3+1", "4+1"};
	private String convName;
	private String area;
	private String itemName;
	private int quantities;
	private int event;
	public ItemConvInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static String[] getEvents() {
		return events;
	}
	public static void setEvents(String[] events) {
		ItemConvInfoDTO.events = events;
	}
	public String getConvName() {
		return convName;
	}
	public void setConvName(String convName) {
		this.convName = convName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
