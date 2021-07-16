package com.hashtable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckPath {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("NewYork", "Chicago");
		map.put("Boston", "Texas");
		map.put("Missouri", "NewYork");
		map.put("Texas", "Missouri");
		System.out.println(tracePath(map));
	}

	public static String tracePath(Map<String,String> map) {
		String result = "";
		HashMap<String,String> reverseMap = new HashMap<>();
		for(Map.Entry<String,String> entry : map.entrySet()) {
			reverseMap.put(entry.getValue(), entry.getKey());
		}
		
		String from = ""; //to store the first node
		int count = 0; // to check if graph is disconnected
		 //Traverse original map and see if corresponding key exist in reverse Map
		for(Map.Entry<String, String> entry : map.entrySet()) {
			if(!reverseMap.containsKey(entry.getKey())) {
				from = entry.getKey();
				count++;
			}
		}
		
		if(count == 0)
			return null;
		
		String to = map.get(from);
		while(to != null) {
			result+= from+"->"+to+",";
			from = to;
			to = map.get(from);
		}
		
		return result; 
	}

}
