package trie.d_traversal.b_grid_search;

public class Trie {
    TrieNode root = new TrieNode();

    // function to insert a word into the trie
    void insert(String word)
    {
        // point the current node to the root of trie
        TrieNode curr = root;

        // iterate through the letters of the word
        for (char c: word.toCharArray())
        {
            int index = (int) c - 'a';
            // if the child node, does not exist, create one
            if (curr.children[index] == null)
                curr.children[index] = new TrieNode();

            // move to child node
            curr = curr.children[index];
        }
        // mark isEndOfWord as true for last node of the word
        curr.isEndOfWord = true;
    }
}
