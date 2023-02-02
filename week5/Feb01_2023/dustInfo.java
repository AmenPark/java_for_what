package com.PAM.dust2DB;
import java.util.HashMap;
import java.util.Set;

public class dustInfo {
	private HashMap<String, String> data;
	public dustInfo() {
		data = new HashMap<>();
	}
	
	public String getData(String key) {
		return data.get(key);
	}

	public void setData(String key, String val) {
		data.put(key, val);
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
	public Set<String> getKey(){
		return data.keySet();
	}
	
	
}
