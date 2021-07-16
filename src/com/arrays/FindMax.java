package com.arrays;

class FindMax {
	/*
	 * currMax = A[0]
	   globalMax = A[0]
		for i = 1 -> size of A
	    if currMax is less than 0
	        then currMax = A[i]
	    otherwise 
	        currMax = currMax + A[i]
	    if globalMax is less than currMax 
	        then globalMax = currMax
	 */
    public static int findMaxSumSubArray(int[] arr) {
    	int currMax = arr[0];
        int globalMax = arr[0];
        for(int i=1; i<arr.length; i++) {
           if(currMax < 0)
        		currMax = arr[i];
           else
        	  currMax += arr[i];
        	if(currMax > globalMax)
        		globalMax = currMax;
           
        }
        return globalMax;
    }


	public static void main(String[] args) {
		int[] arr = {1, 7, -2, -5, 10, -1};
		System.out.println(findMaxSumSubArray(arr));
	}

}
