package com.doublyLinkedList;
public class DLLNode{
    private int data;
    private DLLNode prev;
    private DLLNode next;
    public DLLNode(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
    public DLLNode(int data, DLLNode prev, DLLNode next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return this.data;
    }
    public void setPrev(DLLNode where){
        this.prev = where;
    }
    public void setNext(DLLNode where){
        this.next = where;
    }
    public DLLNode getPrev(){
        return this.prev;
    }
    public DLLNode getNext(){
        return this.next;
    }
}