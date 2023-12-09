package trie.b_pattern_matching.b_smart_matching;

public class Trie {
    TrieNode root = new TrieNode();

    // insert a word into trie
    void insert(String word)
    {
        // point the current node to the root
        TrieNode curr = root;
        for (char c: word.toCharArray())
        {
            int index = 26;
            if (c != '_')
            {
                index = (int) c - 'a';
            }

            //create a new trie node
            // if not already existing in trie
            if (curr.children[index] == null)
                curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }

        //mark isEndOfWord as true for the last node
        curr.isEndOfWord = true;
    }

    // search a word into trie
    boolean search(String word)
    {
        // point the current node to the root
        TrieNode curr = root;

        // iterate through all characters of the given word
        for (char c: word.toCharArray())
        {
            int index = 26;
            if (c != '_')
            {
                index = (int) c - 'a';
            }

            // if a character in the word is not found, return false
            if (curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }

        // return the value of isEndOfWord for the last character of the word being searched
        // if isEndOfWord is true, it means word was found completely
        // else false if returned
        return curr.isEndOfWord;
    }
}
