package com.dsa.challenges.arrays;

import java.util.ArrayList;
import java.util.Iterator;

class Pair{
    public int first;
    public int second;
    
    public Pair(int x, int y){
      this.first = x;
      this.second = y; 
    }
}
/*
 * You are given an array (list) of interval pairs as input where each interval has a start and end timestamp. 
he input array is sorted by starting timestamps. You are required to merge overlapping intervals and return a new output array.

Consider the input array below. Intervals (1, 5), (3, 7), (4, 6), (6, 8) are overlapping so they should be merged to one big interval (1, 8). 
Similarly, intervals (10, 12) and (12, 15) are also overlapping and should be merged to (10, 15).
 */

class MergeIntervals{
  static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {
  ArrayList<Pair> result = new ArrayList<Pair>();
  if(v == null || v.size() == 0)
	  return null;
  
  //add 1st interval to the result
  result.add(0, new Pair(v.get(0).first, v.get(0).second));
  //loop the input array 
  for(int i=1; i<v.size(); i++) {
	  int x1 = v.get(i).first;
	  int y1 = v.get(i).second;
	  //Get the last interval values
	  int x2 = result.get(result.size()-1).first;
	  int y2 = result.get(result.size()-1).second;
	  //if current interval is overlapping with result, update the result interval
	  if (y2 >= x1) {
		result.get(result.size()-1).second = Integer.max(y1, y2);
	  } else { //else just a new interval to the result.
		  result.add(new Pair(x1, y1));
	  }
  }
  return result;
  }
  public static void main(String[] args) {
	    ArrayList<Pair> v = new ArrayList<Pair>();

	    v.add(new Pair(1, 5));
	    v.add(new Pair(3, 7));
	    v.add(new Pair(4, 6));
	    v.add(new Pair(6, 8));
	    v.add(new Pair(10, 12));
	    v.add(new Pair(11, 15));

	    ArrayList<Pair> result = mergeIntervals(v);

	    for(int i=0; i<result.size(); i++){
	      System.out.print(String.format("[%d, %d] ", result.get(i).first, result.get(i).second));
	    }
	  }
}
