package trie.f_miscellaneous.a_count_substrings;

public class Trie {
    TrieNode root = new TrieNode();

    // insert a string into a trie
    // and check if it is already present
    // function returns 0 if string is not unique
    // otherwise it returns 1
    int insertAndCount(String str, int start, int end)
    {
        //point the current to the root
        TrieNode curr = root;

        // iterate from the start to the end index
        for (int i = start; i < end; i++)
        {
            char ch = str.charAt(i);
            int index = (int) ch - 'a';

            //create a new trie node
            // if not already present
            // else move to the child node
            if (curr.children[index] == null)
            {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        // if the word has not been inserted before
        // then it is a new unique substring
        int uniqueInsertion = 0;
        if (curr.isEndOfWord == false)
            uniqueInsertion = 1;

        //mark the end of word true for the last node
        curr.isEndOfWord = true;
        return uniqueInsertion;
    }
}
