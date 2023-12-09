# Search History Based Auto Complete

## Description

We're provided with a list of keywords and a query string. Design a system that provides the top three suggestions from the keyword list to the user every time the user types a character of the query string.

The suggested words should be a prefix of the query string typed so far. If there are more than three valid suggestions, return the three lexicographically smallest ones. For a better user experience, we want to serve these suggestions quickly.

## Solution

This problem is an extension of the search auto-complete. Similar to the search auto-complete problem, approaches like binary search can solve this. But in this problem, we have a restriction to optimize the search time for a query.

In the original solution, upon receiving a query prefix we would traverse the trie until the last node of the prefix, and following that, we would perform DFS to collect all the words under the trie node. However, the preorder trie traversal using DFS to gather the words increased the response time. So now we intend to reduce search time.

To do so, we must eliminate the traversal (DFS) step. One way is to store the list of words in the trie node itself. We introduce a new parameter in the trie node definition called wordsPassingFromHere. It is a sorted set with a maximum size of 33 since the problem asks us to serve the top three suggestions in lexicographical order. For example, if we have a word home, all the four trie nodes (h, o, m, e) in the word path must contain the word home in their wordsPassingFromHere list.

So, in this case, while searching for a query prefix, we traverse to the last node of the prefix and return the wordsPassingFromHere associated with the trie node. Since returning a set is a constant time operation, this optimizes our search time.

### Algorithm

- Step 1: Build a trie of words

We create a trie from the given word list input. While inserting a word in the trie, we add the word in the wordsPassingFromHere list of all the nodes encountered in the path.

- Step 2: Retrieve the suggestions

For serving the suggestions, we iterate each character of the query word, adding it to the prefix to search. After adding the current character to the prefix, we move the trie pointer to the node representing the last character of the prefix string. We return the wordsPassingFromHere list associated with the last node of the query prefix as auto-complete suggestions.

### Complexity

The variables are:

- Number of words in list = N.
- The average length of given words in the input list and the query word = W.

#### Time complexity:

- Inserting a word in the trie: O(W).
- Inserting all N words in the trie: O(N*W)
- Searching for a given prefix in the trie: O(W)
- Searching for words with a given prefix in the trie: O(1)

Inserting a single word in the trie takes time equal to the length of the word —that is, O(W). While inserting a word in the trie, we also insert the word in the wordsPassingFromHere list of the trie nodes encountered in the path. The time complexity of inserting a new word in a set of size SS is log(S). In this problem, we have maintained an upper limit of the set size of 3. So the complexity of insertion in the set remains constant as log(3). Hence the time complexity of adding a single word of size W in the trie is O(W). Since there are no common prefixes in the word, we need to create new trie nodes for all letters. So the creation of a trie of words takes time proportional to the number of words times the average length of a word, which is O(NW).

While searching for a prefix in the trie, we traverse the trie downward node by node until either the prefix length or the trie path is exhausted, which adds a time complexity of O(W). After reaching the last node of the prefix string, we return the list wordsPassingFromHere associated with that node, which is a constant time operation.

#### Space complexity:

- Inserting a word in the trie: O(N^2 * W^2).
- Inserting all N words in the trie: O(N^2 * W^2).

For the insertion of a single word of length W, we create W nodes. In the worst case for every trie node, we store N words of size Win wordsPassingFromHere list. Hence, the space required for adding a single word in the trie is of the order of O(W×NW)=O(N * W^2). Since this operation is performed for N words in the trie, the overall space complexity becomes O(N×NW2)=O(N^2 * W^2).

While searching for a query prefix in the trie, we traverse the trie downward until either the word length or the trie path is exhausted. No new trie nodes are created in this process, so it does not add space complexity.