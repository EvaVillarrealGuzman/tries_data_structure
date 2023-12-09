# Design Advanced File System

## Description

Design a file system that allows the user to perform the following operations.

- ls: Allows the users to list all the files and folders present in a directory path. The function should take in the directory path as input and return a list of all files and folder names present in this directory.
- mkdir: Allows the users to create new directories. The function takes the directory name as the input and creates a new directory in the current directory.
- pwd: Returns the path to the present working directory.
- cd: Allows the users to enter a directory. The user cannot enter a file using this command.
- touch: Allows the user to create a new file in the current directory. If a file with the same name already exists in the directory, it shows an error.

### Complexity

The variables are:

- Number of directory paths in the input = N.
- The average length of the directory path in the file system = the number of folders in the directory path = F.

#### Time complexity:

- ls (list the files and directories): O(F).
- mkdir (make a new directory): O(1)
- cd (change directory): O(F)
- pwd (present working directory): O(1)
- touch (create a new file): O(1)

#### Space complexity:

- ls (list the files and directories): O(N*F)
- mkdir (make a new directory): O(1)
- cd (change directory): O(1)
- pwd (present working directory): O(1)
- touch (create a new file): O(1)
