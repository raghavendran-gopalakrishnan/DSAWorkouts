package com.dsa.challenges.linkedList;

import java.util.HashSet;

public class RemoveDuplicate {

	public static LinkedListNode removeDuplicates(LinkedListNode head) {
		if(head == null)
			return head;
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(head.data);
		LinkedListNode prev = head;
		LinkedListNode node = head.next;
		while(node != null) {
			if(set.contains(node.data)) {
				prev.next = node.next;
				node = node.next;
			} else {
				set.add(node.data);
				prev = node;
				node = node.next;
			}
		}
		return head;
	}

	
	public static void main(String[] args) {
		int[] arr = {3,4,5,4,6,7,5,9};
		LinkedListNode list = LinkedList.createLinkedList(arr);
		LinkedList.display(list);
		list = removeDuplicates(list);
		LinkedList.display(list);
	}

}
