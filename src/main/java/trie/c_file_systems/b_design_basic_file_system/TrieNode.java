package trie.c_file_systems.b_design_basic_file_system;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    // map which stores the pointers from
    // folder names to the children nodes
    Map<String, TrieNode> children = new HashMap< >();

    // to store the contents of the file
    String content;
}
