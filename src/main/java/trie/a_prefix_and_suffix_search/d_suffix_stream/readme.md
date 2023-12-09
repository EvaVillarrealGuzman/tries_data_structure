# Suffix Stream

## Description

Given an array of strings called words and a stream of letters S, check if a suffix of these letters is present as a string in the input array of words. If a non-empty suffix is present as a string, then return true; else, return false.

## Solution

### Complexity

The variables are:

- Number of words in the list =N.
- The average length of given words in the list = W.
- Number of characters in the stream = number of queries = Q.

#### Time complexity:

- Insertion of a word in the trie: O(W).
- Insertion of all words of list in the trie: O(N*W)
- Searching for a given suffix in the trie: O(W)
- Searching for a given suffix in the trie for Q: O(Q*W)

#### Space complexity:

- Insertion of a word in the trie in reversed order: O(W)
- Insertion of all words of list in the trie: O(N*W)
- Creating and maintaining a query stream of size equal to the maximum word length: O(W)
