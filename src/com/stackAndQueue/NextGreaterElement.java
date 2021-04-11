/**
 * 
 */
package com.stackAndQueue;

/**
 * @author ragg
 *
 */
public class NextGreaterElement {

	public static int[] getNextGreaterElement(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<Integer>(arr.length);
		for(int i=arr.length-1;i>=0;i--) {
			while(!stack.isEmpty() && stack.top() <= arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.top();
			}
			stack.push(arr[i]);
		}
		return result;
	} 
	public static void main(String[] args) {
		int[] arr = {2,4,3,6,5,7};
		int[] res = getNextGreaterElement(arr);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
	}

}
