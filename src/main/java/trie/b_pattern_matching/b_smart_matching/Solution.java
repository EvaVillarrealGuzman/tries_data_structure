package trie.b_pattern_matching.b_smart_matching;

import java.util.ArrayList;
import java.util.List;

class Solution {

    final static char UNDERSCORE = '_';
    final static String UNDERSCORE_STRING = "_";

    public static void main(String[] args) {
        List<String> listWordsExample1 = List.of("apple", "cat");
        List<String> listQueriesExample1 = List.of("able", "bat", "cap");

        List<Boolean>  resultTest1 = matchWords(listWordsExample1, listQueriesExample1);
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

    public static List<Boolean> matchWords(List<String> words, List<String> queryWords)
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
                trie.insert(oneCharAwayString);
            }
        }

        List<Boolean> result = new ArrayList < > ();

        // Iterate through the query words
        for (String queryWord: queryWords)
        {
            boolean queryWordPresentInTrie = false;

            // find all one character away words for given query word
            // check if any of those exist in the trie
            List<String> oneCharAwayStrings = addSpecialCharAtAllIndexes(queryWord);
            for (String oneCharAwayString: oneCharAwayStrings)
            {
                queryWordPresentInTrie = trie.search(oneCharAwayString);
                if (queryWordPresentInTrie)
                {
                    break;
                }
            }

            result.add(queryWordPresentInTrie);
        }

        return result;
    }
}