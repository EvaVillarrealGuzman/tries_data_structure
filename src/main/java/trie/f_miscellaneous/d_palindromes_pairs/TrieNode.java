package trie.f_miscellaneous.d_palindromes_pairs;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    // an integer which stores the index of
    // thw word ending at current index
    int indexOfWordEndingHere = -1;

    // children array store pointer to TrieNode of next 26 alphabets
    TrieNode[] children = new TrieNode[26];;

    // holds the indexes of all the words, whose later part of form a palindrome.
    List<Integer> palindromePrefixRemaining = new ArrayList<Integer>();
}
