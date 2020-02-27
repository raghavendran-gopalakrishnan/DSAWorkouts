package com.linkedList;

public class NthElementChallenge {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList(); //list is empty
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return null
        for(int i=0; i<15; i+=2){
            sll.insertAtHead(i);
        }
        sll.printList(); // List is 14 -> 12 -> 10 -> 8 -> 6 -> 4 -> 2 -> 0 -> null
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return 4
        System.out.println("10th element from end : " + nthElementFromEnd(sll, 10));//will return null

	}

	private static <T> Object nthElementFromEnd(SinglyLinkedList<T> sll, int i) {
		int size = sll.size;
		int position = size - i + 1;
		int count = 1;
		if(size == 0 || i > size) {
			return null;
		}
		SinglyLinkedList.Node current = sll.headNode;
		while(current != null) {
			if(count == position)
				return current.data;
			count++;
			current = current.nextNode;
		}
		return null;
	}

}
