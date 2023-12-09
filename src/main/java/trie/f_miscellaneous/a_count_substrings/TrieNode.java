package trie.f_miscellaneous.a_count_substrings;

public class TrieNode {
    // children array store pointer to TrieNode of next 26 alphabe
    TrieNode[] children = new TrieNode[26];
    // A flag used to identify the end of word nodes or leaf nodes
    boolean isEndOfWord;
}
