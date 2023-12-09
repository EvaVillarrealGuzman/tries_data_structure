# Path Existence

## Description

Implement two methods, directoryInsert and directoryExists, for provided directory paths.

The directoryInsert method takes the directory path as the input to create the given path. It returns true if a new folder is created; else, it returns false.

The directoryExists method returns true or false depending on whether the provided directory exists in the system.

### Algorithm

#### directoryInsert

We can break each path into a list of words, with each word representing one folder. This list of words can now be inserted into the trie to represent the complete directory structure.

#### directoryExists

Similar to the process in step one, and to searching, we can break the path into a list of words, with each word representing one folder. This list of words can be used to traverse the trie, leading to two possible scenarios.
 
- If the current folder being searched does not exist in the trie, it means the directory path does not exist, and we can return false. For example, the figure below represents the search procedure for the directory path /home/arnold/files.
- While searching for the directory path folder-wise in the trie, we can find all the folders in the trie, which means the entire directory exists in the system, and true is returned. For example, the figure below represents the search procedure for the directory path /home/ben/files/movies.

### Complexity

The variables are:

- Number of directory paths in the input = N.
- The average length of the directory path in the file system = the number of folders in the directory path = F.

#### Time complexity:

- Inserting a directory path in the trie: O(F).
- Inserting N directory paths in the trie: O(N*F)
- Searching for a directory path in the trie: O(F)

#### Space complexity:

- Inserting a directory path in the trie: O(F)
- Inserting N directory paths in the trie: O(N*F)
- Searching for a directory path in the trie: O(1)
