package com.linkedList;

public class LinkedList{
    ListNode head;
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
        System.out.println(ll.getHead().getData());
    }
 }
