package com.dsa.challenges.linkedList;


public class RotateList {

	public static LinkedListNode rotateList(LinkedListNode head, int n) {
		if(head == null || n == 0)
			return head;
		
		int N = findListSize(head);
		
		n = n % N;
		if(n < 0 ) {
			n = n + N;			
		}
		
		if(n == 0)
			return head;
		
		int rotationCount = N - n ;
		LinkedListNode temp = head;
		while(--rotationCount > 0) {
			temp = temp.next;
		}
		
		LinkedListNode newHead = temp.next;
		temp.next = null;
		temp = newHead;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;	
		
		return newHead;
	}

	private static int findListSize(LinkedListNode head) {
		int length = 0;
		while(head != null) {
			head = head.next;
			length++;
		}
		return length;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		int[] arr = {1,2,3,4,5};
		LinkedListNode head = list.createLinkedList(arr);
		head = rotateList(head, -2);
		list.display(head);
	}

}
