package trie.e_search_engine.c_search_history_based_auto_complete;

import java.util.*;

public class Trie {
    TrieNode root = new TrieNode();
    String prefix = "";

    // insert the character in the trie
    List<String> insert(char c)
    {
        // on encoutering a new line chacrater
        // update the prefix count in trie
        // reset prefix
        if (c == '\n')
        {
            add(prefix, 1);
            prefix = "";
            return Collections.<String> emptyList();
        }

        prefix += c;
        System.out.println("query " + prefix);

        TrieNode curr = root;

        for (char ch: prefix.toCharArray())
        {
            // if prefix not found
            // return empty array
            if (curr.children.get(ch) == null)
            {
                return Collections.<String> emptyList();
            }

            curr = curr.children.get(ch);
        }

        // use a priority queue for sorting
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>()
        {
            // custom comparator
            // for sorting data based on frequency
            // and then alphabetical order
            public int compare(Pair s1, Pair s2)
            {
                if (s1.getKey() < s2.getKey() ||
                        (s1.getKey() == s2.getKey() && s1.getValue().compareTo(s2.getValue()) > 0))
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            } });

        // insert words and their frequency in priority queue
        HashMap<String, Integer> counterMap = curr.counter;

        for (String key: counterMap.keySet())
        {
            pq.add(new Pair(counterMap.get(key), key));
        }

        List<String> autocomplete = new ArrayList< >();

        // fetch the top three words from priority queue
        for (int i = 0; i < 3 && pq.size() > 0; i++)
        {
            autocomplete.add(pq.poll().getValue());
        }

        return autocomplete;
    }

    // increment the frequency
    // of the word in trie
    void add(String word, int frequency)
    {
        TrieNode curr = root;
        for (char c: word.toCharArray())
        {
            if (curr.children.get(c) == null)
            {
                curr.children.put(c, new TrieNode());
            }

            curr = curr.children.get(c);
            curr.counter.put(word, curr.counter.getOrDefault(word, 0) + frequency);
        }
    }
}
