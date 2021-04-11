package com.stackAndQueue;

public class FindCelebChallenge {


	public static int findCelebrity(int[][] party, int numPeople) {
		int celebrity = -1;
		Stack<Integer> stack = new Stack<Integer>(numPeople);
		for(int i=numPeople-1; i>=0 ; i--) {
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			int x = stack.pop();
			if(stack.isEmpty()) {
				celebrity = x;
				break;
			}
			int y = stack.pop();
			if(aqStatus(party, x, y)) {
				stack.push(y);
			} else {
				stack.push(x);
			}
		}
		for(int i=0;i<numPeople;i++) {
			if(celebrity!= i && (!aqStatus(party,i,celebrity) || aqStatus(party, celebrity, i))) {
				return -1;
			}
		}
		return celebrity;
	}
	
	 private static boolean aqStatus(int[][] party, int x, int y) {
	        if (party[x][y] == 1) return true;
	        return false;
	    }

	public static void main(String[] args) {
		int[][] party = {
		          {0,1,1,0},
		          {1,0,1,1},
		          {0,0,0,0},
		          {0,1,1,0},
		                };
		System.out.println(findCelebrity(party, 4));
	}

}
