# Keyword Search

## Description

Given two lists of words (strings), for each word in the second list, identify if the word appears as either a complete word or a prefix of any word in the first list. If it's present as a complete word, print "word". If it's present as a prefix, print "prefix". If it isn't present as either a complete word or a prefix, print "not-found".

## Solution

### Complexity

The variables are:

- Number of words in list1 = N1.
- Number of words in list2 = N2.
- The average length of given words = W.

#### Time complexity:

- Insertion of a word in the trie: O(W).
- Insertion of all words of list1 in the trie: O(N1*W)
- Searching for a given word of list2 in trie: O(W)
- Searching for all the words of list2 in the trie: O(N2*W)

#### Space complexity:

- Insertion of a word in the trie: O(W)
- Insertion of all words of list1 in the trie: O(N1*W)

In the worst case, all the letters of all the words can be different. This implies that there will be no common prefixes, and therefore new trie nodes will be created for all the letters of all the words.

While searching for a prefix in the trie, we traverse the trie downward until either the word length or the trie path is exhausted. No new trie nodes are created in this process, so it doesn't add space complexity. 