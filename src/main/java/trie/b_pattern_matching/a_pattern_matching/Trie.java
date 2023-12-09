package trie.b_pattern_matching.a_pattern_matching;

public class Trie {
    TrieNode root = new TrieNode();

    // inserts the pattern into the trie
    void insert(String pattern) {

        // point the current node to root
        TrieNode curr = root;

        // iterate all letters in the pattern
        for(char ch : pattern.toCharArray()) {
            int index = -1;
            if(Character.isLowerCase(ch)) {
                index = (int) ch - 'a';
            }
            else {
                // if character is upper case
                // calculate its index
                // [A....Z] map to indexes [26...51]
                index = (int)(ch - 'A') + 26;
            }

            if(curr.children[index] == null)
                curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        // mark isEndOfPattern as "true"
        // for the last node
        curr.isEndOfPattern = true;
    }

    boolean check(String word) {
        // point the current node to root
        TrieNode curr = root;

        // iterate all letters in the word
        for(char ch : word.toCharArray()) {
            int index = -1;
            if(Character.isLowerCase(ch)) {
                index = (int) ch - 'a';

                // if character is lower case
                // if found, the move to the child node

                if(curr.children[index] != null) {
                    curr = curr.children[index];
                }
            }
            else {

                // if character is upper case
                // it should be necessarily present
                index = (int)(ch - 'A') + 26;

                // if child node not found in trie, return false
                // if found, the move to the child node
                if(curr.children[index] == null)
                    return false;
                curr = curr.children[index];
            }
        }

        // return the value of isEndOfPattern
        // associated with the last node of the word
        // value is "true" if pattern is completely matched
        return curr.isEndOfPattern;
    }
}
