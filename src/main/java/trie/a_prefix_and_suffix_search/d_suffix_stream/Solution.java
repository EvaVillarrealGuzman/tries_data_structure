package trie.a_prefix_and_suffix_search.d_suffix_stream;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<String> list1Example1 = List.of("efg", "pqr");
        List<Character> listCharacters1Example1 = List.of('e','p','q','r');

        List<Boolean> resultTest1 = suffixStreamCheck(list1Example1, listCharacters1Example1);
        System.out.println(resultTest1);
    }

    static List<Boolean> suffixStreamCheck(List<String> words, List<Character> queryStream){
        // your code goes here

        // Intialise a prefix and a suffix trie seperately
        SuffixTrie sTrie = new SuffixTrie();

        // insert all the words
        // in both the tries
        for (int i = 0; i < words.size(); i++)
        {
            String str = words.get(i);
            sTrie.insert(str, i);
        }

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < queryStream.size(); i++) {
            String suffix = queryStream.get(i).toString();
            if( sTrie.beginsWith(suffix) ){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }

        return result;
    }

}