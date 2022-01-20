## Sorting
|Name|Average Runtime|Worst Case|Memory|
|---|---|---|---|
|Bubble Sort|n*n| n * n |1|
|Selection Sort| n*n | n * n|1|
|Merge Sort| nLog(n) | nLog(n) | Depends|
|Quick Sort| nLog(n) | n * n | nLog(n)|
|Radix Sort| k*n | ||
__*Sorting Algorithms*__ https://en.wikipedia.org/wiki/Sorting_algorithm

## Binary Search
### Template I (left <= right):
Initial Condition: left = 0, right = length-1
Termination: left > right
Searching Left: right = mid-1
Searching Right: left = mid+1
Problems: Sqrt(x); Guess Number Higher or Lower; Search in Rotated Sorted Array;
```
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length - 1;
  while(left <= right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid - 1; }
  }

  // End Condition: left > right
  return -1;
}
```

### Template II (left < right)
Initial Condition: left = 0, right = length
Termination: left == right
Searching Left: right = mid
Searching Right: left = mid+1
Problems: First Bad Version; Find Minimum in Rotated Sorted Array; Find Peak Element;
```
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length;
  while(left < right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid; }
  }

  // Post-processing:
  // End Condition: left == right
  if(left != nums.length && nums[left] == target) return left;
  return -1;
}
```

### Template III (left + 1 < right)
Initial Condition: left = 0, right = length-1
Termination: left + 1 == right
Searching Left: right = mid
Searching Right: left = mid
problems: Find First and Last Position of Element in Sorted Array; Find K Closest Elements;
```
int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0)
        return -1;

    int left = 0, right = nums.length - 1;
    while (left + 1 < right){
        // Prevent (left + right) overflow
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }

    // Post-processing:
    // End Condition: left + 1 == right
    if(nums[left] == target) return left;
    if(nums[right] == target) return right;
    return -1;
}
```

## Backtracking
### References:
[1] https://cs.lmu.edu/~ray/notes/backtracking/

## BFS/DFS
![Tree](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/145_transverse.png) <br>
Typically, for binary search tree, we can retrieve all the data in sorted order using in-order traversal. <br>

Also, post-order is widely use in mathematical expression. It is easier to write a program to parse a post-order expression. Here is an example: <br>
![example](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/mathematical_expression.png) <br>
You can easily figure out the original expression using the inorder traversal. However, it is not easy for a program to handle this expression since you have to check the priorities of operations. <br>
If you handle this tree in postorder, you can easily handle the expression using a stack. Each time when you meet an operator, you can just pop 2 elements from the stack, calculate the result and push the result back into the stack.<br>
### 
**BFS**
Previously, we have already introduced two main scenarios of using BFS: do **traversal** or **find the shortest path**. Typically, it happens in a tree or a graph. BFS can also be used in more abstract scenarios.<br>
It will be important to determine the nodes and the edges before doing BFS in a specific question. Typically, the node will be an actual node or a status while the edge will be an actual edge or a possible transition.
**Template 1**
```
/**
 * Return the length of the shortest path between root and target node.
 */
int BFS(Node root, Node target) {
    Queue<Node> queue;  // store all nodes which are waiting to be processed
    int step = 0;       // number of steps neeeded from root to current node
    // initialize
    add root to queue;
    // BFS
    while (queue is not empty) {
        // iterate the nodes which are already in the queue
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            Node cur = the first node in queue;
            return step if cur is target;
            for (Node next : the neighbors of cur) {
                add next to queue;
            }
            remove the first node from queue;
        }
        step = step + 1;
    }
    return -1;          // there is no path from root to target
}
```
**Template 2**
Sometimes, it is important to make sure that we never visit a node twice. Otherwise, we might get stuck in an infinite loop, e.g. in graph with cycle. If so, we can add a hash set to the code above to solve this problem. 
```
/**
 * Return the length of the shortest path between root and target node.
 */
int BFS(Node root, Node target) {
    Queue<Node> queue;  // store all nodes which are waiting to be processed
    Set<Node> visited;  // store all the nodes that we've visited
    int step = 0;       // number of steps neeeded from root to current node
    // initialize
    add root to queue;
    add root to visited;
    // BFS
    while (queue is not empty) {
        // iterate the nodes which are already in the queue
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            Node cur = the first node in queue;
            return step if cur is target;
            for (Node next : the neighbors of cur) {
                if (next is not in visited) {
                    add next to queue;
                    add next to visited;
                }
            }
            remove the first node from queue;
        }
        step = step + 1;
    }
    return -1;          // there is no path from root to target
}
```

**DFS**
**Template: Recursion**
It seems like we don't have to use any stacks when we implement DFS recursively. But actually, we are using the implicit stack provided by the system, also known as the _Call Stack_.
```
/*
 * Return true if there is a path from cur to target.
 */
boolean DFS(Node cur, Node target, Set<Node> visited) {
    return true if cur is target;
    for (next : each neighbor of cur) {
        if (next is not in visited) {
            add next to visted;
            return true if DFS(next, target, visited) == true;
        }
    }
    return false;
}
```

## Sliding Window
One of typical Sliding-Window problems is : **Repeated DNA Sequences** . The solutions are based on sliding-window + hashset.
![sliding-window]()
