package com.hashtable;

public class HashEntry {
	HashEntry next;
	String key;
	int value;
	
	public HashEntry(String key, int value) {
		this.key = key;
		this.value = value;
	}
}
