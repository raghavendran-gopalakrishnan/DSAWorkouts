package com.dsa.challenges.linkedList;

public class MergeSort {

	public static void main(String[] args) {
		int[] v1 = {29, 23, 82, 11, 4, 3, 21};
	    LinkedListNode listHead1 = LinkedList.createLinkedList(v1);
	  
	    System.out.print("Unsorted list: ");
	    LinkedList.display(listHead1);
	        
	    listHead1 = mergeSort(listHead1);
	    System.out.print("Sorted list: ");
	    LinkedList.display(listHead1);

	}
	
	public static LinkedListNode mergeSort(LinkedListNode head) {
	    if(head == null || head.next == null)
	    	return head;
	    Pair<LinkedListNode, LinkedListNode> pair = new Pair<LinkedListNode, LinkedListNode>(null, null);
	    splitInHalf(head,pair);
	    pair.first = mergeSort(pair.first);
	    pair.second = mergeSort(pair.second);
	    return MergeSortList.mergeSorted(pair.first,pair.second);
	  }


	private static void splitInHalf(LinkedListNode head, Pair<LinkedListNode,LinkedListNode> pair) {
		if(head == null) {
			return;
		}
		if(head.next == null) {
			pair.first = head;
			pair.second = null;
		} else {
			LinkedListNode slow = head;
			LinkedListNode fast = head.next;
			while(fast != null) {
				fast = fast.next;
				if(fast != null) {
					slow = slow.next;
					fast = fast.next;
				}
			}
			pair.first = head;
			pair.second = slow.next;
			slow.next = null;
		}
	}

}
