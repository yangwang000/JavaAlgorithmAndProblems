## Strings
1. Check if characters are unique in a given string. There are always two choices: HashMap or  BitVector(Vector`s length depends on character set).
    Problems: IsUnique
2. Check if two strings have identical character counts. (1)Sort two strings then check. (2)Use a letter array to keep the character counts.
    Problems: CheckPermutation


## Arrays
1. Some problems requires in-place array manipulation, in these cases, try _**two pass**_ .
2. Always remember there are  _**two pointers**_. And there are **_HashMap_** and **_HashSet_** ready to help in one pass search situations.
3. **Two-pointer Technique - Scenario I:**
Let's start with a classic problem:Reverse the elements in an array.
The idea is to swap the first element with the end, advance to the next element and swapping repeatedly until it reaches the middle position. 
**Two-pointer Technique - Scenario II**
Sometimes, we can use **two pointers with different steps** to solve problems.
Let's start with another classic problem: Given an array and a value, remove all instances of that value in-place and return the new length.
This is a very common scenario of using the two-pointer technique when you need: One slow-runner and one fast-runner at the same time.

**Two-Pointers**
![two-pointer](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/Array_Basics_Conclusion_1.png)

**Circular Array**
![circular](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/Array_Basics_Conclusion_2.png)

## Queues and Stacks (Need to practice these problems more)
Remember when you want to **_process the elements in order_**, using a queue might be a good choice.
Queue - BFS, Stack - DFS.


## LinkedLists
1. The"Runner"Technique (Two Pointer Technique)
The "runner" (or second pointer) technique is used in many linked list problems. The runner technique means that you iterate through the linked list with two pointers simultaneously, with one ahead of the other. The "fast" node might be ahead by a fixed amount, or it might be hopping multiple nodes for each one node that the "slow" node iterates through.
For example, suppose you had a linkedlist a1->a2->•••->an->b1->b2->•••->bn and you wanted to rearrange it into a1 ->b1 - >a2 - >b2 -> ••• - >an - >bn. You do not know the length of the linked list (but you do know that the length is an even number).
You could have one pointer p1 (the fast pointer) move every two elements for every one move that p2 makes. When p1 hits the end of the linked list, p2 will be at the midpoint. Then, move p1 back to the front and begin "weaving" the elements. On each iteration, p2 selects an element and inserts it after p1.
2. Recursive Problems
A number of linked list problems rely on recursion. If you're having trouble solving a linked list problem, you should explore if a recursive approach will work. We won't go into depth on recursion here, since a later chapter is devoted to it.
However, you should remember that recursive algorithms take at least O ( n) space, where n is the depth of the recursive call. All recursive algorithms can be implemented iteratively, although they may be much more complex.
3. Go through a single linked list if necessary
Sometimes go through a single linked list once and get the list length or some other information is helpful.
4. Feel free to use several pointers at the same time.
5. In many cases, you need to track the previous node of the current node.

## Traverse a Tree
![Tree](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/145_transverse.png) <br>
Typically, for binary search tree, we can retrieve all the data in sorted order using in-order traversal. <br>

Also, post-order is widely use in mathematical expression. It is easier to write a program to parse a post-order expression. Here is an example: <br>
![example](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/mathematical_expression.png) <br>

You can easily figure out the original expression using the inorder traversal. However, it is not easy for a program to handle this expression since you have to check the priorities of operations. <br>
If you handle this tree in postorder, you can easily
handle the expression using a stack. Each time when you meet an operator, you can just pop 2 elements from the stack, calculate the result and push the result back into the stack.

## HashSet
Typically, a hash set is used to check if a value has ever appeared or not.
```
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. initialize the hash set
        Set<Integer> hashSet = new HashSet<>();     
        // 2. add a new key
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(1);
        // 3. remove the key
        hashSet.remove(2);        
        // 4. check if the key is in the hash set
        if (!hashSet.contains(2)) {
            System.out.println("Key 2 is not in the hash set.");
        }
        // 5. get the size of the hash set
        System.out.println("The size of has set is: " + hashSet.size());     
        // 6. iterate the hash set
        for (Integer i : hashSet) {
            System.out.print(i + " ");
        }
        System.out.println("are in the hash set.");
        // 7. clear the hash set
        hashSet.clear();
        // 8. check if the hash set is empty
        if (hashSet.isEmpty()) {
            System.out.println("hash set is empty now!");
        }
    }
}
```

## HashMap
HashMap usage example:
```
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. initialize a hash map
        Map<Integer, Integer> hashmap = new HashMap<>();
        // 2. insert a new (key, value) pair
        hashmap.putIfAbsent(0, 0);
        hashmap.putIfAbsent(2, 3);
        // 3. insert a new (key, value) pair or update the value of existed key
        hashmap.put(1, 1);
        hashmap.put(1, 2);
        // 4. get the value of specific key
        System.out.println("The value of key 1 is: " + hashmap.get(1));
        // 5. delete a key
        hashmap.remove(2);
        // 6. check if a key is in the hash map
        if (!hashmap.containsKey(2)) {
            System.out.println("Key 2 is not in the hash map.");
        }
        // 7. get the size of the hash map
        System.out.println("The size of hash map is: " + hashmap.size()); 
        // 8. iterate the hash map
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
        }
        System.out.println("are in the hash map.");
        // 9. clear the hash map
        hashmap.clear();
        // 10. check if the hash map is empty
        if (hashmap.isEmpty()) {
            System.out.println("hash map is empty now!");
        }
    }
}
```

### Scenario I - Provide More Information
Given an array of integers, return indices of the two numbers such that they add up to a specific target. Tow Sum problem.
### Scenario II - Aggregate by Key
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
### Design the Key
Given an array of strings, group anagrams together.
1. When the order of each element in the string/array doesn't matter, you can use the **sorted** string/array as the key.
![pic1](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/designTheKey1.png)
2. If you only care about the offset of each value, usually the offset from the first value, you can use the **offset** as the key.
![pic2](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/designTheKey2.png)
3. In a tree, you might want to directly use the TreeNode as key sometimes. But in most cases, the **serialization of the subtree** might be a better idea.
![pic3](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/designTheKey3.png)
4. In a matrix, you might want to use **the row index or the column index** as key.
5. In a Sudoku, you can combine the row index and the column index to identify which **block** this element belongs to.
![pic5](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/designTheKey5.png)
6. Sometimes, in a matrix, you might want to aggregate the values in the same **diagonal line**. 
![pic6](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/designTheKey6.png)
