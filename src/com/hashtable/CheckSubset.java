package com.hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class CheckSubset {

	public static void main(String[] args) {
		int[] arr1 = {9,4,7,1,-2,6,5};
		int[] arr2 = {7,0,-2};
		System.out.println(isSubset(arr1, arr2));
	}

	public static boolean isSubset(int []arr1,int[]arr2) {
		HashSet set = new HashSet();
		for(int i=0; i<arr1.length; i++)
			set.add(arr1[i]);
		for(int j=0; j<arr2.length; j++) {
			if(!set.contains(arr2[j]))
				return false;
		}
		return true;
	}
}
