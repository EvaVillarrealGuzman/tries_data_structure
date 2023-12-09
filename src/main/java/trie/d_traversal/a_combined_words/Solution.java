package trie.d_traversal.a_combined_words;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        List<String> listWordsExample1 = List.of("cat", "fat", "sat", "mat", "on", "catsatonmat", "fatcatsat");

        List<String>  resultTest1 = findCombinedWords(listWordsExample1);
        System.out.println(resultTest1);
    }

    public static boolean isCombinedWord(Trie trie, String word, int index, int combinedWordCount)
    {
        // if last index of word is reached
        // return true if count of smaller words
        // is greater than two
        if (index == word.length())
            return combinedWordCount > 1;

        TrieNode root = trie.root;

        // Iterate through the characters of the word
        for (int wordIndex = index; wordIndex < word.length(); wordIndex++)
        {
            int trieIndex = (int) word.charAt(wordIndex) - 'a';

            // if node not found return false
            // else move to the next node
            if (root.children[trieIndex] == null)
            {
                return false;
            }

            root = root.children[trieIndex];

            // if end of one word is reached
            // recursively check for the
            // remaining substring
            if (root.isEndOfWord)
            {
                if (isCombinedWord(trie, word, wordIndex + 1, combinedWordCount + 1))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static List<String> findCombinedWords(List<String> words)
    {
        // initialize a trie
        // by inserting words
        Trie trie = new Trie();

        // iterate through the input words
        for (String word: words)
        {
            trie.insert(word);
        }

        List<String> result = new ArrayList < > ();
        for (String word: words)
        {
            int index = 0, combinedWordCount = 0;

            // if the words is a combination
            // of many words, add to the result
            if (isCombinedWord(trie, word, index, combinedWordCount))
            {
                result.add(word);
            }
        }

        return result;
    }
}