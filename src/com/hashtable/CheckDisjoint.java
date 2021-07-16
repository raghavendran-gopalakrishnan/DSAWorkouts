package com.hashtable;

import java.util.HashSet;

public class CheckDisjoint {

	public static void main(String[] args) {
		int[] arr1 = {9,4,3,1,-2,6,5};
		int[] arr2 = {7,10,8,5};
		System.out.println(isDisjoint(arr1, arr2));
	}

	public static boolean isDisjoint(int []arr1,int[]arr2) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<arr1.length; i++)
			set.add(arr1[i]);
		for(int j=0; j<arr2.length; j++) {
			if(set.contains(arr2[j]))
				return false;
		}
		return true;
	}
}
