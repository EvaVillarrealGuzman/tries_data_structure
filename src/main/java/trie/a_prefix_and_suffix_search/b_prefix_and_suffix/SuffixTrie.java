package trie.a_prefix_and_suffix_search.b_prefix_and_suffix;

import java.util.ArrayList;
import java.util.List;

public class SuffixTrie {
    TrieNode root = new TrieNode();

    void insert(String word, int index)
    {
        TrieNode curr = root;
        for (int i = word.length() - 1; i >= 0; i--)
        {
            curr.indices.add(index);
            int curInd = (int) word.charAt(i) - 'a';
            if (curr.children[curInd] == null)
            {
                curr.children[curInd] = new TrieNode();
            }

            curr = curr.children[curInd];
        }

        curr.indices.add(index);
        curr.isEndOfWord = true;
    }

    List<Integer> search(String word)
    {
        TrieNode curr = root;
        for (int i = word.length() - 1; i >= 0; i--)
        {
            int index = (int) word.charAt(i) - 'a';
            if (curr.children[index] == null)
            {
                return new ArrayList< >();
            }

            curr = curr.children[index];
        }

        return curr.indices;
    }
}
