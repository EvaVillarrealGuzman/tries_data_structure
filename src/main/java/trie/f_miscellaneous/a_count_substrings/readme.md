# Count Substrings

## Description

Given a string S, count and return the number of unique substrings of S.

## Solution

Let's try to break the problem. Instead of finding unique substrings, let's find all the substrings of a given string. For this, a nested loop that iterates over all the combinations of the start and end indexes of a string will generate all the possible substrings.

If we insert two strings in a trie, only a single path is created because the set of alphabets is the same. This property of tries can help us identify the count of unique substrings.

### Algorithm

Iterate through the given string S and generate its substrings using a nested loop. Then, insert every substring into the trie and maintain its count. While inserting the substring, check whether a string is already present in the trie.

If while inserting a string in the trie, the last node's isEndOfWord is already true, it means the string has been inserted in the trie previously. Otherwise, if while inserting a string in the trie, the last node's isEndOfWord is false, it means it hasn't been inserted in the trie before. Therefore, we increment the unique substring counter and mark isEndOFWord as true for the last node of the current substring.

Let's try to understand the procedure better with the help of the given example string aaab.

- Step 1: While inserting the substring a, a new trie node for a is created since it doesn't already exist. Then, we increment the unique string counter and mark isEndOfWord as true.
- Step 2: While inserting the substring aa, a new trie node for a is created since it doesn't already exist. We increment the unique string counter and mark isEndOfWord for the newly added node for a as true.
- Step 3: While inserting the substring aaa, a new trie node for a is created since it doesn't already exist. We increment the unique string counter and mark isEndOfWord for the newly added a node as true.
- Step 4: While inserting the substring aaab, a new trie node for b is created since it doesn't already exist. We increment the unique string counter and mark isEndOfWord for the newly added b node as true.
- Step 5: While inserting the substring a, there is no need to create a new trie node since a is already present. Also, since isEndOfWord is true already for this node, the unique string counter is not incremented.
- Step 6: While inserting the substring aa, there is no need to create a new trie node since aa is already present. Also, for the last node in the string aa, isEndOfWord is already true, so the unique string counter is not incremented.
- Step 7: While inserting the substring aab, a new trie node b is created since the path aab didn't already exist. So we increment the unique string counter and mark isEndOfWord as true.
- Step 8: While inserting the substring ab, a new trie node b is created since the path ab didn't already exist. Here also, for the last node b, isEndOfWord is false, so we increment the unique string counter and mark isEndOfWord as true.
- Step 9: While inserting the substring b" a new trie node b is created since the path b didn't already exist. Here also, for the last node b, isEndOfWord is false, so we increment the unique string counter and mark isEndOfWord as true.

As shown in the table, we can keep a counter that accounts for unique substrings seen and is incremented whenever a new string ends at a node where isEndOfWord is false.

| Substring      | Counter | 
|----------------|---------|
| insert("a")    | 1       |
| insert("aa")   | 2       |
| insert("aaa")  | 3       |
| insert("aaab") | 4       |
| insert("a")    | 4       |
| insert("aa")   | 4       |
| insert("aab")  | 5       |
| insert("a")    | 5       |
| insert("ab")   | 6       |
| insert("b")    | 7       |

### Complexity

The variables are:

- The average length of given words in the input list = W.
- Maximum number of substrings of a string of length W = (W+(W−1)+.....+2+1)≈W^2.

#### Time complexity:

- Inserting a word in the trie: O(W)
- Inserting W^2 words (substrings) in the trie: O(W^3)

The insert function dominates the complexity of this solution. This function adds the word into the trie and checks whether the string is unique. For inserting the word in the trie, we iterate from the first to the last character of the word. This takes time equal to the length of the word. Insertion of a single word of size WW adds a time complexity of O(W). Since this operation is performed for all the W^2 substrings of the word, the total complexity is O(W^2 × W)=O(W^3).

#### Space complexity:

- The average length of given words in the input list = W.
- Maximum number of substrings of a string of length W = (W+(W−1)+.....+2+1)≈W^2.

In the worst case, all the letters of all the substrings can differ. This implies that there will be no common prefixes; hence, new trie nodes will be created for all the letters of the word (substring). The word (substring) length has an upper limit of W since the entire word can be considered as a substring. Therefore, the space consumed is proportional to the word length, that is O(W). Since this operation is performed for all the W^2 substrings, the total space complexity becomes O(W^3). 

It's important to note here that there are other ways to remove duplicates, but trie suits the purpose best.

- We can remove the duplicates by iterating over the complete substring list using nested loops and comparing the substrings. The time complexity would be high in this case. The size of the list containing all the substrings would be O(W^2), and a nested loop to remove the duplicates would add a time complexity of the order O(W^2×W^2)=O(W^4), which is worse than the trie approach.
- Another way to remove duplicates is to use hashsets. The time complexity in this case would be O(W^2) since there are O(W^2) substrings to enter into the hashset, and insertion into the hashset will cost us O(1) time. Although the time complexity is better, space complexity differs. We'll be storing all the unique substrings in the hashset, and in the worst case, where all substrings are unique, the map will contain W^2 substrings; therefore, the space complexity would be O(W^2). 
- In the case of the trie, we won't store all the substrings in the trie, because all the unique substrings with the same prefix will share the same path in the trie. Note that after inserting four strings (a, aa, aaa, aaaa), the trie only contains one path, aaaa, and the other strings overlap with it.

Hence, for any string of length W, if we insert the substring from the index i to W in the trie, all the substrings from i to W−1,W−2,W−3,... would already be present in the trie. There will be a total of W substrings added in the trie, incurring a space complexity of O(W), which is better than the O(W^2) space complexity in case of hashset.