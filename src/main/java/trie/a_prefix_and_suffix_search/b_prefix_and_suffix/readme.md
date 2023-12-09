# Prefix and Suffix Search

## Description

Given a list of words and two strings pre and suff, return the index of the word that has pre as its prefix and suff as its suffix. If there are multiple valid answers, then return the bigger index. Return -1 if no valid word exists in the list.
## Solution

### Complexity

The variables are:

- Number of words in the list =N.
- The average length of a word or a prefix or a suffix = W.

#### Time complexity:

- Insertion of a word in the trie: O(W).
- Insertion of all words of list in the prefix trie: O(N*W)
- Searching for a given prefix in the trie: O(W)
- Searching for all the words of list in the suffix trie: O(N*W)
- Searching for a given suffix in the trie: O(W)
- Finding the intersection of the prefix and suffix indexes: O(N)

#### Space complexity:

- Insertion of a word in the trie: O(W)
- Insertion of all words of list in the suffix trie: O(N*W)
- Insertion of all words of list in the prefix trie: O(N*W)
