package com.arrays;

import java.util.Arrays;

public class CheckSecondMax {
	public static int findSecondMaximum(int[] arr)
	  {
	    // Write - Your - Code
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > max) {
				secondMax = max;
				max = arr[i];
			} else if(arr[i] > secondMax && max != arr[i]) {
				secondMax = arr[i];
			}
		}
		return secondMax;
	  }
	public static void main(String args[]) {
		int[] arr = {9,2,3,6};
		System.out.println(findSecondMaximum(arr));
	}
}
