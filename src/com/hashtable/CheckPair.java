package com.hashtable;

import java.util.HashMap;

public class CheckPair {

	public static void main(String[] args) {
		 int[] arr = {3, 4, 7, 1, 12, 9};
	     System.out.println(findPair(arr)); //{4,12},{7,9}
	}
	
	public static String findPair(int[] arr) {
		String result = "";
		HashMap<Integer,int[]> map = new HashMap<>();
		for(int i=0; i<arr.length; i++)
			for(int j=i+1; j<arr.length; j++) {
				int sum = arr[i] + arr[j];
				if(map.containsKey(sum)) {
					int[] prev_sum = map.get(sum);
					result += "{"+prev_sum[0]+","+prev_sum[1]+"},{"+arr[i]+","+arr[j]+"}";
					return result;
				} else {
					map.put(sum, new int[] {arr[i],arr[j]});
				}
			}
		return result;
	}

}
