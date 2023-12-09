package trie.d_traversal.b_grid_search;

public class TrieNode {
    // children array store pointer to TrieNode of next 26 alphabe
    TrieNode[] children = new TrieNode[26];
    // a boolean flag to check if a node denotes
    // end of a word
    boolean isEndOfWord;
}
