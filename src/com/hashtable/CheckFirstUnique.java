package com.hashtable;

import java.util.Map;
import java.util.TreeMap;

class CheckFirstUnique
{
  public static int findFirstUnique(int[] arr) 
  {
    int result = 0;
    Map<Integer,Integer> treeMap = new TreeMap<>();
    for(int i=0;i<arr.length; i++) {
    	if(treeMap.containsKey(arr[i])) {
    		treeMap.put(arr[i], treeMap.get(arr[i])+1);
    	} else {
    		treeMap.put(arr[i], 1);
    	}
    }
    
    for(int i=0;i<arr.length;i++) {
    	if(treeMap.get(arr[i]) == 1)
    		return arr[i];
    }
    return result;
  }
  
  public static void main(String args[]) {
	  int[] arr = {11,9, 2, 11, 3, 6, 6};
	  System.out.println(findFirstUnique(arr));
  }
}