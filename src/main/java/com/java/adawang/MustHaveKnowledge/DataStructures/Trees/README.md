## Traverse a Tree
![Tree](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/145_transverse.png) <br>
Typically, for binary search tree, we can retrieve all the data in sorted order using in-order traversal. <br>
Also, post-order is widely use in mathematical expression. It is easier to write a program to parse a post-order expression. Here is an example: <br>
![example](https://github.com/yangwang000/JavaAlgorithmAndProblems/blob/main/src/main/java/com/java/adawang/MustHaveKnowledge/DataStructures/pics/mathematical_expression.png)
You can easily figure out the original expression using the inorder traversal. However, it is not easy for a program to handle this expression since you have to check the priorities of operations. <br>
If you handle this tree in postorder, you can easily 
handle the expression using a stack. Each time when you meet an operator, you can just pop 2 elements from the stack, calculate the result and push the result back into the stack.
