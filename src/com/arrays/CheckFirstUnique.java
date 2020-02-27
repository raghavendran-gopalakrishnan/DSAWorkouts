package com.arrays;

public class CheckFirstUnique {
	public static int findFirstUnique(int[] arr) {
		int unique = 0;
		boolean isRepeated = false;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i] == arr[j] && i!=j) {
					isRepeated = true;
					break;
				}
			}
			if(!isRepeated) {
				unique = arr[i];
				break;
			}else {
				isRepeated = false;
			}
		}
		
		return unique;
	}
	public static void main(String args[]) {
		int[] arr = {2, 54, 7, 2, 6, 54};
		System.out.println(findFirstUnique(arr));
	}
}
