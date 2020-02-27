/**
 * 
 */
package com.stackAndQueue;

/**
 * @author ragg
 * @param <V>
 *
 */
public class Stack<V> {
	int maxSize;
	int top;
	V array[];
	
	public Stack(int max_size) {
		this.maxSize = max_size;
		this.top = -1;
		this.array = (V[])new Object[max_size];
	}
	
	public boolean isFull() {
		return top == maxSize - 1 ;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public V top() {
		if(isEmpty())
			return null;
		return array[top];
	}
	
	public void push(V data) {
		if(isFull())
			return;
		array[++top] = data;
	}
	
	public V pop() {
		if(isEmpty())
			return null;
		return array[top--];
	}
	
	public String toString() {
		String out = "";
		for(int i=0;i<=top;i++) {
			out += array[i] + " ";
		}
		return out;
	}
	
	public static void main(String[] args) {
		Stack st = new Stack(5);
		System.out.println(st.isEmpty());
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		System.out.println(st.isFull());
		System.out.println(st.toString());
		st.pop();
		System.out.println(st.isFull());
		System.out.println(st.toString());
		
	}
}
