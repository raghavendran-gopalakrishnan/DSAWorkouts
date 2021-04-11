/**
 * 
 */
package com.stackAndQueue;

/**
 * @author ragg
 *
 */
public class MinStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinStack stack = new MinStack(5);
		stack.push(4);
		stack.push(3);
		stack.push(8);
		stack.push(2);
		stack.push(5);
		System.out.println(stack.min());
	}

	int maxSize;
	Stack<Integer> mainStack ;
	Stack<Integer> minStack;
	int minValue = Integer.MIN_VALUE;
	
	//constructor
	public MinStack(int maxSize) {
		// Write -- Your -- Code
		this.maxSize = maxSize;
		mainStack = new Stack<Integer>(maxSize);
		minStack = new Stack<Integer>(maxSize);
	}
	//removes and returns value from stack
	public Integer pop(){
		minStack.pop();
		return mainStack.pop();
	}
	//pushes value into the stack
	public void push(Integer value){
		mainStack.push(value);
		if(!minStack.isEmpty()) {
			if(minStack.top() < value) {
				minStack.push(minStack.top());
			} else {
				minStack.push(value);
			}
		} else {
			minStack.push(value);
		}
	}
	//returns minimum value in O(1)
	public int min(){
		// Write -- Your -- Code
		return minStack.top();
	}

}
