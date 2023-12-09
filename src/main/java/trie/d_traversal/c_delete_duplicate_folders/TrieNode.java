package trie.d_traversal.c_delete_duplicate_folders;

import java.util.TreeMap;

public class TrieNode {
    // string to hold the name of the folder
    public String name;
    // mapping from folder name to the corresponding child node
    public TreeMap<String, TrieNode> children = new TreeMap();
    // whether this folder is deleted
    public boolean isDeleted = false;
    public TrieNode() {}
}
