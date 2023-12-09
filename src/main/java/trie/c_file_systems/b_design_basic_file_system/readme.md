# Design Basic File System

## Description

Design a file system that allows you to create new text files and add content to them.

The paths in this file system are a set of strings concatenated by slashes ("/").

For example, “home” and “/home/ben” are valid paths, while an empty string and “/” are not.

Currently, this file system supports the following operations.

- createFile: This allows the users to create a file and add data to it. The function should take in the file path and the content as input, create a new file at the given path, and add text content to it. It should return false if the path file already exists or its parent path doesn’t exist.
- getFileData: This allows the users to fetch the data stored in a file. It returns the data stored in the file if the file exists and returns -1 if the path doesn’t exist.
- appendContentToFile: This allows the user to add content to a file. The function should take in the file path and the string content as input. If the file already exists, it appends the given content to the original content.

### Hashmap-based solution

The first intuition after reading this problem will be to use a dictionary or a hashmap to store the files and their data. The file paths will be the keys, and the file content will be the values. Next, we can check the presence of intermediate paths in the file system to verify the validity of adding a new path.

Retrieving the value corresponding to a path is relatively simple because it represents a key in the hashmap. For adding a new path, we can retrieve the parent path and then check if the parent path exists in the hashmap as a key. For example, /home/ben is the parent path for /home/ben/movies and /home/ben/college.

#### Limitations of the hashmap-based approach

It can be observed from the above approach that for adding a path of length L, we need to add all of its ancestors into the hashmap, which ends up occupying a lot of space since each of these ancestors is a new key in the dictionary. The maximum possible number of ancestors can be L×(L−1)/2.
Hashmap can be a viable approach in some cases where the overhead of maintaining the trie nodes is a lot. But generally, a trie should be a better approach.

#### Optimization using trie-based approach

The file paths do have common prefixes. For example, /home/ben/movies and /home/ben/college have a common ancestor: home/ben. The introduction of prefixes in a problem hints toward the usage of tries. A common branch can represent the common prefixes for various strings in the trie, saving a lot of space.

Our custom trie node for this problem will contain three parameters:

- A boolean flag to determine if this path corresponds to a file.
- A string containing the contents of the file corresponding to this path.
- A hashmap representing the outgoing connections to children's files or directories. 

### Algorithm

We can implement the required functions using the following algorithm.

#### File creation

The root of our trie will be a trie node containing the empty string. For creating a new file, we'll split the given path into various components using / as the delimiter. So for the path /home/ben/college, we'll have three components: home, ben, and college. We always start at the root node and then go down based on the various path components. We'll iterate over all of these components, and we'll do the following for each of them:
 
- Check if the folder exists in the current node's dictionary. If it doesn’t, we return false unless it's the last component of the path, in which case we add it to the current dictionary.
- We keep traversing if the current folder exists in the trie node.
- Eventually, we'll process the last folder of the path. If that also exists in the trie, we return false following the problem statement. Else, we add it to the trie by creating a new node with the value given in the input parameters as its contents.

#### Fetching the file contents

To check if a path exists in the trie, we need to verify if all its folders, along with the proper connections, exist in the trie. So, we split the given path into folders using / as the delimiter, initialize a trie node called curr, and point it to the trie's root. Finally, we iterate over all of these components and do the following for each of them:

- Check if the folder exists in the current trie node's dictionary. For example, if the folder exists in the curr node, we update curr with that value and keep traversing the trie downward.
- If at any step the folder doesn’t exist, we return -1; else, if we can find the complete path in the trie, we fetch file content from the map and return it.

#### Appending the file content

To append new data to the contents of a file, we first need to find the file in the system and add content to its original content. The method for finding the file is already defined above. We extend it by a step to add the content to the map.

### Complexity

The variables are:

- Number of directory paths in the input = N.
- The average length of the directory path in the file system = the number of folders in the directory path = F.

#### Time complexity:

- createFile: O(F).
- getFileContent: O(F)
- appendFileContent: O(F)

#### Space complexity:

- createFile: O(F)
- getFileContent: O(1)
- appendFileContent: O(1)
