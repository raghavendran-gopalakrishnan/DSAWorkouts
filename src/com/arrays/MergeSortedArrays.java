package com.arrays;

public class MergeSortedArrays {
	 public static void main(String args[])
	    {
	    	
	    	int[] arr1 = {1,3,4,5};
	    	int[] arr2 = {2,6,7,8};
	    	
	    	int[] rArr = new int[arr1.length+arr2.length];
	    	int i=0,j=0,k=0;
	    	while(i<arr1.length && j<arr2.length) {
	    		if(arr1[i] < arr2[j]) {
	    			rArr[k++] = arr1[i++];
	    		}else {
	    			rArr[k++] = arr2[j++];
	    		}
	    	}   	    	
	    	while(i < arr1.length) {
	    		rArr[k++] = arr1[i++];
	    	}
	    	while(j < arr2.length) {
	    		rArr[k++] = arr2[j++];
	    	}
	    	
	    	for(int a=0;a<rArr.length;a++) {
	    		System.out.println(rArr[a]);
	    	}
	    } 
}
