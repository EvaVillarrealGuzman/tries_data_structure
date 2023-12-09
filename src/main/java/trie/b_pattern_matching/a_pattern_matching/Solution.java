package trie.b_pattern_matching.a_pattern_matching;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<String> list1Example1 = List.of("KnowledgeTransfer", "KneeTest", "KnowledgeTrip", "KneeCap", "CropTop");
        String patternExample1 = "KT";

        List<Boolean>  resultTest1 = patternMatcher(list1Example1, patternExample1);
        System.out.println(resultTest1);
    }

    static List<Boolean> patternMatcher(List<String> words, String pattern) {

        // Initialize a trie
        Trie trie = new Trie();

        // insert the pattern into the trie
        trie.insert(pattern);

        List<Boolean> ans = new ArrayList<>();
        for(String word : words) {

            // For all words, check if they match the pattern
            Boolean isPatternMatching = trie.check(word);
            ans.add(isPatternMatching);
        }
        return ans;
    }
}