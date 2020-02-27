package com.stackAndQueue;

public class CheckSort {

	public static void sortStack(Stack<Integer> stack) {
		/*
		 * Using a temporary stack 
		 * 1. Push values from Stack to temp stack one by one when Stack value is >= top of temp stack
		 * 2. If top of tempstack is > than Stack value, pop every value from temp to main stack till the temp stack top value is > current stack value
		 *   2.1 Push the current stack value 
		 */
		Stack<Integer> newStack = new Stack<Integer>(stack.maxSize);
		while(!stack.isEmpty()) {
			int value = stack.pop();
			if(!newStack.isEmpty() && value >= newStack.top())
				newStack.push(value);
			else {
				while(!newStack.isEmpty() && value <= newStack.top()) {
					stack.push(newStack.pop());
				}
				newStack.push(value);
			}
				
		}
		while(!newStack.isEmpty()) {
			stack.push(newStack.pop());
		}
	}

	public static void sortStackRec(Stack<Integer> stack) {
		/*
		 * Recursively pop all elements of the stack. (sortStackRec method)
		 * Start inserting the popped element recursively back to the stack by comparing with the current top element,and place the element its
		 * appropriate position (insert method) 
		 */
	        if(!stack.isEmpty()){
	            int value = stack.pop();
	            sortStack(stack);
	            insert(stack,value);
	        }
	    }
	    public static void insert(Stack<Integer> stack, int value){
	        if(stack.isEmpty() || value < stack.top()){
	            stack.push(value);
	        } else {
	            int temp = stack.pop();
	            insert(stack, value);
	            stack.push(temp);
	        }
	    }

	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>(7);
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);
        sortStackRec(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
	}

}
