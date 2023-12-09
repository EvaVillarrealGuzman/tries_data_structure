package trie.d_traversal.a_combined_words;

public class Trie {
    TrieNode root = new TrieNode();

    //insert a word into the trie
    void insert(String word)
    {
        // set the current trie pointer
        // to the root node
        TrieNode curr = root;
        for (char c: word.toCharArray())
        {
            // find the index of the character
            // in the trie node's children array
            int index = (int) c - 'a';

            // create a new trie node
            // if child is not found
            if (curr.children[index] == null)
                curr.children[index] = new TrieNode();

            // move to the child node
            curr = curr.children[index];
        }

        // set isEndOfWord for the last trie node
        // of the word
        curr.isEndOfWord = true;
    }
}
