# Introduction

Trie traversal refers to visiting every trie node exactly once in a certain order. Depending upon the problem we're solving, we might have to modify the order in which the trie nodes are visited. The list below defines some widely used terms in trie traversals. 

- Root : The first or topmost node in a trie
- Children: Immediate nodes that are connected downward with the current node
- Parent: Immediate nodes that are connected upward with the current node
- Siblings: The nodes originating from the same node
- Descendant: A node that is reachable by repeatedly traversing from parent to child
- Ancestor: A node that is reachable by repeatedly traversing from child to parent
- Leaf: A node that does not have any child 

There are many ways to traverse tries. The most commonly used algorithms are:
 
- Depth-first search 
- Breadth-first search 

## Depth-first traversal

The depth-first search (DFS) algorithm follows the idea of recursion and backtracking. The main idea is to keep traversing downward, along the depth of the trie, until there are no more traversable nodes. When there are no more nodes along the current path, we move backward on the same path as the nodes traversed previously. 

> It’s important to note here that the trie nodes are being traversed in a preorder fashion, which means the root node is traversed before the child nodes. This traversal algorithm also ensures that the result is sorted according to lexicographical order. For example, the result of the above traversal is:
0,10,11,127,128,1294,12957,1299,13,14,15,16,19,2,3,4,5

## Breadth-first traversal

The breadth-first search (BFS) is a traversal algorithm that follows the idea of level-wise or breadth-wise traversal. In BFS, we explore the neighbor nodes before the children nodes. We first move horizontally, visit all the nodes of the current layer, and then move to the next level. 

![](../../../../../../img/14.40.34.gif)

