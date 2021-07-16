package com.trie;

public class TrieNode {
	TrieNode[] children;
	boolean isEndOfWord;
	static final int ALPHABET_SIZE = 26;
	public TrieNode() {
		this.children = new TrieNode[ALPHABET_SIZE];
		this.isEndOfWord = false;
	}
	
	public void markAsLeaf() {
		this.isEndOfWord = true;
	}
	
	public void unmarkAsLeaf() {
		this.isEndOfWord = false;
	}
}
