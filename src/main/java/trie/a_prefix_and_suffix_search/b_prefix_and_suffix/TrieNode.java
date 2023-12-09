package trie.a_prefix_and_suffix_search.b_prefix_and_suffix;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    // children array store pointer to TrieNode of next 26 alphabe
    TrieNode[] children = new TrieNode[26];
    // A flag used to identify the end of word nodes or leaf nodes
    boolean isEndOfWord;
    // A list to store the indices of the words
    // passing through the trie node
    List<Integer> indices = new ArrayList< >();
}
