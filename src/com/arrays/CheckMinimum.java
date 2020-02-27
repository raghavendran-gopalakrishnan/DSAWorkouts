package com.arrays;

public class CheckMinimum {

	public static int findMinimum(int[] arr) {
		// Write your code here
		int minimum = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(minimum > arr[i])
				minimum = arr[i];
		}
		return minimum;        
	}
	public static void main(String args[]) {
		int[] arr = {10,7,9,4,8,1,-1};
		System.out.println(findMinimum(arr));
	}
}
