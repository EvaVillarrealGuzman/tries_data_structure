package trie.e_search_engine.d_search_auto_complete_optimized;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<String> words = List.of("honey", "hammer", "hostile", "hotel", "hill", "hotdog", "hotter");
        String queryWord = "hot";

        List< List<String>>  resultTest1 = autoSuggest(words, queryWord);
        System.out.println(resultTest1);
    }

    static List<List < String>> autoSuggest(List<String> words, String searchWord)
    {
        // initialize a trie
        Trie trie = new Trie();

        // initialize a result vector
        List<List < String>> result = new ArrayList < > ();

        // insert all words into trie
        for (String w: words)
            trie.insert(w);

        String prefix = "";

        // iterate through word's characters
        for (char c: searchWord.toCharArray())
        {
            // keep appending letters to the prefix
            prefix += c;
            // fetch words starting with the current prefix
            result.add(trie.getWordsStartingWith(prefix));
        }

        return result;
    }
}