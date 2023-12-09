package trie.f_miscellaneous.c_sorted_numbers;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    TrieNode root = new TrieNode();

    void insert(int n)
    {
        // convert num to string
        String digit = Integer.toString(n);

        //point current node to root
        TrieNode curr = root;

        //insert the stirng into trie
        for (char c: digit.toCharArray())
        {
            int index = (int) c - '0';
            if (curr.children[index] == null)
            {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        // mark isEndOfNum true for
        // last node in the num string
        curr.isEndOfNum = true;
    }

    // DFS to traverse the trie
    void dfs(TrieNode root, List<Integer> result, String currStr)
    {
        // return if root is null
        if (root == null)
        {
            return;
        }

        // if the current node
        // is the last node of number
        // add the number to result
        if (root.isEndOfNum)
        {
            result.add(Integer.parseInt(currStr));
        }

        // recrusively traverse the trie in preorder
        for (int i = 0; i < 10; ++i)
        {
            if (root.children[i] != null)
            {
                dfs(root.children[i], result, currStr + Integer.toString(i));
            }
        }
    }

    //  dfs to fetch all integers from trie
    // in lexicographical order
    List<Integer> getNums()
    {
        List<Integer> ans = new ArrayList< >();
        dfs(root, ans, "");
        return ans;
    }
}
