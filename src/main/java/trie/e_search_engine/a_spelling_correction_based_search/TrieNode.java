package trie.e_search_engine.a_spelling_correction_based_search;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    // children array store pointer to TrieNode of next 26 alphabe
    TrieNode[] children = new TrieNode[27];
    // A flag used to identify the end of word nodes or leaf nodes
    boolean isEndOfWord;
    // a list to store the complete word
    // at the last node of each path
    // this helps in easy retrieval of words
    List<String> words = new ArrayList< >();
}
