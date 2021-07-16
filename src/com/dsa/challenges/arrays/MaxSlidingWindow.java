package com.dsa.challenges.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

	public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
		ArrayDeque<Integer> result = new ArrayDeque<>(); //to store the max of each window
		Deque<Integer> list = new LinkedList<Integer>(); // to hold temporary indices

		//validate 
		if(arr.length < windowSize)
			return result;
		
		/*
		 * At the start of the algorithm, we search for the maximum value in the first window. 
		 * The first element’s index is pushed to the front of the deque.
		 */
		for(int i=0; i<windowSize; i++) {
			//If the current element is larger, the back of the queue is popped repeatedly 
			//until we can find a higher value, and then we’ll push the index of the current element in as the new back.
			while(!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
				list.removeLast();
			}
			//If an element is smaller than the one at the back of the queue, then the index of this element is pushed in 
			//and becomes the new back. 
			list.addLast(i);
		}
		//The index of the current maximum element is at the front.
		result.add(arr[list.peek()]);
		
		for(int i=windowSize; i<arr.length; ++i) {
			
			//If the element no longer falls in the current window, remove the index of the element from the front.
			while(!list.isEmpty() && list.peek() <= i - windowSize)
				list.removeFirst();
			
			//Remove the indices of all elements from the back of the deque, which are smaller than or equal to the current element.
			while(!list.isEmpty() && arr[i] >= arr[list.peekLast()])
				list.removeLast();
			
			//Push the current element 	index at the back of the window.
			list.add(i);
			
			//The index of the current maximum element is at the front.
			result.add(arr[list.peek()]);
		}
		
		return result; 
	}

	public static void main(String[] args) {
		  int[] array = {-4,2,-5,3,6};
		    System.out.println("Array = " + Arrays.toString(array));
		    System.out.println("Max = " + findMaxSlidingWindow(array, 4));
		    
		    int[] array2 = {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67};
		    System.out.println("Array = " + Arrays.toString(array2));
		   System.out.println("Max = " + findMaxSlidingWindow(array2, 3));
	}

}
