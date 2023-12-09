package trie.e_search_engine.b_search_autocomplete;

public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}
