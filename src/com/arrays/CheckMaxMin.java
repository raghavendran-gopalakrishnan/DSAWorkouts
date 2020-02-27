package com.arrays;

public class CheckMaxMin {
	public static void maxMin(int[] arr) {
		/*
		 * int size = arr.length; int[] rArr = new int[size]; int index = 0; for(int
		 * i=size-1;i>0;i--) { rArr[index] = arr[i]; if(index+2 < size) index+=2; else
		 * break; } index = 1; for(int i=0;i<size;i++) { rArr[index] = arr[i];
		 * if(index+2 < size) index+=2; else break; } for(int i=0;i<rArr.length;i++)
		 * arr[i] = rArr[i];
		 */
		int maxIdx = arr.length -1;
		int minIdx = 0;
		int maxElement = arr[maxIdx] + 1;
		/*
		 *  We actually store two elements at one index mathematically. 
		 *  The original element is stored as the remainder, while the max/min 
		 *  element is stored as the multiplier.
		 *  
		 *  Here, arr[maxId] is stored as the multiplier. Whereas, arr[i] is stored as the remainder. 
		 *  For example in the array, [1, 2, 3, 4, 5, 6, 7, 8, 9], the maxElem is 10 and 91 is stored at index 0. 
		 *  With 91, we can get the original element, 1, using the expression 91%10 as well as the new element as using 91/10.
		 */
		for(int i=0;i<arr.length;i++) {
			if(i % 2 == 0) {
				arr[i] += (arr[maxIdx] % maxElement) * maxElement;
				maxIdx--;
			}else {
				arr[i] += (arr[minIdx] % maxElement) * maxElement;
				minIdx++;
			}
		}
		for(int i=0;i<arr.length;i++) {
			arr[i] = arr[i]/maxElement;
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String args[]) {
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		maxMin(arr);
	}
}
