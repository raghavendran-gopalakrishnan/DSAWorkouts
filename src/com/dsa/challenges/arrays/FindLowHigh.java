package com.dsa.challenges.arrays;

import java.util.Arrays;
import java.util.List;

public class FindLowHigh {

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4,4, 5, 5, 5, 6, 6, 6, 6, 6, 6);
		int key = 5;
		int low = findLowIndex(array, key);
		int high = findHighIndex(array, key);
		System.out.println("Low Index of " + key + ": " + low);
		System.out.println("High Index of " + key + ": " + high);

		key = -2;
		low = findLowIndex(array, key);
		high = findHighIndex(array, key);
		System.out.println("Low Index of " + key + ": " + low);
		System.out.println("High Index of " + key + ": " + high);
	}

	/*
	 * Low index #
		Let’s look at the algorithm for finding the low index:
		
		At every step, consider the array between low and high indices and calculate the mid index.
		
		If the element at mid index is less than the key, low becomes mid + 1 (to move towards the start of range).
		
		If the element at mid is greater or equal to the key, the high becomes mid - 1. Index at low remains the same.
		
		When low is greater than high, low would be pointing to the first occurrence of the key.
		
		If the element at low does not match the key, return -1.
		
	   High index #
		Similarly, we can find the high index by slightly modifying the above condition:
		
		switch the low index to mid + 1 when element at mid index is less than or equal to the key.
		switch the high index to mid - 1 when the element at mid is greater than the key.
	 */

	static int findLowIndex(List<Integer> arr, int key) {
		int low = 0;
		int high = arr.size()-1;
		int mid = high/2;

		while(low <= high) {
			if(arr.get(mid) < key)
				low = mid + 1;
			else
				high = mid-1;

			mid = low + (high-low)/2; 
		}
		if(low < arr.size() && arr.get(low) == key)
			return low;
		return -1;
	}

	static int findHighIndex(List<Integer> arr, int key) {
		int low=0;
		int high = arr.size()-1;
		int mid = high/2;
		while(low <= high) {
			if(arr.get(mid) <= key)
				low = mid+1;
			else
				high = mid-1;
			mid = low + (high-low)/2;
		}

		if(high == -1){
			return high;
		}
		if(high < arr.size() && arr.get(high) == key)
			return high;
		return -1;
	}

}
