package trie.c_file_systems.b_design_basic_file_system;

import java.util.Arrays;
import java.util.List;

public class FileSystem {

    TrieNode root = new TrieNode();

    // adds content to the given file path
    public boolean insertContentToFile(List<String> path, String data)
    {
        int pathSize = path.size();

        // point current node to the root
        TrieNode curr = root;
        for (int i = 0; i < pathSize; ++i)
        {
            String curFolder = path.get(i);
            if (curr.children.get(curFolder) == null)
            {
                // parent path does not exists
                if (i != pathSize - 1)
                {
                    // parent path does not exists
                    return false;
                }

                curr.children.put(curFolder, new TrieNode());
            }
            else
            {
                if (i == pathSize - 1)
                {
                    // the given path already exist
                    return false;
                }
            }

            curr = curr.children.get(curFolder);
        }

        // if complete file path
        // is created / found
        // add content and return true
        curr.content = data;
        return true;
    }

    public String findFileContent(List<String> path)
    {
        int pathSize = path.size();

        // point the current node to the root
        TrieNode curr = root;

        //iterate through the folder names
        // traversing through the trie
        for (int i = 0; i < pathSize; ++i)
        {
            String curFolder = path.get(i);
            if (curr.children.get(curFolder) == null)
            {
                // if path is not found
                // return -1

                return "-1";
            }

            curr = curr.children.get(curFolder);
        }

        // if path is found
        // return content
        return curr.content;
    }

    public boolean appendFileContent(List<String> path, String newData)
    {
        // point the current node to the root
        int pathSize = path.size();
        TrieNode curr = root;

        //iterate through the folder names
        // traversing through the trie
        for (int i = 0; i < pathSize; ++i)
        {
            String curFolder = path.get(i);
            if (curr.children.get(curFolder) == null)
            {
                // if path is not found
                // return false

                return false;
            }

            curr = curr.children.get(curFolder);
        }

        // if path is found
        // add content and return true
        curr.content += newData;
        return true;
    }

    // converts a directory path to
    // list of folder names
    // ex : (/home/mike/profile =>["home", "mike", "profile"])
    public List<String> pathToStringList(String path)
    {
        return Arrays.asList(path.substring(1).split("/"));
    }

    // creates a new file at the given path
    // and adds the content to it
    public boolean createFile(String path, String data)
    {
        List<String> pathList = pathToStringList(path);
        return insertContentToFile(pathList, data);
    }

    // appends content to the
    // already existing file
    public boolean appendContentToFile(String path, String newData)
    {
        List<String> pathList = pathToStringList(path);
        return appendFileContent(pathList, newData);
    }

    // fetches the file
    // and returns the content stored in end
    public String getFileData(String path)
    {
        List<String> pathList = pathToStringList(path);
        return findFileContent(pathList);
    }
}
