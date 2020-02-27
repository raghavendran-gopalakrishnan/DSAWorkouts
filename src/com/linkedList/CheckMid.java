package com.linkedList;

public class CheckMid {

	public static void main(String[] args) {
		 SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
	        list.insertAtEnd(1);
	        list.insertAtEnd(2);
	        
	        list.insertAtEnd(123);
	        list.insertAtEnd(101);
	        list.insertAtEnd(61);
	        list.insertAtEnd(60);
	        list.insertAtEnd(64);
	        list.printList();
	        System.out.println("Middle element is : " + findMiddle(list));

	}


	private static <T> Object findMiddle(SinglyLinkedList<T> list) {
		SinglyLinkedList.Node current = list.headNode;
		SinglyLinkedList.Node mid = list.headNode;
		while(current != null && mid != null && current.nextNode != null) {
			current = current.nextNode.nextNode;
			if(current != null) {
				mid = mid.nextNode;
			}
		}
		return mid.data;
	}

}
