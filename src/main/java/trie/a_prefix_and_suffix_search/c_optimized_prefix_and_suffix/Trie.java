package trie.a_prefix_and_suffix_search.c_optimized_prefix_and_suffix;

public class Trie {
    //create the root of the trie
    TrieNode root = new TrieNode();

    public void insert(String word, Integer idx)
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
            // set the value of endIdx as current idx
            curr.endIdx = idx;
        }
    }

    public int beginsWith(String word)
    {
        // set current pointer to the root node
        TrieNode curr = root;

        // iterate through all characters of the given word
        for (char c: word.toCharArray())
        {
            int index = (int) c - 'a';
            // if a character in the word is not found, return -1
            // System.out.println(c);
            if (curr.children[index] == null)
            {
                return -1;
            }

            curr = curr.children[index];
        }

        // return the index value
        // associated with the last node
        // in the path of query string
        return curr.endIdx;
    }
}
