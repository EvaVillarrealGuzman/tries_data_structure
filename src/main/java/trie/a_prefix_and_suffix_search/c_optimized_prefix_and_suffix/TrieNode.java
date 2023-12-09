package trie.a_prefix_and_suffix_search.c_optimized_prefix_and_suffix;

public class TrieNode {
    // children array store pointer to TrieNode of next 26 alphabe
    TrieNode[] children = new TrieNode[27];
    // A flag used to identify the end of word nodes or leaf nodes
    int endIdx;
}
