package com.trie;

public class Trie {

	private TrieNode root;
	Trie (){
		System.out.println("Constructor Trie ");
		root = new TrieNode();
	}

	public static int getIndex(char c) {
		return c - 'a';
	}
	
	public TrieNode getRoot() {
		return root;
	}

	public void insert(String key) {
		if(key == null) {
			System.out.println("Cannot insert NULL");
			return;
		}
		System.out.println("Inserting the key :" + key);
		key = key.toLowerCase();
		TrieNode currentNode = root;
		int index = 0;
		for(int i=0; i<key.length(); i++) {
			index = getIndex(key.charAt(i));
			if(currentNode.children[index] == null) {
				currentNode.children[index] = new TrieNode();
			}
			currentNode = currentNode.children[index];

		}
		currentNode.markAsLeaf();
	}

	public boolean search(String key) {
		if(key == null) return false;
		key = key.toLowerCase();
		TrieNode currentNode = root;
		int index = 0;
		for(int i=0; i<key.length(); i++) {
			index = getIndex(key.charAt(i));
			if(currentNode.children[index] == null) {
				return false;
			}
			currentNode = currentNode.children[index];
		}
		if(currentNode.isEndOfWord)
			return true;

		return false;
	}

	public void delete(String key){
		if ((root == null) || (key == null)){
			System.out.println("Null key or Empty trie error");
			return;
		}
		deleteHelper(key.toLowerCase(), root, key.length(), 0);
	}

	private  boolean hasNoChildren(TrieNode node) {
		for(int i=0; i<node.children.length;i++) {
			if(node.children[i] != null) {
				return false;
			}
		}
		return true;
	}
	private boolean deleteHelper(String key, TrieNode currentNode, int length, int level) {
		boolean deletedSelf = false;
		if(currentNode == null) {
			return deletedSelf;
		}
		if(length == level) { //base case
			if(hasNoChildren(currentNode)) {
				currentNode = null;
				deletedSelf = true;
			} else {
				currentNode.unmarkAsLeaf();
				deletedSelf = false;
			}
		} else {
			TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
			boolean childDeleted = deleteHelper(key, childNode, length, level+1);
			if(childDeleted) {
				//mark the child null
				currentNode.children[getIndex(key.charAt(level))] = null;
				//Don't delete the node if its a end word or has any children
				if(currentNode.isEndOfWord)
					deletedSelf = false;
				else if(!hasNoChildren(currentNode)) {
					deletedSelf = false;
				} else { //else delete the node
					currentNode = null;
					deletedSelf = true;
				}

			} else {
				deletedSelf = false;
			}

		}
		return deletedSelf;
	}

	public void printTrie() {
		TrieNode currNode = root;
		for(int i=0; i<currNode.children.length; i++) {

		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("APPLE");
		trie.insert("APE");
		trie.insert("APP");
		System.out.println(trie.search("APP"));
		trie.delete("APP");
		System.out.println(trie.search("APP"));
	}

}
