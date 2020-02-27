package com.linkedList;

public class CheckUnionIntersection {
    //performs union of two lists
    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        if(list1.isEmpty())
        	return list2;
        if(list2.isEmpty())
        	return list1;
        
        SinglyLinkedList<T>.Node current = list1.headNode;
        while(current.nextNode != null) {
        	current = current.nextNode;
        }
        
        current.nextNode =  list2.headNode ;
        list1.removeDuplicatesWithHashing();
        return list1;
    }
    
    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
       
        if(list1.isEmpty())
        	return list2;
        if(list2.isEmpty())
        	return list1;
        SinglyLinkedList<T>.Node current = list1.headNode;
        while(current.nextNode != null) {
        	if(contains(list2,current.data))
        		result.insertAtHead(current.data);
        	current = current.nextNode;
        }
        return result;
    }
    
    public static <T> boolean contains(SinglyLinkedList<T> list, T data) {
    	SinglyLinkedList.Node current = list.headNode;
    	while(current.nextNode != null) {
    		if(current.data.equals(data))
    			return true;
    		current = current.nextNode;
    	}
    	return false;
    }
    
    public static void main( String args[] ) {
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
		
		 System.out.print("After Intersection "); intersection(list1,
		 list2).printList();
		 
        System.out.print("After Union ");
        union(list1, list2).printList();
    }
}
