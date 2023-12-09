package trie.e_search_engine.a_spelling_correction_based_search;

import java.util.ArrayList;
import java.util.List;

class Solution {

    final static char UNDERSCORE = '_';
    final static String UNDERSCORE_STRING = "_";

    public static void main(String[] args) {
        List<String> words = List.of("bit", "bat", "cat", "cut", "but","sip","sat");
        List<String> queryWord = List.of("sit", "mat", "mut");

        List< List<String>>  resultTest1 = queryMatchingWords(words, queryWord);
        System.out.println(resultTest1);
    }

    // replaces all indexes by special character "_"
    // one by one and push to a result vector
    static List<String> addSpecialCharAtAllIndexes(String word)
    {
        List<String> result = new ArrayList < > ();
        StringBuilder stringBuilder = new StringBuilder(word);
        int len = word.length();
        for (int index = 0; index < len; index++)
        {
            String temp = word.substring(index, index + 1);
            stringBuilder.replace(index, index + 1, UNDERSCORE_STRING);
            result.add(stringBuilder.toString());
            stringBuilder.replace(index, index + 1, temp);
        }

        return result;
    }

    public static List<List < String>> queryMatchingWords(List<String> words, List<String> queryWords)
    {
        // Initialize a trie
        Trie trie = new Trie();

        // Iterate through the words
        for (String word: words)
        {
            List<String> oneCharAwayStrings = addSpecialCharAtAllIndexes(word);

            //insert the words oneCharAwayStrings in trie
            for (String oneCharAwayString: oneCharAwayStrings)
            {
                trie.insert(oneCharAwayString, word);
            }
        }

        List<List < String>> result = new ArrayList < > ();

        // Iterate through the query words
        for (String queryWord: queryWords)
        {
            List<String> resultForWord = new ArrayList < > ();

            // find all one character away words for given query word
            // check if any of those exist in the trie
            List<String> oneCharAwayStrings = addSpecialCharAtAllIndexes(queryWord);
            for (String oneCharAwayString: oneCharAwayStrings)
            {
                List<String> queryWordPresentInTrie = trie.search(oneCharAwayString);
                for (String s: queryWordPresentInTrie)
                    resultForWord.add(s);
            }

            result.add(resultForWord);
        }

        return result;
    }
}