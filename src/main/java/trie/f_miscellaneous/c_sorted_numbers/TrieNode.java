package trie.f_miscellaneous.c_sorted_numbers;

public class TrieNode {
    // A flag used to identify the last nodes of number (leaf nodes)
    boolean isEndOfNum;
    // children array store pointer to TrieNode of next 10 integer (0 to 9)
    TrieNode[] children = new TrieNode[10];
}
