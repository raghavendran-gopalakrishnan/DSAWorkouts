package com.dsa.challenges.linkedList;

public class InsertionSort {

	public static LinkedListNode insertionSort(LinkedListNode head) {
		if(head == null)
			return head;
		LinkedListNode sorted = null;
		LinkedListNode unsorted = head;
		while(unsorted != null) {
			//LinkedListNode node = unsorted;
			if(sorted == null)
				LinkedList.insertAtHead(sorted, unsorted.data);
			else {
				while(sorted != null) {
					if(sorted.data <= unsorted.data) {
						sorted.next = unsorted;
						sorted = sorted.next;
					} else {
						unsorted.next = sorted;
						sorted = unsorted;
						//unsorted = unsorted.next;
					}
				}
			}
			unsorted = unsorted.next;
				
		}
		return sorted;
	}

	public static void main(String[] args) {
		int[] arr = {6,4,7,5,9};
		LinkedListNode list = LinkedList.createLinkedList(arr);
		LinkedList.display(list);
		list = insertionSort(list);
		LinkedList.display(list);

	}

}
