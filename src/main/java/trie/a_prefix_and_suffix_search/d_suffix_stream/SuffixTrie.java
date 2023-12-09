package trie.a_prefix_and_suffix_search.d_suffix_stream;

public class SuffixTrie {
    TrieNode root = new TrieNode();

    void insert(String word, int index)
    {
        TrieNode curr = root;
        for (int i = word.length() - 1; i >= 0; i--)
        {
            int curInd = (int) word.charAt(i) - 'a';
            if (curr.children[curInd] == null)
            {
                curr.children[curInd] = new TrieNode();
            }

            curr = curr.children[curInd];
        }

        curr.isEndOfWord = true;
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
}
