package com.linkedList;

class ListDemo {
    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        for (int i = 1; i <= 6; i++) {
		    sll.insertAtEnd(i); // inserting value at the tail of the list
    }
    sll.printList();

    System.out.println ("\nInserting 8 after 2");
    sll.insertAfter(8, 2);
    sll.printList();   // calling insert after
    System.out.println ("\nInserting 10 after 3");
    sll.insertAfter (10, 3);   // calling insert after
    sll.printList();
    System.out.println(sll.searchNode(13));
    sll.deleteAtHead();
    sll.printList();
    sll.deleteByValue(10);
    sll.deleteByValue(8);
    sll.printList();
    }
}