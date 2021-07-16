package com.dsa.challenges.linkedList;

public class DeleteNode {

	public static LinkedListNode deleteNode(LinkedListNode head, int key) 
	{
		if(head == null)
			return head;
		if(head.data == key) {
			head = head.next;
			//return head;
		}
		LinkedListNode prev = head;
		LinkedListNode node = head.next;
		while(node != null) {
			if(node.data == key) {
				prev.next = node.next;
				node = node.next;
			} else {
				prev = node;
				node = node.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		int[] arr = {4,5,4,6,7,5,9};
		LinkedListNode list = LinkedList.createLinkedList(arr);
		LinkedList.display(list);
		list = deleteNode(list,4);
		LinkedList.display(list);
	}

}
