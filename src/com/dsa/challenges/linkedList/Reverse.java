package com.dsa.challenges.linkedList;

public class Reverse {

	public static LinkedListNode reverse(LinkedListNode head) {
	    if (head == null || head.next == null) {
	        return head;
	    }
		LinkedListNode reversedList = head;
		LinkedListNode toDo = head.next;
		reversedList.next = null;
		while(toDo != null) {
			LinkedListNode node = toDo;
			toDo = toDo.next;
			node.next = reversedList;
			reversedList = node;
		}
		return reversedList;
	}

	public static LinkedListNode reverseRec(LinkedListNode head) {
		if (head == null || head.next == null) {
	        return head;
	    }
		
		LinkedListNode reverseNode = reverseRec(head.next);
		head.next.next = head;
		head.next = null;
		return reverseNode;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = null;
		head = LinkedList.createRandomList(10);
		LinkedList.display(head);
	    head = reverseRec(head);
	    LinkedList.display(head);
	}

}
