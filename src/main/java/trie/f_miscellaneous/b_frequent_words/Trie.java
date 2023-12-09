package trie.f_miscellaneous.b_frequent_words;

import java.util.List;

public class Trie {
    void addWord(TrieNode root, String word)
    {
        // point the current node
        // to the root
        TrieNode curr = root;

        // iterate through the letters of the word
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            int index = (int) ch - 'a';

            // create a new node for letter
            // if not already present

            if (curr.children[index] == null)
            {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        // store the complete word
        // in the last node
        curr.word = word;
    }

    void getWord(TrieNode curr, List<String> res, int k)
    {
        // if last node is reached
        // return the complete word

        if (curr == null)
            return;
        if (curr.word != null && res.size() < k)
        {
            res.add(curr.word);
        }

        // if top K words are already in result
        // return them

        if (res.size() == k)
            return;

        // traverse the trie in pre order
        // to get words in lexicographical order

        for (int i = 0; i < 26; i++)
        {
            if (curr.children[i] == null)
                continue;
            getWord(curr.children[i], res, k);
        }
    }
}
