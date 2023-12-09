package trie.c_file_systems.a_path_existence;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    // map which stores the pointers from
    // folder names to the children nodes
    Map<String, TrieNode> children = new HashMap< >();
}
