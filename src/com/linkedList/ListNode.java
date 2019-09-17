package com.linkedList;

public class ListNode{
    private int data;
    private ListNode next;
    public ListNode(int data){
        this.data = data;
    }
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
    public void setNext(ListNode next){
        this.next = next;
    }
    public ListNode getNext(){
        return next;
    }
    public static void main(String args[]) {
    	System.out.println("hi");
    }
    
}