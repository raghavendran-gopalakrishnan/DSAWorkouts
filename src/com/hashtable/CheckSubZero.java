package com.hashtable;

import java.util.HashMap;

public class CheckSubZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,-5,10};
		System.out.println(findSubZero(arr));
	}
	/*
	 * We basically have to check for 3 conditions:

		If 0 exists in the array
		If the sum becomes zero in the iteration
		If the sum reverts back to a value which was already a key in the hash table
	 */
	
	public static boolean findSubZero(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum+= arr[i];

			if(arr[i] == 0 || sum == 0 || map.get(sum)!= null ) {
				return true;
			} else {
				map.put(sum, i);
			}
		}
		return false;
	}
}
