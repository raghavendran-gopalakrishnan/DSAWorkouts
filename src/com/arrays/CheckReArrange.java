package com.arrays;

public class CheckReArrange {
	public static void reArrange(int[] arr) {
		int j=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] < 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
			
		}
		
	}
	
	public static void main(String args[]) {
		int[] arr = {10, -1, 20, 4, 5, -9, -6};
		reArrange(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
