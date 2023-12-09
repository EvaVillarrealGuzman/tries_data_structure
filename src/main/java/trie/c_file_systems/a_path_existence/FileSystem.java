package trie.c_file_systems.a_path_existence;

import java.util.Arrays;
import java.util.List;

public class FileSystem {

    TrieNode root = new TrieNode();

    // inserts the directory path in the file system
    public boolean directoryInsert(String directory)
    {
        int insertions = 0;
        // point the current node to the root of the trie
        TrieNode curr = root;
        List<String> folderPathArray = pathToStringList(directory);

        for (String folder: folderPathArray)
        {
            // If the folder name is not found in trie
            // create a new one
            // else traverse down the path
            TrieNode childDirectory = curr.children.get(folder);
            if (childDirectory == null)
            {
                childDirectory = new TrieNode();
                curr.children.put(folder, childDirectory);
                insertions++;
            }

            curr = childDirectory;
        }

        return insertions > 0;
    }

    public boolean directoryExists(String directory)
    {
        // point the current node to the root of the trie
        TrieNode curr = root;

        // Iterate over the folder names
        List<String> folderPathArray = pathToStringList(directory);
        for (String folder: folderPathArray)
        {
            // If the folder name is not found in trie
            // it means directory does not exists
            // return false
            TrieNode childDirectory = curr.children.get(folder);
            if (childDirectory == null)
            {
                return false;
            }

            curr = childDirectory;
        }

        // if all folders in directory path are
        // found return true
        return true;
    }

    // converts a directory path to
    // list of folder names
    // ex : (/home/mike/profile =>["home", "mike", "profile"])
    public List<String> pathToStringList(String path)
    {
        return Arrays.asList(path.substring(1).split("/"));
    }
}
