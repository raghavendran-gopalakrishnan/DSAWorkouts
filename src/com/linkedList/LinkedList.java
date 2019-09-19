package com.linkedList;

public class LinkedList{
    ListNode head;
    public LinkedList(){
        length = 0;
    }
    private int length = 0;
    
    public ListNode getHead(){
        return head;
    }

    public void insertAtBegin(ListNode node){
        node.setNext(head);
        head = node;
        length++;
    }

    public void insertAtEnd(ListNode node){
        if(head == null)
            head = node;
        else{
            ListNode currNode = head;
            while(currNode.getNext()!= null) {
            	currNode = currNode.getNext();
            }
            currNode.setNext(node);
        }
        length++;
    }
    
    public void insertAtPosition(int position, int data) {
        if(position > length)
            position  = length;
        if(position < 0)
            position = 0;
    	if(head == null)
    		head = new ListNode(data);
    	else if(position == 0) {
    		ListNode node = new ListNode(data);
    		node.setNext(head);
    		head = node;
    		length++;
    	} else {
    		ListNode currNode = head;
    		for(int i=1;i<position;i++) {
    			currNode = currNode.getNext();
    		}
    		ListNode newNode = new ListNode(data);
    		newNode.setNext(currNode.getNext());
    		currNode.setNext(newNode);
        }
        length++;
    }

    public ListNode removeAtBegin(){
        ListNode node = head;
        if(node!=null){
            head = node.getNext();
            node.setNext(null);
        }
        length--;
        System.out.println("Removed "+node.getData());
        return node;
    }

    public ListNode removeAtEnd(){
        //if the list is empty
        if(head == null)
            return null;
        else{
            ListNode prev = head, temp = null, next = head.getNext();
            //if there is only 1 node in the list
            if(next == null){
                head = null;
                return prev;
            }
            //loop till the last node and store previous node for each nodes
            while((next = prev.getNext()) != null){
                temp = prev;
                prev = next;
            }
            //set N-1's nextNode as null
            temp.setNext(null);
            length--;
            return prev;
        }
    }

    public void removeNode(ListNode node){
        if(head == null)
            return;
        if(node.equals(head)){
            head = null;
            return;
        }
        ListNode p = head, q = null;
        while((q = p.getNext())!=null){
            if(q.equals(node)){
                p.setNext(q.getNext());
                length--;
                return;
            }
            p = q;
        }
    }

    public void removeAtPosition(int position){
        if(position > length)
            position  = length;
        if(position < 0)
            position = 0;
        if(head == null)
            return;
        
        if(position == 0)
            head = head.getNext();
        else{
            ListNode currNode = head;
    		for(int i=1;i<position;i++) {
    			currNode = currNode.getNext();
            }
            currNode.setNext(currNode.getNext().getNext());
        }
        length--;
    }

    public int getPosition(int data){
        int pos = 0;
        ListNode node = head;
        while(node != null){
            if(node.getData() == data)
                return pos;
            pos++;
            node = node.getNext();
        }
        return Integer.MIN_VALUE;
    }

    public void printList(){
        ListNode currNode = head;
        while(currNode!=null){
            System.out.print(currNode.getData()+" -->");
            currNode = currNode.getNext();
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main (String args[]){
        ListNode ln1 = new ListNode (10);
        ListNode ln2 = new ListNode (20);
        ListNode ln3 = new ListNode (30);
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(ln1);
        ll.insertAtEnd(ln2);
        ll.insertAtEnd(ln3);
        ll.insertAtBegin(new ListNode(100));
        ll.printList();
        ll.removeAtBegin();
        ll.printList();
        ll.removeAtEnd();
        ll.insertAtEnd(new ListNode(97));
        ll.insertAtEnd(new ListNode(98));
        ll.insertAtEnd(new ListNode(99));
        ll.printList();
        ll.removeAtPosition(3);
        System.out.println(ll.getPosition(20));
        ll.printList();
        
    }
 }
