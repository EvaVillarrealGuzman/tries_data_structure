# Frequent Words

## Description

Given a list of sentences and an integer K, return the K most frequent words present in those sentences, sorted by their frequency. In case there's a tie in frequency, sort the words lexicographically.

## Solution

The most intuitive method to solve this problem is sorting with a custom comparator. The comparator first compares the frequency of two words and sorts them in descending order of frequency. If the frequency for two words is the same, then they are sorted in alphabetically ascending (lexicographical) order.

Let the total number of words combined from all the sentences be N. The best-case time complexity of a standard sorting algorithm like merge sort is O(N log(N)).

The frequency of each word is stored in an unordered map. The size of the map can be O(N), where N is the number of unique words. Also, the space required by a sorting algorithm is O(N). So the final space complexity is O(N).

We ignored one helpful parameter provided in the input in the previous sorting-based approach. We only need to find the top K words with the highest frequency. Since it's known that K<<N, we can derive a faster approach compared to sorting.

We'll use a min-heap to store the top K words with higher frequency. Let's try to understand how min-heap helps us solve this problem by walking through the given examples. One important point to note here is that the min-heap's root always contains the smallest element. Also, we'll use a priority queue as a min-heap in our code.

We iterate on a hashmap containing the string word as the key and its frequency in sentences as the value. We insert the (word, frequency) pair in the min-heap. The main logic to note here is that the maximum size of the heap is K, so after every insertion in a heap, we check the size of the heap. If it exceeds K, we pop the element at the top, which will always be the word with the minimum frequency since it's min-heap. After performing this operation for all (word, frequency) pairs, K words with the highest frequency are left in the min-heap, and the rest are popped out.

Let the total number of words combined from all the sentences be N. The size of the heap is K, and every insertion in a heap takes time equal to its size, so the complexity of insertion in a heap is O(log(K)). This insertion is performed for all the N words, so the total time complexity is O(N log(K)). The space required by a min-heap is equal to its size, which is O(K).

There are two important observations here. First, once we have the list of words and their frequencies, we can divide them into buckets based on their frequencies. After that, we need to sort the words in lexicographical order in each bucket, which can be easily achieved using a trie. Preorder trie traversal results in sorted strings.

### Algorithm

- Step 1: Construct a frequency map

Maintain a frequency map, which stores words as the key and their count in the sentences as the value. Traverse through the given sentences, incrementing the counter (value) of the words in the frequency hashmap.

- Step 2: Build tries

Based on the frequency of the word, insert the words into their respective tries. Build a trie that consists of all words within the same bucket.

- Step 3: Extract the top K words

Use depth-first search (DFS) to traverse the trie. Traverse the tries in descending order of the frequency buckets. This means that tries containing the words with higher frequency must be traversed first. Following the preorder fashion, keep adding the words to the result list until the list size becomes K.

### Complexity

The variables are:
 
- Number of unique words in the input = N.
- The average length of given words in the input list = W.

#### Time complexity:

- Creating a map with words and their frequencies: O(N).
- Inserting a word in the trie: O(W)
- Inserting all N words in the trie: O(N*W)
- Extracting top K words from the trie: O(K*W)

Creating a frequency map: We use a hashmap to store the words and their corresponding frequencies. The time complexity of the insertion and retrieval from a map is O(1). Since N words are inserted into the hashmap, the time complexity becomes O(N).

Insertion of words into the trie: Insertion of a word in the trie takes time equal to the length of the word. For inserting a word in the trie, we iterate from the first to the last character of the word. Insertion of a single word of size W adds a time complexity of O(W). The total time complexity of the insertion of the words in the trie is proportional to the number of unique words times the average length of the word, which is O(NW).

Extracting the top K words from a trie: To fetch the final answer, the trie is traversed K times and the words are extracted from the trie and appended to the result list. The time complexity of fetching a word from a trie is O(W), where W is a constant upper limit on the length of the words. So the time complexity for extracting the top K words becomes O(KW).

#### Space complexity:

- Creating a map with words and their frequencies: O(N)
- Inserting a word in the trie: O(W)
- Inserting all N words in the trie: O(N*W)

We're using a hashmap to store the words and their corresponding frequencies. The time complexity of the insertion and retrieval from a map is O(1). Since NN words are inserted into the hashmap, the space complexity becomes O(N).

In the worst case, all the letters of all the words can differ. This implies that there will be no common prefixes; hence, new trie nodes will be created for all the letters of the word. The word length has an upper limit of W. Therefore, the space consumed is proportional to the word length—that is, O(W). Since this operation is performed for all the N words, the total space complexity becomes O(NW).

On adding the space complexities of all these data structures, the final space complexity is O(N+NW), which is dominated by the factor O(NW). 