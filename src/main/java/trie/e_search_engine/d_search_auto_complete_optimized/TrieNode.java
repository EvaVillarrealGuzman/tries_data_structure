package trie.e_search_engine.d_search_auto_complete_optimized;

import java.util.TreeSet;

public class TrieNode {
    // children array store pointer to TrieNode of next 26 alphabets
    TrieNode[] children = new TrieNode[26];
    // a treeset to store all the words passing through this trie node
    TreeSet<String> wordsPassingFromHere = new TreeSet<String> ();   	// children array store pointer to TrieNode of next 26 alphabets
}
