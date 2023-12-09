# Pattern Matching

## Description

A pattern will match a word if it can be made equal to the word by inserting zero or more lowercase English characters at any position in the pattern.

Given an array of input string words and a string pattern, return true or false for each word if they can be matched to the pattern or not.

## Solution

There are both uppercase and lowercase letters; therefore, an array of size 52 is used to store the child trie nodes. We store lowercase letters in the first 26 indices and uppercase letters in the last 26 indices. We also include a boolean parameter, isEndOfPattern, to mark the ending of the pattern string in the trie.

### Algorithm

For each word in the input, iterate through the trie with characters in the word to check whether it matches the pattern. The procedure for handling uppercase and lowercase letters will be different here.

- Case 1: Uppercase letters

If the character is an uppercase letter, check whether there exists a path with that character from the current trie node, which means the trie node children array representing this letter is not null.

If the path does not exist, it means the letter is not present in the trie; therefore, the word does not match the pattern and we can return false. Otherwise, if a path exists, we traverse down the node and move to the subsequent letter in the provided word.

- Case 2: Lowercase letters

If the letter is lowercase, it's not necessarily present in the pattern. Check whether the index in the trie node children array representing this letter is null or not. If it's not null, update the current trie node with the next trie node; otherwise, do nothing and continue to the subsequent letters in the provided word.

Following the above procedure, once the word's characters are finished and we encounter a trie node with isEndOfpattern equal to true, it means the word matches the pattern, and we can successfully return true.

### Complexity

The variables are:
 
- The average length of the pattern string = P.
- Number of words in the list = N.
- The average length of given words in the input list = W.

#### Time complexity:

- Inserting a pattern in the trie: O(P).
- Searching for a word in the trie: O(W)
- Searching for NN words in the trie: O(N*W)

The solution is divided into two parts: insertion of the pattern string into the trie and searching the given words in the trie.

1- Inserting a pattern in the trie takes time equal to the length of the pattern. Since we need to create new trie nodes for all letters in the pattern string, the creation of the trie takes times proportional to the length of the pattern, which is O(P).   
2- Searching for a word in the trie takes time equal to the length of the word since we traverse the trie downward, node by node, until either the word length or the trie path is exhausted. Hence, the complexity of this search is equal to the word length, O(W). Since the search is performed for all the N words of the input list, the total time complexity of the search becomes O(NW). 

#### Space complexity:

- Inserting a pattern in the trie: O(P)
- Searching for a word in the trie: O(1)
- Searching for NN words in the trie: O(1)

The solution is divided into two parts: insertion of the pattern string into the trie and searching the given words in the trie.

- All the letters of the pattern are inserted into the trie. We create new trie nodes for all the letters of the pattern. Therefore, the space consumed is proportional to the pattern length. Hence, the space complexity of pattern insertion is O(P).
- While searching the word in the trie, we traverse the existing trie and no new trie nodes are created, so the space complexity remains constant, which is O(1). 

