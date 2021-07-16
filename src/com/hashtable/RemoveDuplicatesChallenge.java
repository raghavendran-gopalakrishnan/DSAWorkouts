package com.hashtable;

import java.util.HashSet;

import com.linkedList.SinglyLinkedList;

class RemoveDuplicatesChallenge {
    public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
        SinglyLinkedList<V>.Node currentNode = list.headNode;
        SinglyLinkedList<V>.Node prev = list.headNode;
        HashSet<V> visited = new HashSet<>();
        while(currentNode != null) {
        	if(visited.contains(currentNode.data)){
        		prev.nextNode = currentNode.nextNode;
        		currentNode = currentNode.nextNode;
        	} else {
        		visited.add(currentNode.data);
        		prev = currentNode;
        		currentNode = currentNode.nextNode;
        	}
        }
    }
    
    public static void main(String args[]) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); // created linked list

        for(int i = 1; i <= 8; i++) {
            list.insertAtHead(i);      // inserting data in list
        }
        //inserting duplicates
        list.insertAtHead(2);
        list.insertAtHead(4);
        list.insertAtHead(1);
        
        System.out.println("List before deleting duplicates from list :");
        list.printList();
        removeDuplicatesWithHashing(list); // calling removeDuplicatesWithHashing function
        System.out.println("List after deleting duplicates from list :");
        list.printList();
    }
}
