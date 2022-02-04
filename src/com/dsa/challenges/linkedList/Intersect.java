package com.dsa.challenges.linkedList;

public class Intersect {

	public static void main(String[] args) {
	    int [] a1 = {13,4};
	    int [] a2 = {29, 23, 82, 11};
	    LinkedListNode list_head_1 = LinkedList.createLinkedList(a1);
	    LinkedListNode list_head_2 = LinkedList.createLinkedList(a2);
	    LinkedListNode node1 = new LinkedListNode(12);
	    LinkedListNode node2 = new LinkedListNode(27);

	    LinkedList.insertAtTail(list_head_1, node1);
	    LinkedList.insertAtTail(list_head_1, node2);
	    
	    LinkedList.insertAtTail(list_head_2, node1);
	    
	    System.out.print("List 1: ");
	    LinkedList.display(list_head_1);
	    System.out.print("List 2: ");
	    LinkedList.display(list_head_2);

	    LinkedListNode intersect_node = intersect(list_head_1, list_head_2);
	    System.out.println(String.format("Intersect at %d", intersect_node.data));  
	  }
	public static LinkedListNode intersect(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode listNode1 = null;
		LinkedListNode listNode2 = null;
		int listLength1 = getLength(head1);
		int listLength2 = getLength(head2);
		int lengthDifference = 0;
		if(listLength1 >= listLength2) {
			lengthDifference = listLength1 - listLength2;
			listNode1 = head1;
			listNode2 = head2;
		} else {
			lengthDifference = listLength2 - listLength1;
			listNode1 = head2;
			listNode2 = head1;
		}
		
		while(lengthDifference > 0) {
			listNode1 = listNode1.next;
			lengthDifference--;
		}
		
		while(listNode1 != null) {
			if(listNode1 == listNode2)
				return listNode1;
			listNode1 = listNode1.next;
			listNode2 = listNode2.next;
		}
		return null;
	} 
	
	public static int getLength(LinkedListNode head) {
		int length = 0;
		while(head != null) {
			length ++;
			head = head.next;
		}
		return length;
	}
	
}
