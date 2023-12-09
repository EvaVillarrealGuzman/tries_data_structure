package trie.a_prefix_and_suffix_search.b_prefix_and_suffix;

import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<String> list1Example1 = List.of("app", "apple", "apply", "applicable");
        String prefixExample1 = "ap";
        String suffixExample1 = "y";

        int  resultTest1 = findWordsWithPrefAndSuff(list1Example1, prefixExample1, suffixExample1);
        System.out.println(resultTest1);

       /* List<String> list1Example2 = List.of("pay", "paid", "pad", "pat");
        List<String> list2Example2 = List.of("pa", "pai", "pat");

        List<String>  resultTest2 = findIsWordOrIsPrefix(list1Example2, list2Example2);
        assert resultTest2.equals(List.of("prefix", "prefix", "word"));
        System.out.println(resultTest2);*/
    }

    public static int findWordsWithPrefAndSuff(List<String> words, String prefix, String suffix)
    {
        // Intialise a prefix and a suffix trie seperately
        PrefixTrie pTrie = new PrefixTrie();
        SuffixTrie sTrie = new SuffixTrie();

        // insert all the words
        // in both the tries
        for (int i = 0; i < words.size(); i++)
        {
            String str = words.get(i);
            pTrie.insert(str, i);
            sTrie.insert(str, i);
        }

        int ans = 0;
        //find the indices of the words with given prefix
        List<Integer> prefixWords = pTrie.search(prefix);

        //find the indices of the words with given suffix
        List<Integer> suffixWords = sTrie.search(suffix);

        // use two pointers to find
        // the common indices in both arrays
        int i = prefixWords.size() - 1;
        int j = suffixWords.size() - 1;

        while (i >= 0 && j >= 0)
        {
            if (prefixWords.get(i) == suffixWords.get(j))
                return prefixWords.get(i);
            if (prefixWords.get(i) > suffixWords.get(j))
                i--;
            else
                j--;
        }

        return -1;
    }
}