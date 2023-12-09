package trie.e_search_engine.d_search_auto_complete_optimized;

import java.util.*;

public class Trie {
    TrieNode root = new TrieNode();

    // Inserts the string in trie
    void insert(String word)
    {
        // set current pointer to the root node
        TrieNode curr = root;
        for (char c: word.toCharArray())
        {
            int index = (int) c - 'a';
            //create a new node if not already exists
            if (curr.children[index] == null)
                curr.children[index] = new TrieNode();

            // move to the child node
            curr = curr.children[index];

            // add the word in current node's wordsPassingFromHere list
            curr.wordsPassingFromHere.add(word);

            // if after insertion, the set size exceeds 3
            // erase the last element of the set
            if (curr.wordsPassingFromHere.size() > 3)
                curr.wordsPassingFromHere.pollLast();
        }
    }

    List<String> getWordsStartingWith(String prefix)
    {
        // point the current node to the root
        TrieNode curr = root;

        // Move curr to the end of prefix in its trie representation
        for (char c: prefix.toCharArray())
        {
            int index = (int) c - 'a';
            // if the complete query word is not
            // found in trie, terminate the search
            // and return suggestions
            if (curr.children[index] == null)
                //retrieve the words to be returned from
                return new ArrayList < > (curr.wordsPassingFromHere);

            curr = curr.children[index];
        }

        //retrieve the words to be returned from
        return new ArrayList < > (curr.wordsPassingFromHere);
    }
}
