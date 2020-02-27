/**
 * 
 */
package com.stackAndQueue;

/**
 * @author ragg
 *
 */
public class Queue<V> {
	int maxSize ;
	int currentSize;
	int front;
	int back;
	V[] array;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.currentSize = 0;
		this.front = 0;
		this.back = -1;
		this.array = (V[])new Object[maxSize];
	}
	
	public boolean isFull() {
		return this.currentSize == this.maxSize;
	}
	
	public boolean isEmpty() {
		return this.currentSize == 0;
	}
	
	public V top() {
		return array[front];
	}
	
	public void enqueue(V data) {
		if(isFull())
			return;
		back = (back+1) % maxSize;
		array[back] = data;
		currentSize++;
	}
	
	public V dequeue() {
		if(isEmpty())
			return null;
		V temp = array[front];
		front = (front+1) % maxSize;
		currentSize--;
		return temp;
	}
	
	public static void main(String[] args) {
		Queue q = new Queue<Integer>(5);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.dequeue();
		q.dequeue();
		q.enqueue(8);
		q.enqueue(9);
		while(!q.isEmpty()){
            System.out.print(q.dequeue()+" ");
        }
	}
}
