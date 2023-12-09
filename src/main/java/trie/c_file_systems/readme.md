# Introduction

## File systems

In computing, a file system is a method and data structure that the operating system uses to control how data is stored and retrieved. Without a file system, data placed in a storage medium would be one large body of data with no way to tell where one piece of data stopped and the next began or where any piece of data was located when it was time to retrieve it. By separating the data into pieces and giving each piece a name, the data is easily isolated and identified. The structure and logic rules used to manage the groups of data and their names is called a file system.

## File

A file is the standard storage unit in a computer, and all programs and data are "written" into a file and "read" from a file.

## Directory

A directory is a unique type of file that contains only the information needed to access files or other directories. As a result, a directory occupies less space than other type of files. File systems consist of groups of directories and files within those directories.

## File systems using tries

Due to the presence of common prefixes in the file and directory paths, tries can be an efficient data structure for representing the directory structure of a system.

Each directory can have subdirectories and files under it. Since the names of the files and subdirectories cannot be easily represented using indexes, a map is used to maintain pointers to the children instead of an array. The key of the map is the subdirectory or the file name, and the value is the pointer to the trie node. 

The figure below represents the directory structure created using tries. The directories present in the system are /home/ben/files/movies/home/ben/files/movies, /home/mike/profile/home/mike/profile, /home/arnold/profile/home/arnold/profile. 

![](../../../../../../img/14.43.21.png)

