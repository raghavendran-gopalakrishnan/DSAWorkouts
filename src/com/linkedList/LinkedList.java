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

    public void printList(ListNode headNode){
        ListNode currNode = headNode;
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
        ll.insertAtBegin(ln1);
        ll.insertAtBegin(ln2);
        ll.insertAtBegin(ln3);
        ll.printList(ln3);
        System.out.println(ll.getHead().getData());
    }
 }
