package com.trie;

import java.util.Arrays;

public class DictWord {

	public static void main(String[] args) {
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "abc" };

		System.out.println("Keys: " + Arrays.toString(keys));

		System.out.println(isFormationPossible(keys,"theansweri"));
	}

	public static boolean isFormationPossible(String[] keys, String word) {
		if(keys.length < 2 || word.length() < 2)
			return false;
		// Construct trie
		Trie t = new Trie();
		for(int i=0;i<keys.length; i++) {
			t.insert(keys[i]);
		}
		
		for(int j=0; j<word.length(); j++) {
			String first = word.substring(0,j);
			String second = word.substring(j,word.length());
			if(t.search(first) && t.search(second)) {
				return true;
			}
		}
		return false;
	}

}
