package com.trie;

import java.util.Arrays;

public class numOfWords {

	public static void main(String[] args) {
		 // Input keys (use only 'a' through 'z' and lower case)
	    String keys[] = {"the", "a", "there", "answer", "any",
	                     "by", "bye", "their","abc"};

	    System.out.println("Keys: "+ Arrays.toString(keys));

	    // Construct trie
	    Trie t = new Trie();

	    for (int i = 0; i < keys.length ; i++)
	    	t.insert(keys[i]);
	    System.out.println(totalWords(t.getRoot()));
	}

	private static int totalWords(TrieNode root) {
		int result = 0;
		if(root.isEndOfWord)
			result++;
		for(int i=0;i<root.children.length; i++) {
			if(root.children[i] != null)
				result += totalWords(root.children[i]);
		}
		
		return result;
	}

}
