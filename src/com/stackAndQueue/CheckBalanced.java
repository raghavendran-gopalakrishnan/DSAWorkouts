/**
 * 
 */
package com.stackAndQueue;

/**
 * @author ragg
 *
 */
public class CheckBalanced {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isBalanced("{[)]}"));

	}
	
	public static boolean isBalanced(String exp) {
        char[] ch = exp.toCharArray();
        Stack<Character> stack = new Stack<Character>(ch.length);
        for(int i=0;i<ch.length;i++) {
        	if(ch[i] == '{' || ch[i] == '(' || ch[i] == '[') {
        		stack.push(ch[i]);
        	} else {
        		if(stack.isEmpty())
        			return false;
        		if((ch[i] == '}' && stack.pop() != '{') || (ch[i] == ']' && stack.pop() != '[')
        				|| (ch[i] == ')' && stack.pop() != '(')) {
        			return false;
        		}
        	}
        }
        if(!stack.isEmpty()) return false;
        return true;
        
    }

}
