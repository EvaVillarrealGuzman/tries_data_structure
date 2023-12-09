package trie.d_traversal.b_grid_search;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        char[][] grid = {
                {'b', 'o', 'a', 'n'},
                {'e', 'a', 'a', 'e'},
                {'t', 't', 'c', 'a'},
                {'i', 'f', 'l', 'p'}
        };
        List<String> dictionary = List.of("cap", "hat", "boat");

        List<String>  resultTest1 = findWords(grid, dictionary);
        System.out.println(resultTest1);
    }

    static List<String> findWords(char[][] grid, List<String> dictionary)
    {
        // intialize a trie
        Trie trie = new Trie();

        //add all the dict words
        for (String str: dictionary)
            trie.insert(str);

        // result list to store the output of list
        List<String> result = new ArrayList < > ();
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        // stringbuilder to maintain the prefix in the recursive calls
        StringBuilder tempWord = new StringBuilder("");

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                // begin searching in the grid
                dfs(grid, i, j, tempWord, visited, trie.root, result);
            }
        }

        return result;
    }

    static void dfs(char[][] grid, int curRow, int curCol, StringBuilder tempWord,
                    boolean[][] visited, TrieNode trieNode, List<String> result)
    {
        int row = grid.length;
        int col = grid[0].length;
        // check if cur alues out of the grid or if the current cell is visited before
        if (curRow >= row || curRow < 0 || curCol >= col || curCol < 0 || visited[curRow][curCol])
        {
            return;
        }

        char curChar = grid[curRow][curCol];
        int curCharIndex = (int) curChar - 'a';
        // if the next character has not path in Trie it means there exists no
        // string in the input list with prefix formed using next char
        if (trieNode.children[curCharIndex] == null)
        {
            return;
        }

        // marking this cell visisted before starting recursive calls from current cell
        visited[curRow][curCol] = true;

        // adding current cells character to temporary word prefix to be passed on to recursive calls
        tempWord.append(curChar);

        // check if current prefix (including current char) is already present as a word
        // note that the current character would always be present in the child node as we start
        // from root of the Trie which is empty node
        TrieNode childNode = trieNode.children[curCharIndex];
        if (childNode.isEndOfWord)
        {
            result.add(tempWord.toString());
            childNode.isEndOfWord = false;	// avoid duplicates
        }

        // explore in four directions (left, right, up, down)
        dfs(grid, curRow + 1, curCol, tempWord, visited, childNode, result);
        dfs(grid, curRow - 1, curCol, tempWord, visited, childNode, result);
        dfs(grid, curRow, curCol + 1, tempWord, visited, childNode, result);
        dfs(grid, curRow, curCol - 1, tempWord, visited, childNode, result);

        visited[curRow][curCol] = false;
        tempWord.setLength(tempWord.length() - 1);
    }
}