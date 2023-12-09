package trie.a_prefix_and_suffix_search.b_prefix_and_suffix;

import java.util.ArrayList;
import java.util.List;

public class PrefixTrie {
    // Intialise the root of prefix trie
    TrieNode root = new TrieNode();

    void insert(String word, int index)
    {
        // point the current node as root
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++)
        {
            curr.indices.add(index);

            // add the index of the given word
            // to the indices array of current node
            int curInd = (int) word.charAt(i) - 'a';

            //create a new trie node
            // if child link is not found
            if (curr.children[curInd] == null)
            {
                curr.children[curInd] = new TrieNode();
            }

            curr = curr.children[curInd];
        }

        //set the value of isEndOfWord for last node
        // in the path
        curr.isEndOfWord = true;
        curr.indices.add(index);
    }

    List<Integer> search(String word)
    {
        // point the current node as root
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++)
        {
            // if child link is not found
            // it means prefix does not exists
            // return empty indices array
            int index = (int) word.charAt(i) - 'a';
            if (curr.children[index] == null)
            {
                return new ArrayList< >();
            }

            curr = curr.children[index];
        }

        // if prefix is found completely
        // return indices associated with
        // last node in the path
        return curr.indices;
    }
}
