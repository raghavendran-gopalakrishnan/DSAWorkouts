package com.hashtable;

import java.util.HashSet;

import com.linkedList.SinglyLinkedList;

public class CheckUnionIntersection {

	public static void main(String[] args) {
		 SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
	        for(int i=7; i>3; i--){
	            list1.insertAtHead(i);
	        }
	        System.out.print("1st ");
	        list1.printList();
	        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
	        for(int i=0; i<5; i++){
	            list2.insertAtHead(i);
	        }
	        System.out.print("2nd ");
	        list2.printList();
	        System.out.print("After Intersection ");
	        intersectionWithHashing(list1, list2).printList();
	        System.out.print("After Union ");
	        unionWithHashing(list1, list2).printList();

	}

	//performs union of two lists
	public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
		SinglyLinkedList<T> result = new SinglyLinkedList<T>();
		SinglyLinkedList<T>.Node currentNode = list1.headNode;
		HashSet<T> hashSet = new HashSet<>();
		while(currentNode!=null) {
			if(!hashSet.contains(currentNode.data)) {
				result.insertAtEnd(currentNode.data);
				hashSet.add(currentNode.data);
			}
			currentNode = currentNode.nextNode;
		}
		
		currentNode = list2.headNode;
		while(currentNode != null) {
			if(!hashSet.contains(currentNode.data)) {
				result.insertAtEnd(currentNode.data);
				hashSet.add(currentNode.data);
			}
			currentNode = currentNode.nextNode;
		}
		
		return result;
	}

	//performs intersection between list
	public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
		SinglyLinkedList<T> result = new SinglyLinkedList<T>();
		SinglyLinkedList<T>.Node currentNode = list1.headNode;
		HashSet<T> hashSet = new HashSet<>();
		while(currentNode!=null) {
			if(!hashSet.contains(currentNode.data)) {
				hashSet.add(currentNode.data);
			}
			currentNode = currentNode.nextNode;
		}
		
		currentNode = list2.headNode;
		while(currentNode!=null) {
			if(hashSet.contains(currentNode.data)) {
				result.insertAtHead(currentNode.data);
				hashSet.remove(currentNode.data);
			}
			currentNode = currentNode.nextNode;
		}
		return result;
	}
}

