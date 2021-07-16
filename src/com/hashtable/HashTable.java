package com.hashtable;

import java.util.ArrayList;

public class HashTable {
	private ArrayList<HashEntry> bucket;
	private int slots;
	private int size;
	
	public HashTable() {
		bucket = new ArrayList<HashEntry>(slots);
		slots = 10;
		size = 0;
		for(int i=0; i<slots; i++)
			bucket.add(null);
	}
	
	public void insert(String key, int value) {
		//get head of the chain
		int b_index = getIndex(key);
		HashEntry head = bucket.get(b_index);
		
		//Check if key exists already
		while(head != null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		//Insert key in the chain
		++size;
		head = bucket.get(b_index);
		HashEntry newSlot = new HashEntry(key, value);
		newSlot.next = head;
		bucket.add(b_index, newSlot);
		
		//If 60% of the bucket is used, double the bucket size
		if((0.1*size)/slots > 0.6) {
			ArrayList<HashEntry> temp = bucket;
			bucket = new ArrayList<HashEntry>();
			slots = slots*2;
			size = 0;
			for(int i=0; i<slots;i++)
				bucket.add(null);
			
			for(HashEntry head_node : temp) {
				while(head_node != null) {
					insert(head_node.key, head_node.value);
					head_node = head_node.next;
				}
			}
		}
	}
	
	public int getValue(String key) {
		int b_index = getIndex(key);
		HashEntry head = bucket.get(b_index);
		while(head != null) {
			if(head.key.equals(key))
				return head.value;
			head = head.next;
		}
		return 0;
	}
	
	public int delete(String key) {
		int b_index = getIndex(key);
		HashEntry head = bucket.get(b_index);
		HashEntry prev = null;
		while(head != null) {
			if(head.key.equals(key)) 
				break;
			prev = head;
			head = head.next;
		}
		if(head == null)
			return 0;
		
		size--;
		if(prev != null)
			prev.next = head.next;
		else
			bucket.set(b_index, head.next);
		
		return head.value;
	}
	
	private int getIndex(String key) {
		int hashCode = key.hashCode();
		int index = hashCode % slots;
		
		if(index < 0)
			index = (index + slots) % slots;
		
		return index;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0 ;
	}
}
