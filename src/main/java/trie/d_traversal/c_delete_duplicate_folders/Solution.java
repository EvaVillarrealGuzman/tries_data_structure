package trie.d_traversal.c_delete_duplicate_folders;

import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        List<String> dictionary1 = List.of("Ben");
        List<String> dictionary2 = List.of("Ben", "Movies");
        List<String> dictionary3 = List.of("Ben", "College");
        List<String> dictionary4 = List.of("Ben", "College", "Physics");

        List<String> dictionary5 = List.of("Emilia");
        List<String> dictionary6 = List.of("Emilia", "Movies");
        List<String> dictionary7 = List.of("Emilia", "College");
        List<String> dictionary8 = List.of("Emilia", "College", "Physics");

        List<String> dictionary9 = List.of("Adam");
        List<String> dictionary10 = List.of("Adam", "Work");

        List< List<String>> list = List.of(dictionary1, dictionary2, dictionary3, dictionary4, dictionary5, dictionary6, dictionary7, dictionary8, dictionary9, dictionary10);


        List<List < String>>  resultTest1 = deleteDuplicateFolders(list);
        System.out.println(resultTest1);
    }

    // deletes duplicates folders
    static List<List < String>> deleteDuplicateFolders(List<List < String>> paths)
    {
        // Initialize a trie
        Trie trie = new Trie();

        // add all directories to trie
        for (List<String> path: paths)
        {
            trie.addPath(path);
        }

        // run deduplication from root
        trie.dedup(trie.root);

        // fetch all the directories
        // which are not deleted
        for (Map.Entry<String, TrieNode> entry: trie.root.children.entrySet())
        {
            trie.getPath(entry.getValue());
        }

        // return the final list of
        // directories remaining in the trie
        return trie.remainingDirectories;
    }
}