package trie.f_miscellaneous.b_frequent_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        List<String> words = List.of("i learn to code", "i love to code");

        List<String>  resultTest1 = topKFrequentWords(words, 2);
        System.out.println(resultTest1);
    }

    // generate all substrings
    // by iterating in a nested loop
    static List<String> topKFrequentWords(List<String> sentences, int k)
    {
        Map<String, Integer> freqMap = new HashMap();

        // iterate through the sentences

        for (String sentence: sentences)
        {
            String[] words = sentence.split(" ");
            for (String word: words)
            {
                // increment word count in hashmap
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        int n = freqMap.size();

        // create a vector for trienodes
        // to store roots for tries storing
        // words with different frequencies

        List<TrieNode> freqsTrieRoots = new ArrayList < > ();

        // create root nodes
        for (int i = 0; i <= n; i++)
        {
            TrieNode newNode = new TrieNode();
            freqsTrieRoots.add(newNode);
        }

        Trie trie = new Trie();

        for (String word: freqMap.keySet())
        {
            int frequency = freqMap.get(word);
            trie.addWord(freqsTrieRoots.get(frequency), word);
        }

        // initialize a vector for result
        List<String> res = new ArrayList< >();

        // traverse the trie storing the
        // highest frequency words first
        for (int i = n; i >= 1; i--)
        {
            trie.getWord(freqsTrieRoots.get(i), res, k);
        }

        return res;
    }
}