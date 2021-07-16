package com.dsa.challenges.linkedList;

import java.util.ArrayList;
import java.util.Random;

public class LinkedList {

	public static LinkedListNode insertAtHead(LinkedListNode head, int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		newNode.next = head;
		return newNode;
	}

	public static LinkedListNode insertAtTail(LinkedListNode head, int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		if(head == null)
			return newNode;

		LinkedListNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		return head;
	}

	public static LinkedListNode createLinkedList(ArrayList<Integer> list) {
		LinkedListNode head = null;
		LinkedListNode tail = null;
		for(Integer i : list) {
			LinkedListNode newNode = new LinkedListNode(i);
			if(head == null) {
				head = newNode;
			} else {
				tail.next = newNode;
			}
			tail = newNode;
		}
		return head;
	}
	
	public static LinkedListNode createLinkedList(int[] array) {
		LinkedListNode head = null;
		LinkedListNode tail = null;
		for(int i: array) {
			LinkedListNode newNode = new LinkedListNode(i);
			if(head == null) {
				head = newNode;
			} else {
				tail.next = newNode;
			}
			tail = newNode;
		}
		return head;
	}

	 public static LinkedListNode createRandomList(int length) {
	        LinkedListNode listHead = null;
	        Random generator = new Random();
	        for(int i = 0; i < length; ++i) {
	            listHead = insertAtHead(listHead, generator.nextInt(100));
	        }
	        return listHead;
	    }

	    public static void display(LinkedListNode head) {
	        LinkedListNode temp = head;
	        while (temp != null) {
	            System.out.printf("%d", temp.data);
	            temp = temp.next;
	            if (temp != null) {
	              System.out.printf(", ");
	            }
	        }
	        System.out.println();
	    }  
		public static void main(String[] args) {
			LinkedList list = new LinkedList();
			LinkedListNode head = list.createRandomList(10);
			list.display(head);

		}
	}

	class Pair<X, Y> {
	    public X first;
	    public Y second;
	    public Pair(X first, Y second) {
	    this.first = first;
	    this.second = second;
	  }
	    


}
