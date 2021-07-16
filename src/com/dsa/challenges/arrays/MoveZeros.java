package com.dsa.challenges.arrays;

import java.util.Arrays;

public class MoveZeros {
	/*
	 * Given an integer array, move all elements that are 0 to the left while maintaining the order of other elements in the array. 
	 * The array has to be modified in-place.
	 * 
	 * read and write indexes initially point to the end of array.
	 * If read index element is 0, skip and decrement index
	 * else assign read index element in write index, decrement both
	 * 
	 * iterate till read index reaches the beginning of the array.
	 * 
	 * Set 0 in the beginning of array till write index.
	 * 
	 */
	static void moveZerosToLeft(int[] A) {
		if (A.length < 1) {
			return;
		}
		int readIndex = A.length-1;
		int writeIndex = A.length - 1;
		while(readIndex >= 0) {
			if(A[readIndex] == 0) {
				--readIndex;
				continue;
			}
			A[writeIndex] = A[readIndex];
			--readIndex;
			--writeIndex;
		}

		while(writeIndex >= 0) {
			A[writeIndex] = 0;
			writeIndex--;
		}
	}

	public static void main(String[] args) {
		int[] A = {1,10,20,0,59,63,0,88,0};
		moveZerosToLeft(A);
		System.out.println(Arrays.toString(A));
	}
}
