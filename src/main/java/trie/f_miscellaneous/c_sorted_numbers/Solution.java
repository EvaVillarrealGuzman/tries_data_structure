package trie.f_miscellaneous.c_sorted_numbers;

import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<Integer>  resultTest1 = lexicalOrder(13);
        System.out.println(resultTest1);
    }

    // return the integers in lexical order
    static List<Integer> lexicalOrder(int n)
    {
        System.out.println(n);
        // initilase a trie
        Trie trie = new Trie();

        //insert all integers from 1 to num
        for (int i = 1; i <= n; i++)
            trie.insert(i);

        // use dfs to fetch all integers from trie
        // in lexicographical order
        return trie.getNums();
    }
}