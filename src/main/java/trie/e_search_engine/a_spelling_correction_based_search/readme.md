# Spelling Correction-Based Search

## Description

Design and implement a search system that returns one-character-away suggestions. Strings that differ in only one letter are one-character-away strings. For example, kit and kat differ only in the second position. Below is a list of unique words present in the datastore and an array of string queries. Return one character away from strings present in the datastore for all the string queries.

## Solution

There are both uppercase and lowercase letters; therefore, an array of size 52 is used to store the child trie nodes. We store lowercase letters in the first 26 indices and uppercase letters in the last 26 indices. We also include a boolean parameter, isEndOfPattern, to mark the ending of the pattern string in the trie.

### Algorithm

- Step 1: Insertion in the trie

For every word of the datastore, generate a list of words where a special character, _, replaces each character of the word. Insert all these words in the trie. Add an extra pointer in the children's array to handle the special character. Finally, add the complete word string in words array of the last trie node.

- Step 2: Searching in the trie

For each query word, generate all possible one-letter-away words, same as in the step above, by replacing each character with _ one by one and creating a new word for each character replacement. Then, search for these query words in the trie. If the word is found, return the words list associated with the last trie node; else, return an empty array.

### Complexity

The variables are:

- Number of words in the list = N.
- Number of words in query list = Q.
- The average length of given words in the input list and the query list = W.

#### Time complexity:

- Generating all variations of a word with a special character: O(W).
- Inserting a word in the trie: O(W)
- Inserting all variations of the word in the trie: O(W^2)
- Inserting all variations of the N input words in the trie: O(N*W^2).
- Searching for a given word in the trie: O(W)
- Searching for all the variations of Q query words in the trie: O(Q*W)

Inserting a word in the trie takes time equal to the length of the word. We create variations of the presented word by replacing each character of the word one by one. For example, a word of length W will have W variations. Insertion of a single variation of size W adds a time complexity of O(W). Insertion of all the variations of a word will incur a complexity of O(W×W). Since this operation is performed for all the N words of the input list, the total complexity becomes O(N× W×W)=O(N*W^2).

Searching for a word in the trie takes time equal to the length of the word—that is, O(W). Since we traverse the trie downward, node by node, until either the word length or the trie path is exhausted, we generate variations of the given query word and search all those in the trie. Generating variations adds a complexity of O(W). Exploring all variations in the trie contributes to the complexity of O(W×W). Since this operation is performed for all the QQ words of the query list, the total complexity becomes O(Q× W×W)=O(QW2).

Combining the time complexity of the two steps, the final time complexity becomes O(NW2+QW2).

#### Space complexity:

- Inserting a word in the trie: O(W)
- Inserting all variations of the word in the trie: O(W^2)
- Inserting all variations of the N input words in the trie: O(N*W^2).

In the worst case, all the letters of all the words can be different. It implies that there will be no common prefixes; hence, we create new trie nodes for all the letters of all the input words. Therefore, the space consumed is proportional to the word length. All the W variations of an input word of length W are inserted into the trie. It adds a space complexity of O(W^2). Since this operation is performed for all the N input words, the total space complexity becomes O(N*W^2).

While searching the word in the trie, we traverse the existing trie and no new trie nodes are created, so the space complexity remains constant, which is O(1). 