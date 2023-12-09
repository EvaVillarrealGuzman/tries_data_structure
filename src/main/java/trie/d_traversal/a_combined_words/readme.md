# Combined Words

## Description

A combined word is defined as a string that is created by joining at least two shorter words given in the array. Given an array of unique strings, return all the combined words present in the given array.

## Algorithms

- Step 1: Insert the words into a trie

Insert all the words into a trie. Then, iterate again over the list and traverse the trie for each word to check if it's a combined word recursively.

- Step 2: Recursively check for prefixes

Move from the root node downward with each character in the word; if you encounter isEndOfWord as true, it means a valid prefix has been traversed. We can now jump to the root node and keep moving forward in the word or ignore the isEndOfWord flag and keep moving in the word forward without jumping to the trie root node. We make both of these calls recursively.

Once the word ends, we check if the trie traversal finishes on a valid word—that is, for the current trie node, we check if isEndOfWord is true. If it doesn't, it means that it's not a combined word and we return false. If it does, we check the number of times we've previously seen a valid prefix for the current word; if it's more than once, it's a combined word.

### Complexity

The variables are:

- Number of words in the list = N.
- The average length of given words in the input list and the query list  = W.

#### Time complexity:

- Insertion of a word in the trie: O(W).
- Insertion of N input words in the trie: O(N*W)
- Trie traversal to check if a word is a combined word: O(2^W)
- Trie traversal for N words to check if it is a combined word: O(N*2^W)

In the worst case, for a string of length W, we might have two options for every character: either to include it in the word or make another recursive call. Therefore, the time complexity for processing a single word becomes O(2^W). Since this operation is performed for the N input words, the total time complexity becomes O(N×2W).

Combining the complexity of the two steps, the final time complexity is O(N×2^W+N*W), which is dominated by the factor of O(N×2^W).

#### Space complexity:

- Insertion of a word in the trie: O(W).
- Insertion of N input words in the trie: O(N*W)
- Trie traversal to check if a word is a combined word: O(2^W)
- Trie traversal for N words to check if it is a combined word: O(N*2^W)

These recursive calls consume the stack space. The stack space used for processing a single word is O(2^W). 