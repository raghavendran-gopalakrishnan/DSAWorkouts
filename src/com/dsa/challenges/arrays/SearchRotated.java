package com.dsa.challenges.arrays;

public class SearchRotated {

	public static void main(String[] args) {
		int[] v1 = {6, 7, 1, 2, 3, 4, 5};
		System.out.println("Key(3) found at: " + binarySearchRotated(v1, 3));
		System.out.println("Key(6) found at: " + binarySearchRotated(v1, 6));

		int[] v2 = {4, 5, 6, 1, 2, 3};
		System.out.println("Key(3) found at: " + binarySearchRotated(v2, 3));
		System.out.println("Key(6) found at: " + binarySearchRotated(v2, 6));    
	}

	static int binarySearchRotated(int[] arr,int key) {
		return binarySearch(arr, 0, arr.length - 1, key);
	}

	private static int binarySearch(int[] arr, int start, int end, int key) {
		if(start > end)
			return -1;
		int mid = start + (end-start)/2;
		if(arr[mid] == key)
			return mid;

		if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start]) {
			return binarySearch(arr, start, mid - 1, key);
		}

		else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
			return binarySearch(arr, mid + 1, end, key);
		}
		else if (arr[end] <= arr[mid]) {
			return binarySearch(arr, mid + 1, end, key);
		}

		else if (arr[start] >= arr[mid]) {
			return binarySearch(arr, start, mid - 1, key);
		}

		return -1;
	}

}
