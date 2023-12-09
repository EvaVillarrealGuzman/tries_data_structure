# Search History Based Auto Complete

## Description

Design and implement an auto-complete system that returns the top three "hot" suggestions based on historical searches. The suggestions must be in lexicographical order. The degree of hotness of a search suggestion is the number of times a user typed the same sentence before. The input is a character array.

## Solution

In this problem, we need to create the datastore from the search data itself and return the suggestion based on historical search frequency. This problem will also be solved using tries because of its requirement of prefix matching while performing a search. To accommodate the requirements related to frequency-based searching, we need to store some more information with each trie node. So, we store the previously searched words along with their frequency.

### Algorithm

- Step 1: Build a trie

It's clear from the problem statement that the newline character \n represents the end of a query word. So, whenever we encounter a newline character in the query input, we add the complete word to the trie. If a word already exists in the counter map, we increment the search count by one in the hashmap.

- Step 2: Return the suggestions

The counter map stored at every trie node can be utilized to provide the top-searched queries as suggestions. At every step, we need to pick the top three suggestions based on the search count, so we can use a priority queue here to help us fetch the top ones. Sorting the list of suggestions is also a way, but it incurs a heavier time and space complexity.

### Complexity

The variables are:

- Number of characters in input list = C.
- Number of words in list = N.
- The average length of given words in the input list and the query list = W.

#### Time complexity:

- Inserting a word in the trie: O(W).
- Inserting all N words in the trie: O(N*W)
- Inserting all N words in the priority queue: O(Nlog(N))
- Searching for a prefix and incrementing its count in the hashmap: O(W)
- Performing search for a single query: O(W+Nlog(N)+W)≈O(Nlog(N))

Inserting a query word of size W in the trie adds a time complexity of O(W) since we traverse the trie downward to search the prefix and keep incrementing the count of the word along all the nodes of the path. For example, if the prefix word is his, then the count for his is incremented in counter map of all three nodes h, i, and s. Incrementing the count in the hashmap is a constant time operation.

Returning appropriate suggestions for a query string can be divided into two parts. First is traversing down the trie to find the query prefix, which adds a time complexity of O(W). Once we reach the last node of the prefix, we insert all the words in the counter map into a priority queue to sort them based on the frequency and then subsequently in alphabetical order. The maximum size of the priority queue can be equal to the number of unique words, which is N. Inserting a single word in a priority queue of size N will add a time complexity of O(log(N)). The use of a priority queue for inserting N words incurs a time complexity of O(NlogN). Since we need only the top three suggestions for every query, we can fix the size of the priority queue, which would reduce the complexity. Combining the complexity of these steps, the time complexity becomes O(W+NlogN), in which O(NlogN)is the dominating factor.

These two operations are performed for all the C characters of the query string. Considering the dominating complexity factor, the final time complexity becomes O(C N logN)

#### Space complexity:

- Inserting a word in the trie: O(W).
- Inserting all N words in the trie: O(N*W)
- Inserting words in the counter hashmap of each trie node: O(N^2 * W)

In the worst case, all the letters of all the words can be different. This implies there will be no common prefixes; hence, we create new trie nodes for all word letters. Therefore, the space consumed is proportional to the word length. Since this operation is performed for all the N input words, the total space complexity becomes O(N*W). Also, in the worst case, all nodes in the trie contain all the NN words in their counter hashmap. This adds a space complexity of O(NW×N). Hence, the space complexity is dominated by O(N^2 * W).

While searching the word in the trie, we traverse the existing trie, and no new trie nodes are created, so the space complexity remains constant, which is O(1). 