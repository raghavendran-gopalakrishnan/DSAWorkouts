package com.dsa.challenges.linkedList;

public class SwapNth {

	static LinkedListNode swapNthNode(LinkedListNode head, int n) {
		/*

"""
                                                                                                                              
                           | head                                                                                             
                           |                                                                                                  
                           |                                                                                                  
                           |                                                                                                  
                           v                                                                                                  
                      +------------+       +------------+       +------------+         +------------+           +------------+
                      |            |       |            |       |            |         |            |           |            |
             Curr---->|    10      |+-----+|    8       |+----++|      9     |+-------+|     3      |-----------|   null     |
                      |            |       |            |       |            |         |            |           |            |
                      +------------+       +------------+       +------------+         +------------+           +------------+
                                                                                                                       
                                                                  -                                                           
                      +------------+                                                                                          
                      |            |                                                                                          
             Prev---> |   null     |                                                                                          
                      |            |                                                                                          
                      +------------+                                                                                          				
				"""		*/
		LinkedListNode curr = head;
		LinkedListNode prev = null;
		if(head == null)
			return null;
		if(n == 1)
			return head;
		for(int count = 1; count < n && curr != null ; count++) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = head;
		LinkedListNode temp = head.next;
		head.next = curr.next;
		curr.next = temp;
		return curr;
	}
	
	public static void main(String[] args) {
		LinkedListNode listHead = null;
	    int[] arr = new int[] {7, 14, 21, 28, 35, 42};
	    listHead = LinkedList.createLinkedList(arr);
	  
	    System.out.print("Original list: ");
	    LinkedList.display(listHead);

	    listHead = swapNthNode(listHead, 4);
	    System.out.print("Swapping 4th node with head: ");
	    LinkedList.display(listHead);
	    System.out.println(System.currentTimeMillis());
	}

}
