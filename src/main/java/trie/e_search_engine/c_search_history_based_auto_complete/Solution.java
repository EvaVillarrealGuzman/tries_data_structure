package trie.e_search_engine.c_search_history_based_auto_complete;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        findQueryResults(List.of('h','i','s','\n','h','e','r','\n','h','i','m','\n','h','i','t','\n','h','i','m','\n','h','i','\n'));
    }

    static List<List < String>> findQueryResults(List<Character> searchQuery)
    {
        List<List < String>> results = new ArrayList < > ();
        // intialize a new trie
        Trie trie = new Trie();

        for (char c: searchQuery)
        {
            //insert query character to the trie

            List<String> queryOutput = trie.insert(c);
            results.add(queryOutput);
            if (c == '\n')
                continue;
            System.out.print("autocomplete suggestion --> ");
            for (String a: queryOutput)
                System.out.print(a + " ");
            System.out.println();
        }

        return results;
    }
}