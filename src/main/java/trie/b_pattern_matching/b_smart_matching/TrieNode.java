package trie.b_pattern_matching.b_smart_matching;

public class TrieNode {
    // children array store pointer to TrieNode of next 26 alphabe
    TrieNode[] children = new TrieNode[27];
    // A flag used to identify the end of word nodes or leaf nodes
    boolean isEndOfWord;
}
