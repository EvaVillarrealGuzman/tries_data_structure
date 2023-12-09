package trie.c_file_systems.c_design_advanced_file_system;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    // a flag to identify if a
    // node represents a file
    boolean isFile;

    // map which stores the pointers from
    // folder names to the children nodes
    Map<String, TrieNode> children = new HashMap< >();

    // to store the aboslute path of the file or directory
    String absolutePath = "";
}
