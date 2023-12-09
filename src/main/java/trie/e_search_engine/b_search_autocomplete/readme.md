# Search Auto-complete

## Description

Auto-complete is a feature—similar to one provided by search engines—that displays query suggestions in real time based on what search string a user is typing in the input field.

We're provided with a list of keywords and a query string. Design a system that provides the top three suggestions from the keyword list to the user every time the user types a character of the query string.

The suggested words should be a prefix of the query string typed so far. If there are more than three valid suggestions, return the three lexicographically smallest ones.

> We can observe that we're essentially searching for all the words with a given prefix. It's well known that tries can solve prefix-related problems easily. But this problem puts a restriction of returning the words in a lexicographically sorted order. Observing closely, we can notice that a preorder traversal of a trie will always result in a sorted order of words.

## Solution

### Algorithm

- Step 1: Build a trie

We create a trie from the given word list input and iterate each character of the query word, adding it to the prefix to search for. After adding the current character to the prefix, we move the trie pointer to the node representing the last character of the prefix string.

- Step 2: DFS on trie

Next, we traverse the trie from the current pointer in a preorder fashion using DFS (checking the trie node's children in order from a to z ensures preorder traversal and makes the final output lexicographically sorted). Whenever a complete word is encountered, we add it to the final result list (completion of a word can be determined using isEndOfWord flag). We limit the result list size to three and return the result.

### Complexity

The variables are:

- Number of words in the list = N.
- The average length of given words in the input list and the query list = W.

#### Time complexity:

- Inserting a word in the trie: O(W)
- Inserting all words of the list in the trie: O(N*W)
- Searching for a given prefix in the trie: O(W).
- Searching for words with a given prefix in the trie: O(N*W)
- Searching for words with a given prefix for all the W prefixes of the word in the trie: O(N*W^2)

While searching for a prefix in the trie, we traverse the trie downward node by node until either the prefix length or the trie path is exhausted, which adds a time complexity of O(W).After reaching the last node of the prefix string, we perform a depth-first search to fetch all the keywords present under the current node. In the worst case, all words can fall under the current prefix. Traversing all the N×W nodes add a time complexity of O(NW). Since this operation is performed for the W prefixes of the query word, the total time complexity becomes O(NW^2).

#### Space complexity:

- Inserting a word in the trie: O(W)
- Inserting all words of the list in the trie: O(N*W)
