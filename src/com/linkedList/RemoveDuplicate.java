package com.linkedList;

public class RemoveDuplicate {

	public static void main(String[] args) {
		 SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
	        list.insertAtEnd(1);
	        list.insertAtEnd(2);
	        
	        list.insertAtEnd(123);
	        list.insertAtEnd(2);
	        list.insertAtEnd(61);
	        list.insertAtEnd(60);
	        list.insertAtEnd(64);
	        list.printList();
	        removeDuplicates(list);
	        list.printList();

	}
	
	public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
		SinglyLinkedList.Node compare = null;
		SinglyLinkedList.Node current = list.headNode;
		while(current != null && current.nextNode != null) {
			compare = current;
			while(compare.nextNode != null) {
				if(compare.nextNode.data.equals(current.data))
					compare.nextNode = compare.nextNode.nextNode;
				else
					compare = compare.nextNode;
			}
			current = current.nextNode;
		}
	}

}
