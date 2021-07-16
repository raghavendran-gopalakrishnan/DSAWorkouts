package com.trie;

import java.util.ArrayList;
import java.util.Arrays;

public class TrieWord {

	public static void main(String[] args) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "abc" };

		System.out.println("Keys: " + Arrays.toString(keys));

		// Construct trie
		Trie t = new Trie();

		for (int i = 0; i < keys.length; i++)
			t.insert(keys[i]);
	
		  ArrayList<String> result = findWords(t.getRoot()); for(String r:result) {
		  System.out.println(r); }
		 

	}

	// Recursive Function to generate all words
	public static void getWords(TrieNode root, ArrayList<String> result, int level, char[] str) {
		if (root.isEndOfWord) {
			String temp = "";
			for (int x = 0; x < level; x++) {
				temp += Character.toString(str[x]);
			}
			result.add(temp);
		}
		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				str[level] = (char) (i + 'a');
				getWords(root.children[i], result, level + 1, str);
			}
		}

	}

	public static ArrayList<String> findWords(TrieNode root) {
		ArrayList<String> result = new ArrayList<String>();
		char[] str = new char[20];
		getWords(root, result, 0, str);
		return result;
	}
	
	

}
