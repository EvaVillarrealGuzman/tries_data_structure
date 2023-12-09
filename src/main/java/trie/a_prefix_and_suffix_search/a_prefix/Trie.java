package trie.a_prefix_and_suffix_search.a_prefix;

public class Trie {
    //create the root of the trie
    TrieNode root = new TrieNode();

    public void insert(String word)
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

        // for the last node mark isEndOfWord as true
        curr.isEndOfWord = true;
    }

    public boolean search(String word)
    {
        // set current pointer to the root node
        TrieNode cur = root;

        // iterate through all characters of the given word
        for (char c: word.toCharArray())
        {
            int index = (int) c - 'a';
            // if a character in the word is not found, return false
            if (cur.children[index] == null)
            {
                return false;
            }

            cur = cur.children[index];
        }

        // return the value of isEndOfWord for the last character of the word being searched
        // if isEndOfWord is true, it means word was found completely
        // else false if returned
        return cur.isEndOfWord;
    }

    public boolean beginsWith(String prefix)
    {
        // set current pointer to the root node
        TrieNode curr = root;

        // iterate through all characters of the given prefix word
        for (char c: prefix.toCharArray())
        {
            int index = (int) c - 'a';
            // if a character in the word is not found, return false
            if (curr.children[index] == null)
            {
                return false;
            }

            curr = curr.children[index];
        }

        // since all the characters of the prefix were found
        // and our code reached the last alphabet of the prefix
        // it means prefix was found, so true is returned
        return true;
    }

    public int wordsWithPrefix(String prefix, String suffix)
    {
        // set current pointer to the root node
        TrieNode cur = root;
        int indexResult = -1;

        // iterate through all characters of the given word
        for (char c: prefix.toCharArray())
        {
            int index = (int) c - 'a';
            // if a character in the word is not found, return false
            if (cur.children[index] != null)
            {
                cur = cur.children[index];
                indexResult = index;
            }
        }

        int lastIndex = -1;
        for(TrieNode node : cur.children[indexResult].children  ){

        }

        // return the value of isEndOfWord for the last character of the word being searched
        // if isEndOfWord is true, it means word was found completely
        // else false if returned
        return lastIndex;
    }
}
