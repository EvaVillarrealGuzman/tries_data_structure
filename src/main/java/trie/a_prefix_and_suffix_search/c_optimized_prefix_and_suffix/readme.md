# Optimized Prefix and Suffix Search

## Description

Given a list of words and two strings pre and suff, return the index of the word with the string pre as its prefix and the string suff as its suffix. If there are multiple valid answers, then return the bigger index. Solve this problem using a single trie. 

## Solution

### Complexity

The variables are:

- Number of words in the list = N.
- The average length of a word or a prefix or a suffix = W.
- The maximum number of possible suffixes for a word = W. 

#### Time complexity:

- Generating all possible prefix-suffix combinations: O(NW).
- Inserting a single combination in the trie: O(W)
- Inserting all the NW combinations in the trie: O(N*W^2)
- Searching for a given prefix-suffix combination in the trie: O(W)

#### Space complexity:

- Insertion of a word in the trie: O(W)
- Insertion of NW combinations in the trie: O(NW×W)=O(NW2)
