package com.dsa.challenges.arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222};
		int[] inputs = {10, 49, 99, 110, 176};

		for (int i = 0; i < inputs.length; i++) {
			System.out.println("binarySearch(arr, " + inputs[i]+ ") = " +  binarySearch(arr, inputs[i]));
		}
	}

	static int binarySearch(int[] arr, int key) {
		//return binarySearchRec(arr, 0, arr.length-1, key);
		return binarySearchIter(arr, key);
	}


	/**
	 * if low is greater than high, key is not found
	 * 
	 * find mid index, and check if mid value is equal to key
	 * 
	 * else if mid value is greater than the key, the key might be in the first half of the array.. recursively repeat between low and mid-1
	 *  
	 * else, key might be in the second half.. recursively repeat between mid+1 and high
	 * @param arr
	 * @param low
	 * @param high
	 * @param key
	 * @return Index of the key, if found.
	 */
	static int binarySearchRec(int[] arr, int low, int high, int key) {
		if(low > high)
			return -1;
		int mid = low+ ((high-low)/2);
		if(arr[mid] == key)
			return mid;
		else if(arr[mid] > key)
			return binarySearchRec(arr, low, mid-1, key);
		else
			return binarySearchRec(arr, mid+1, high, key);
	}
	
	static int binarySearchIter(int[] arr, int key) {
		int low = 0;
		int high = arr.length-1;
		
		while(low <= high) {
			int mid = low + ((high-low)/2);
			if(arr[mid] == key)
				return mid;
			else if(arr[mid] > key)
				high = mid-1;
			else
				low = mid+1;
		}
		return -1;
	}

}
