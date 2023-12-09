package trie.f_miscellaneous.b_frequent_words;

public class TrieNode {
    // children array store pointer to TrieNode of next 26 alphabe
    TrieNode[] children = new TrieNode[26];
    // A parameter to store the complete word in the last node
    String word;
}
