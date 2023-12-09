package trie.e_search_engine.b_search_autocomplete;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    TrieNode root = new TrieNode();
    // Runs a DFS on trie starting with given prefix and adds all the words in the result, limiting result size to three

    void dfsWithPrefix(TrieNode curr, String word, List<String> result)
    {
        if (result.size() == 3)
            return;
        if (curr.isEndOfWord)
            result.add(word);

        // Run DFS on all possible paths
        for (char c = 'a'; c <= 'z'; c++)
        {
            int index = (int) c - 'a';
            if (curr.children[index] != null)
            {
                word += c;
                dfsWithPrefix(curr.children[index], word, result);
                word = word.substring(0, word.length() - 1);
            }
        }
    }

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
            curr = curr.children[index];
        }

        // Mark this node as a completed word
        curr.isEndOfWord = true;
    }

    List<String> getWordsStartingWith(String prefix)
    {
        // point the current node to the root
        TrieNode curr = root;

        List<String> result = new ArrayList< >();

        // Move curr to the end of prefix in its trie representation
        for (char c: prefix.toCharArray())
        {
            int index = (int) c - 'a';
            if (curr.children[index] == null)
                return result;
            curr = curr.children[index];
        }

        // use DFS for fetching words starting with prefix
        dfsWithPrefix(curr, prefix, result);
        return result;
    }
}
