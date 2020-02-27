package com.linkedList;

public class ReverseList {

	public static void main(String[] args) {
		 SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		 list.insertAtEnd(1);
	        list.insertAtEnd(2);
	        
	        list.insertAtEnd(123);
	        list.insertAtEnd(101);
	        list.insertAtEnd(61);
	        list.insertAtEnd(60);
	        list.insertAtEnd(64);
	        System.out.print("Before reverse: ");
	        list.printList();
	        System.out.print("After reverse: ");
	        reverseList(list);
	        list.printList();
	        

	}
	public static void reverseList(SinglyLinkedList<Integer> list) {
		SinglyLinkedList.Node previous = null;
		SinglyLinkedList.Node current = list.headNode;
		SinglyLinkedList.Node next = null;
		while(current != null) {
			next = current.nextNode;
			current.nextNode = previous;
			previous = current;
			current = next;
		}
		list.headNode = previous;
	}
}
