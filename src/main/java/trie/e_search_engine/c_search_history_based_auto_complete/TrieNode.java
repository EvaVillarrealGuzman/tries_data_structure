package trie.e_search_engine.c_search_history_based_auto_complete;

import java.util.HashMap;

public class TrieNode {
    // key is the char and value is the trie node
    HashMap<Character, TrieNode> children = new HashMap < > ();
    // key is the complete word and it's count is the value
    HashMap<String, Integer> counter = new HashMap < > ();
}
