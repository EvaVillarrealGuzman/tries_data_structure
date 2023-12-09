# Smart Matching

## Description

Given a list of different words and an array of string queries, return a boolean array answer where answer[i] is true if you can change exactly one character in the ithith query string to match any word in the list; return false otherwise.

### Algorithm

The summary of the algorithm is given below.

- Step 1: Insertion in the trie

Generate a list of words where a special character, _, replaces each character of the word. Insert all these words in the trie. Please include an extra pointer in the trie node's children array to handle the special character.

- Step 2: Searching in the trie

For each query word, generate all possible one-letter-away words, as in the step above, by replacing each character with _ one by one and creating a new word for each character replacement. Then, search for these query words in the trie. If the word is found, return true; else, return false.

### Complexity

The variables are:
 
- Number of words in the list = N.
- Number of words in query list = Q.
- The average length of given words in the input list and the query list = W.

#### Time complexity:

- Generating all the variations of an input word with a special character: O(W).
- Inserting a word in the trie: O(W)
- Inserting all the W variations of the word in the trie: O(W^2)
- Inserting all the W variations of the NN input words in the trie: O(N*W^2)
- Searching for a single variation of a query word in the trie: O(W)
- Searching for W variations of a query word in the trie: O(W^2)
- Searching for all variations of Q query words in the trie: O(Q*W^2)

The solution is divided into two parts: insertion of the variations of the input words into the trie and searching the variations of the query words in the trie.

- Inserting a word in trie takes time equal to the length of the word. We create variations of the presented word by replacing each character of the word one by one with _. A word of length W will have W variations. Insertion of a single variation of size W adds a time complexity of O(W). Insertion of all the variations of a word will incur a complexity of O(W×W). Since this operation is performed for all the N words of the input list, the total complexity becomes O(N× W×W)=O(N*W^2). 
- Searching for a word in the trie takes time equal to the length of the word since we traverse the trie downward, node by node, until either the word length or the trie path is exhausted. We generate variations of the given query word and search for all of these in the trie. Searching for a single variation of a word in the trie adds a time complexity of O(W). Generating variations adds a complexity of O(W). Exploring all WW variations of a word in the trie contributes to the complexity of O(W×W). Since this operation is performed for all the Q query words of the input list, the total complexity becomes O(Q× W×W)=O(Q*W^2).

Combining the time complexity of the two steps, the final time complexity becomes, O(N*W^2+Q*W^2).

#### Space complexity:

- Inserting a word in the trie: O(W)
- Inserting all the W variations of a word in the trie: O(W^2)
- Inserting variations ofNNinput words in the trie: O(N*W^2)

The solution is divided into two parts: insertion of the variations of the input words into the trie and searching the variations of the query words in the trie.
 
- In the worst case, all the letters of all the words can be different. This implies that there will be no common prefixes; therefore, we create new trie nodes for all word letters. Hence, the space consumed is proportional to the word length. All the WW variations of an input word of length W are inserted into the trie. This adds a space complexity of O(W^2). Since this operation is performed for all the N input words, the total space complexity becomes O(N*W^2). 
- While searching the word in the trie, we traverse the existing trie, and no new trie nodes are created. The space complexity remains constant, which is O(1). 

On combining the space complexity of the two steps, the final space complexity becomes O(NW2).