package trie.b_pattern_matching.a_pattern_matching;

public class TrieNode {
    // children array store pointer to TrieNode of next 26 alphabe
    TrieNode[] children = new TrieNode[52];
    // A flag used to identify the end of word nodes or leaf nodes
    boolean isEndOfPattern;
}
