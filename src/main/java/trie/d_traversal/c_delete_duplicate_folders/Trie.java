package trie.d_traversal.c_delete_duplicate_folders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    TrieNode root = new TrieNode();

    // Given a path, add nodes to the folder tree.
    // This is similar to the Trie build process.
    void addPath(List<String> path)
    {
        // point the current node to the root
        TrieNode curr = root;
        // if folder does not exist, create new node
        // else move to next node
        for (String p: path)
        {
            if (curr.children.containsKey(p))
            {
                curr = curr.children.get(p);
            }
            else
            {
                TrieNode node = new TrieNode();
                node.name = p;

                // update the children map
                curr.children.put(p, node);
                curr = node;
            }
        }
    }

    //mapping from subfolder structure string to the first occurrence node.
    Map<String, TrieNode> seen = new HashMap();

    // post-order traversal to dedupe.
    // If we've seen the subfolder structure before, mark it as deleted.
    String dedup(TrieNode curr)
    {
        // terminate the search if the current node
        // is null, return subFolders
        String subFolders = "";
        if (curr == null)
        {
            return subFolders;
        }

        //iterate through the children of current node
        // recursively call dedup function
        for (Map.Entry<String, TrieNode> entry: curr.children.entrySet())
        {
            subFolders += dedup(entry.getValue());
        }

        if (subFolders.length() > 0)
        {
            // leaf nodes should be ignored
            if (seen.containsKey(subFolders))
            {
                // if we've seen this subfolder structure before, mark them as deleted.
                seen.get(subFolders).isDeleted = curr.isDeleted = true;
            }
            else
            {
                // otherwise, add the mapping
                seen.put(subFolders, curr);
            }
        }

        // return the folder structure string of this node
        return "(" + curr.name + subFolders + ")";
    }

    // intialize a list to collect directories
    // remaining in the trie
    List<List < String>> remainingDirectories = new ArrayList();

    List<String> path = new ArrayList<String> ();

    // recursively traverse the trie
    // to fetch the non deleted directories
    void getPath(TrieNode curr)
    {
        if (curr == null)
            return;
        if (curr.isDeleted)
            return;

        // add folder name to the path
        path.add(curr.name);

        // add path to the remainingDirectories list
        remainingDirectories.add(new ArrayList < > (path));

        // recursively run getPath on child nodes
        for (Map.Entry<String, TrieNode> entry: curr.children.entrySet())
        {
            getPath(entry.getValue());
        }

        path.remove(path.size() - 1);
    }
}
