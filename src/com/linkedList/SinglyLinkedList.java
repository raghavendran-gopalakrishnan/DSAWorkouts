package com.linkedList;

import java.util.HashSet;

public class SinglyLinkedList<T> {
    //Node inner class for SLL
    public class Node {
        public T data;
        public Node nextNode;

    }

    public Node headNode; //head node of the linked list
    public int size;      //size of the linked list

    //Constructor - initializes headNode and size
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    //Helper Function that checks if List is empty or not 
    public boolean isEmpty() {
        if (headNode == null) return true;
        return false;
    }

    //Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        //Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }
    
    //Inserts new data at the end of the linked list
    public void insertAtEnd(T data) {
    	if(isEmpty()) {
    		insertAtHead(data);
    		return;
    	}
    	Node newNode = new Node();
    	newNode.data = data;
    	newNode.nextNode = null;
    	
    	Node last = headNode;
    	while(last.nextNode!=null) {
    		last = last.nextNode;
    	}
    	last.nextNode = newNode;
    	size++;
    }
    
    //Inserts new data after the specified location
    public void insertAfter(T data, T previous) {
    	Node newNode = new Node();
    	newNode.data = data;
    	
    	Node currentNode = headNode;
    	while(currentNode != null && currentNode.data != previous) {
    		currentNode = currentNode.nextNode;
    	}
    	if(currentNode!=null) {
    		newNode.nextNode = currentNode.nextNode;
    		currentNode.nextNode = newNode;
    		size++;
    	}
    }
    
    //Searches for the node with the passed data
    public boolean searchNode(T data) {
    	if(!isEmpty()) {
    		Node currentNode = headNode;
    		while(currentNode != null) {
    			if(currentNode.data == data)
    				return true;
    			currentNode = currentNode.nextNode;
    		}
    	}
    	return false;
    }
    
    //Delete value from the head
    public void deleteAtHead() {
    	if(isEmpty()) 
    		return;
    	headNode = headNode.nextNode;
    	size--;
    }
    
    //Delete node by value
    public void deleteByValue(T data) {
    	if(isEmpty()) 
    		return;
    	if(headNode.data == data) {
    		deleteAtHead();
    		return;
    	}
    	Node prevNode = headNode;
    	Node currentNode = headNode.nextNode;
    	while(currentNode != null && currentNode.data != data) {
    		prevNode = currentNode;
    		currentNode = currentNode.nextNode;
    	}
    	prevNode.nextNode = currentNode.nextNode;
    	size--;    	
    }
    
    // Helper Function to printList
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }
    
    public void removeDuplicatesWithHashing() {
    	Node current = this.headNode;
    	Node previous = this.headNode;
    	HashSet visited = new HashSet();
    	
    	if(!isEmpty() && current.nextNode != null) {
    		while(current != null) {
    			if(visited.contains(current.data)) {
    				previous.nextNode = current.nextNode;
    				current = current.nextNode;	
    				size--;
    			} else {
    				visited.add(current.data);
    				previous = current;
    				current = current.nextNode;
    			}
    		}
    	}
    }

}
