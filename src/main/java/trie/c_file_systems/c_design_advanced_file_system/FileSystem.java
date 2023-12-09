package trie.c_file_systems.c_design_advanced_file_system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSystem {
    // pointer to root of trie
    TrieNode root = new TrieNode();

    // pointer to the current (present) working directory
    TrieNode currDir = root;

    // list the directory contents
    private List<String> listDirContents()
    {
        List<String> directories = new ArrayList< >();
        // add all the children of curr directory to the output
        TrieNode curr = currDir;
        for (String keyName: curr.children.keySet())
            directories.add(keyName);
        return directories;
    }

    // create a new directory
    private String makeDirectory(String dirName)
    {
        //create a new directory in the present working directory
        // add a entry in children map and add absolue path details

        TrieNode newNode = new TrieNode();
        newNode.absolutePath = currDir.absolutePath + "/" + dirName;

        // since a new directory is created
        // mark isFile as false

        newNode.isFile = false;
        currDir.children.put(dirName, newNode);
        return ("Created directory " + dirName);
    }

    private String changeDirectory(List<String> folders)
    {
        // change directory to root, if input is "~"
        if (folders.size() == 1 && folders.get(0).equals("~"))
        {
            currDir = root;
            return ("Changed back to root directory");
        }

        // point current node to present working directory
        TrieNode curr = currDir;

        // iterate through folders
        // traverse down the trie
        for (String folder: folders)
        {
            curr = curr.children.get(folder);
            if (curr == null)
            {
                return ("Folder name " + folder + "  not found. Cannot change directory.");
            }

            // if path is file, return error
            if (curr.isFile)
            {
                return ("Cannot cd into " + folder + " .It is a file not directory.");
            }
        }

        // update the present working directory pointer to current director path
        currDir = curr;
        return ("Changed to directory " + currDir.absolutePath);
    }

    private String presentWorkingDirectory()
    {
        // return the absolute path of the node pointing to the present working directory
        return currDir.absolutePath;
    }

    private String createNewFile(String fileName)
    {
        // point current node to present working directory
        TrieNode node = currDir.children.get(fileName);

        // return error, if files already exists
        if (node != null)
        {
            return (fileName + " already exists ");
        }

        //create a new directory in the present working directory
        // add a entry in children map and add absolue path details

        TrieNode newNode = new TrieNode();

        // since a new directory is created
        // mark isFile as true

        newNode.isFile = true;
        newNode.absolutePath = currDir.absolutePath + "/" + fileName;
        currDir.children.put(fileName, newNode);
        return ("Created " + fileName);
    }

    public List<String> ls()
    {
        return listDirContents();
    }

    public String mkdir(String path)
    {
        return makeDirectory(path);
    }

    public String cd(String dirName)
    {
        List<String> folders = pathToStringList(dirName);
        return changeDirectory(folders);
    }

    public String pwd()
    {
        return presentWorkingDirectory();
    }

    public String touch(String fileName)
    {
        return createNewFile(fileName);
    }

    // converts a directory path to
    // list of folder names
    // ex : (/home/mike/profile =>["home", "mike", "profile"])
    public List<String> pathToStringList(String path)
    {
        return Arrays.asList(path.substring(1).split("/"));
    }

}
