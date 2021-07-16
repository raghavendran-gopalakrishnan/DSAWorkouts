package com.dsa.challenges.arrays;

import java.util.HashSet;

public class FindSum {
	static boolean findSumOfTwo(int[] A, int val) {
		HashSet<Integer> set = new HashSet<>();
		for(int i: A) {
			if (set.contains(val - i)) {
				return true;
			}
			set.add(i);
		}
		return false;
	}
	
	 public static void main(String[] args) {
		    int[] v = new int[] {5, 7, 1, 2, 8, 4, 3};
		    int[] test = new int[] {3, 20, 1, 2, 7};
		    
		    for(int i = 0; i < test.length; i++){
		    boolean output = findSumOfTwo(v, test[i]);
		    System.out.println("findSumOfTwo(v, " + test[i] + ") = " + (output ? "true" : "false"));
		    }
		  }
}
