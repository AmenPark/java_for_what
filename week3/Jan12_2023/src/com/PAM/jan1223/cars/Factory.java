package com.PAM.jan1223.cars;

public class Factory {
	int ct;

	public Factory() {
		super();
		this.ct = 0;
	}
	
	public Car makeCar(String type) {
		if (type.equals("BUS")){
			return new Bus("버스", ct++, 10000);
			
		}else {
			return new Truck("트럭", ct++, 4000);
		}
	}
	
}
