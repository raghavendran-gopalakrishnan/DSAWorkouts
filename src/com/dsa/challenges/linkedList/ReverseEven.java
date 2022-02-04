package com.dsa.challenges.linkedList;

public class ReverseEven {


	public static LinkedListNode reverseEvenNodes(LinkedListNode head) {
	    // Let's extract even nodes from the existing
	    // list and create a new list consisting of 
	    // even nodes. We will push the even nodes at
	    // head since we want them to be in reverse order.
		LinkedListNode curr = head;
		LinkedListNode listEven = null;
		
		while(curr != null && curr.next != null){
			LinkedListNode even = curr.next;
			curr.next = even.next;
			
			even.next = listEven;
			listEven = even;
			curr = curr.next;
		}
		
		return mergeAlternating(head, listEven);
	}

	private static LinkedListNode mergeAlternating(LinkedListNode list1, LinkedListNode list2) {
		if(list1 == null)
			return list2;
		if(list2 == null)
			return list1;
		
		LinkedListNode head = list1;
		while(list1.next != null && list2 != null) {
			LinkedListNode temp = list2;
			list2 = list2.next;
			
			temp.next = list1.next;
			list1.next = temp;
			list1 = temp.next;
		}
		if(list1.next == null)
			list1.next = list2;
		
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int[] arr = {7, 14, 21, 28, 9};
		    LinkedListNode listHead = LinkedList.createLinkedList(arr);
		    System.out.print("Original list: ");
		    LinkedList.display(listHead);

		    listHead = reverseEvenNodes(listHead);
		    System.out.print("After Reverse: ");
		    LinkedList.display(listHead);

	}

}
