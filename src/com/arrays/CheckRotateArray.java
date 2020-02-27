package com.arrays;

public class CheckRotateArray {
	public static void rotateArray(int[] arr){
		int temp = arr[arr.length-1];
		for(int i=arr.length-1;i>0;i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		for(int val : arr) {
			System.out.print(val + " ");
		}		
    }
	public static void main (String args[]) {
		int[] arr = {1, 2, 3, 4, 5};
		rotateArray(arr);
	}
}
