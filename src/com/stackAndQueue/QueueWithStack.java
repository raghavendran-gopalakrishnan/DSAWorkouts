package com.stackAndQueue;

public class QueueWithStack<V> {

	Stack<V> stack1;
	Stack<V> stack2;
	
	public QueueWithStack(int maxSize){
		this.stack1 = new Stack<V>(maxSize);
		this.stack2 = new Stack<V>(maxSize);
	}
	
	public void enqueue(V data) {
		stack1.push(data);
	}
	
	public V dequeue() {
		if(stack1.isEmpty() && stack2.isEmpty()) {
			return null;
		} else if (stack2.isEmpty()) {
			while(!stack1.isEmpty())
				stack2.push(stack1.pop());
			return stack2.pop();
		} else {
			return stack2.pop();
		}
	}
	public static void main(String[] args) {
		QueueWithStack<Integer> queue = new QueueWithStack<Integer>(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println(queue.dequeue());
	}

}
