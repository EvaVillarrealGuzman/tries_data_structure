package trie.f_miscellaneous.d_palindromes_pairs;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        List<String> words = List.of("efgh","aap","p","pppaa","hgfe");

        List<List<Integer>>  resultTest1 = findPalindromePairs(words);
        System.out.println(resultTest1);
    }

    // checks if substring of word from index i till end of word
    // is a palindrome
    static boolean hasPalindromeRemaining(String s, int i)
    {
        int p1 = i;
        int p2 = s.length() - 1;
        while (p1 < p2)
        {
            if (s.charAt(p1) != s.charAt(p2))
                return false;
            p1++;
            p2--;
        }

        return true;
    }

    static String reverseString(String s)
    {
        char str[] = s.toCharArray();
        int n = str.length;	// length of character array
        int start = 0, end = n - 1;
        while (start <= end)
        {
            // Swapping the characters
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }

        //  Converting characterArray to String
        return String.valueOf(str);
    }

    static List<List < Integer>> findPalindromePairs(List<String> words)
    {
        Trie trie = new Trie();
        // Build the Trie
        for (int wordId = 0; wordId < words.size(); wordId++)
        {
            String word = words.get(wordId);

            //point the current node to the root
            TrieNode curr = trie.root;

            // insert the reversord word into the trie
            String reversedWord = reverseString(word);

            for (int j = 0; j < word.length(); j++)
            {
                //check if substring from index to j till end of word
                // is a palindrome and insert it in array
                if (hasPalindromeRemaining(reversedWord, j))
                {
                    curr.palindromePrefixRemaining.add(wordId);
                }

                int index = reversedWord.charAt(j) - 'a';
                if (curr.children[index] == null)
                {
                    curr.children[index] = new TrieNode();
                }

                curr = curr.children[index];
            }

            curr.indexOfWordEndingHere = wordId;
        }

        // Find pairs
        List<List < Integer>> pairs = new ArrayList < > ();

        for (int wordId = 0; wordId < words.size(); wordId++)
        {
            String word = words.get(wordId);

            //point the current node to the root
            TrieNode curr = trie.root;
            for (int j = 0; j < word.length(); j++)
            {
                // Check for pairs of case 3.
                if (curr.indexOfWordEndingHere != -1 &&
                        hasPalindromeRemaining(word, j))
                {
                    pairs.add(Arrays.asList(wordId, curr.indexOfWordEndingHere));
                }

                // Move down to the next trie level.
                char c = word.charAt(j);
                curr = curr.children[c - 'a'];
                if (curr == null)
                    break;
            }

            if (curr == null)
                continue;
            // Check for pairs of case 1. Note the check to prevent non distinct pairs.
            if (curr.indexOfWordEndingHere != -1 && curr.indexOfWordEndingHere != wordId)
            {
                pairs.add(Arrays.asList(wordId, curr.indexOfWordEndingHere));
            }

            // Check for pairs of case 2.
            for (int otherIndex: curr.palindromePrefixRemaining)
            {
                pairs.add(Arrays.asList(wordId, otherIndex));
            }
        }

        return pairs;
    }
}