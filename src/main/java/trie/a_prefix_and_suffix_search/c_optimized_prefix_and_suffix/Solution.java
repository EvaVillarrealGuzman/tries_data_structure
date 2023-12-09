package trie.a_prefix_and_suffix_search.c_optimized_prefix_and_suffix;

import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<String> list1Example1 = List.of("app", "apple", "apply", "applicable");
        String prefixExample1 = "ap";
        String suffixExample1 = "y";

        int  resultTest1 = findWordsWithPrefAndSuff(list1Example1, prefixExample1, suffixExample1);
        System.out.println(resultTest1);
    }

    public static int findWordsWithPrefAndSuff(List<String> words, String prefix, String suffix)
    {
        // Intialize the trie
        Trie trie = new Trie();
        for (int i = 0; i < words.size(); i++)
        {
            String word = words.get(i);
            int n = word.length();

            // generate all possible suffixes
            // append special character and original word to it
            for (int j = 0; j <= n; j++)
            {
                String combination = word.substring(j, n) + '{' + word;
                trie.insert(combination, i);
            }
        }

        // create the query string by concetenating
        // suffix and prefix with a { 	in between
        String query = suffix + '{' + prefix;

        // use beginsWith function and pass query string to find index
        return trie.beginsWith(query);
    }
}