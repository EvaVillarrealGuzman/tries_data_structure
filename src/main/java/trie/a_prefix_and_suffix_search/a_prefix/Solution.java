package trie.a_prefix_and_suffix_search.a_prefix;

import java.util.*;
import java.lang.*;

class Solution {
    public static void main(String[] args) {
        List<String> list1Example1 = List.of("app", "apple", "apply", "ape");
        List<String> list2Example1 = List.of("app", "appl", "apex");

        List<String>  resultTest1 = findIsWordOrIsPrefix(list1Example1, list2Example1);
        assert resultTest1.equals(List.of("word", "prefix", "not-found"));
        System.out.println(resultTest1);

        List<String> list1Example2 = List.of("pay", "paid", "pad", "pat");
        List<String> list2Example2 = List.of("pa", "pai", "pat");

        List<String>  resultTest2 = findIsWordOrIsPrefix(list1Example2, list2Example2);
        assert resultTest2.equals(List.of("prefix", "prefix", "word"));
        System.out.println(resultTest2);
    }


    public static List<String> findIsWordOrIsPrefix(List<String> list1, List<String> list2) {
        // your code goes here
        List<String> answer = new ArrayList<>();

        Trie trie = new Trie();

        // Insert all words of list1 in the trie
        for (String word: list1)
        {
            trie.insert(word);
        }

        // Iterate through all words of list2
        for (String word: list2)
        {
            // search the word in the trie
            boolean isCompleteWord = trie.search(word);

            // check if the complete word was found in the trie
            if (isCompleteWord)
            {
                answer.add("word");
            }
            else
            {
                // check if the only a prefix of the word was found in the trie
                boolean isPrefix = trie.beginsWith(word);
                if (isPrefix)
                {
                    answer.add("prefix");
                }
                else
                {
                    answer.add("not-found");
                }
            }
        }

        return answer;
    }
}