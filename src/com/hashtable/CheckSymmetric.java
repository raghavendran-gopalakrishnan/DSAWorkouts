package com.hashtable;

import java.util.HashMap;

public class CheckSymmetric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
		System.out.println(findSymmetric(arr));
	}

	public static String findSymmetric(int[][] arr) {

		String result = "";
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			int first = arr[i][0];
			int second = arr[i][1];
			
			Integer value = hashMap.get(second);
			
			if(value !=null && value == first) {
				result += "{"+String.valueOf(second)+","+String.valueOf(first)+"}";
			} else {
				hashMap.put(first, second);
			}
		}
		// Write - Your - Code    
		return result; 
	}
}
