## ArraysStrings
1. Check if characters are unique in a given string. There are always two choices: HashMap or  BitVector(Vector`s length depends on character set).
    Problems: IsUnique
2. Check if two strings have identical character counts. (1)Sort two strings then check. (2)Use a letter array to keep the character counts.
    Problems: CheckPermutation

## LinkedLists
1. The"Runner"Technique
The "runner" (or second pointer) technique is used in many linked list problems. The runner technique means that you iterate through the linked list with two pointers simultaneously, with one ahead of the other. The "fast" node might be ahead by a fixed amount, or it might be hopping multiple nodes for each one node that the "slow" node iterates through.
For example, suppose you had a linkedlist a1->a2->•••->an->b1->b2->•••->bn and you wanted to rearrange it into a1 ->b1 - >a2 - >b2 -> ••• - >an - >bn. You do not know the length of the linked list (but you do know that the length is an even number).
You could have one pointer p1 (the fast pointer) move every two elements for every one move that p2 makes. When p1 hits the end of the linked list, p2 will be at the midpoint. Then, move p1 back to the front and begin "weaving" the elements. On each iteration, p2 selects an element and inserts it after p1.
2. Recursive Problems
A number of linked list problems rely on recursion. If you're having trouble solving a linked list problem, you should explore if a recursive approach will work. We won't go into depth on recursion here, since a later chapter is devoted to it.
However, you should remember that recursive algorithms take at least O ( n) space, where n is the depth of the recursive call. All recursive algorithms can be implemented iteratively, although they may be much more complex.
3. Go through a single linked list if necessary
Sometimes go through a single linked list once and get the list length or some other information is helpful.




Linked Lists
Trees, Tries and Graphs
Stacks and Queues
Heaps
Vectors and ArrayLists
HashTables