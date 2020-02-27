package com.stackAndQueue;

public class ReverseKChallenge {

	 public static <V> void reverseK(Queue<V> queue, int k) {
	        Stack<V> stack = new Stack<V>(k);
	        while(!stack.isFull())
	        	stack.push(queue.dequeue());
	        while(!stack.isEmpty())
	        	queue.enqueue(stack.pop());
	        for(int i=0; i< queue.currentSize - k ;i++)
	        	queue.enqueue(queue.dequeue());
	  }
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>(10);
		for(int i=1;i<=10;i++)
			queue.enqueue(i);
		reverseK(queue, 2);
		for(int i=0;i<queue.maxSize;i++)
			System.out.print(queue.dequeue()+" ");
	}

}
