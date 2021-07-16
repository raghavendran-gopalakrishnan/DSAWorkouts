package com.dsa.challenges.arrays;

import java.util.ArrayList;
import java.util.List;

public class RotateArray{
	static void rotateArray(List<Integer> arr, int n) {
		/*
		 *Given an array of integers, rotate the array by N elements where N is an integer:

		  For positive values of N, perform a right rotation.
		  For negative values of N, perform a left rotation.
		 * 
		 * Normalize the rotations so they do not exceed the length of the array.
		 * Convert negative rotations to positive rotations.
		 * Reverse the elements of the original array.
		 * Reverse the elements from 0 -> N-10−>N−1.
		 * Reverse the elements from N ->N−> length-1length−1.  
		 */
		int len = arr.size();
	    // Let's normalize rotations
	    // if n > array size or n is negative.
	    n = n % len;
	    if (n < 0) {
	      // calculate the positive rotations needed.
	      n = n + len;
	    }
	    /*
	     * Reverse the original array
	     * Reverse 0 till n-1 
	     * Reverse n till end of array	
	     */
	    reverseArray(arr, 0, len-1);
	    reverseArray(arr, 0, n-1);
	    reverseArray(arr, n, len-1);
	    
	    System.out.println(arr);
	}
	
	static void reverseArray(List<Integer> arr, int start, int end) {
		while(start < end) {
			int temp = arr.get(start);
			arr.set(start, arr.get(end));
			arr.set(end, temp);
			++start;
			--end;
		}
	}
	
	static void rotateArray1(List<Integer> arr, int n) {
		//Solution using temp array
		int len = arr.size();
	    // Let's normalize rotations
	    // if n > array size or n is negative.
	    n = n % len;
	    if (n < 0) {
	      // calculate the positive rotations needed.
	      n = n + len;
	    }
	    
	    List<Integer> temp = new ArrayList<Integer>(n);
	    //copy elements from Length-N to Length-1 to a temp array
	    for(int i=0 ;i<n ; i++) {
	    	temp.add(i, arr.get(len-n+i));
	    }
	    //Set elements to be rotated to the rightmost
	    for(int i=len-1; i>=n; i--)
	    	arr.set(i, arr.get(i-n));
	    //set elements from the temp array
	    for(int i=0;i<n; i++)
	    	arr.set(i, temp.get(i));
	    
	    System.out.println(arr);
	}
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		rotateArray1(arr , -4);
	}
}  