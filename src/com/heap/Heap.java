package com.heap;

import java.util.Arrays;

public class Heap {

	public static void main(String[] args) {
		//int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
		int[] heapArray = {9,4,7,1,-2,6,5};
		System.out.println("Before heapify: "+Arrays.toString(heapArray));		
		//buildMinHeap(heapArray, heapArray.length);
		//System.out.println("After heapify: "+Arrays.toString(heapArray));
		int[] minK = findKsmallest(heapArray, 2);
		System.out.println(Arrays.toString(minK));

	}
	
	public static int[] findKsmallest(int[] heapArray, int k) {
		int[] result = new int[k];
		int arrayLength = heapArray.length;
		if(k < arrayLength) {
			for(int i=0; i<k; i++) {
				result[i] = returnMin(heapArray,arrayLength);
				arrayLength--;
			}
			System.out.println(Arrays.toString(heapArray));
			return result; 	
		}
		System.out.println("k is out of bounds");
		return heapArray;
	}

	private static int returnMin(int[] heapArray, int arrayLength) {
		buildMinHeap(heapArray, arrayLength);
		int min = heapArray[0];
		heapArray[0] = heapArray[arrayLength-1];
		return min;
	}

	private void buildMaxHeap(int[] heapArray, int length) {
		for(int i=(length-1)/2; i>=0; i-- ) {
			maxHeapify(heapArray,i,length);
		}
	}

	private void maxHeapify(int[] heapArray, int index, int length) {
		int large = index;
		while(large < length/2) { //check only parent nodes
			int left = 2 * index + 1;
			int right = 2 * index + 2;

			if(left < length && heapArray[left] > heapArray[index]) {
				large = left;
			}
			if(right < length && heapArray[right] > heapArray[large]) {
				large = right;
			}

			if(large != index) {
				int temp = heapArray[index];
				heapArray[index] = heapArray[large];
				heapArray[large] = temp;
				index = large;
			} else {
				break;
			}
		}
	}
	
	private static void buildMinHeap(int[] heapArray, int length) {
		for(int i= (length-1)/2; i >= 0 ; i--)
			minHeapify(heapArray,i,length);
	}

	private static void minHeapify(int[] heapArray, int index, int length) {
		int smallest = index;
		while(smallest < length/2) {
			int left = 2 * index + 1;
			int right = 2 * index + 2;
			if(left < length && heapArray[left] < heapArray[index])
				smallest = left;
			if(right < length && heapArray[right] < heapArray[smallest])
				smallest = right;
			
			if(smallest != index) {
				int temp = heapArray[index];
				heapArray[index] = heapArray[smallest];
				heapArray[smallest] = temp;
				index = smallest;
			} else {
				break;
			}
		}
	}

}
