package com.stackAndQueue;

public class EvaluatePostfix {

	public static int evaluate(String expression) {
		Stack<Integer> stack = new Stack<Integer>(expression.length());
		/**
		 * loop through the expression string..
		 * Push all numeric characters in the stack
		 * When an operator character appears, pop the stack twice, perform the operation on the popped value and push the result back to stack.
		 * Continue till the end of the expression  
		 */
		for(int i=0;i<expression.length(); i++) {
			char ch = expression.charAt(i);
			if(!Character.isDigit(ch)) {
				Integer x = stack.pop();
				Integer y = stack.pop();
				switch(ch) {
				case '*':
					stack.push(y*x);
					break;
				case '+' :
					stack.push(y+x);
					break;
				case '-' :
					stack.push(y-x);
					break;
				case '/' :
					stack.push(y/x);
					break;
				}
			} else {
				stack.push(Character.getNumericValue(ch));
			}

		}
		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(evaluate("921*-8-4+"));
	}

}
