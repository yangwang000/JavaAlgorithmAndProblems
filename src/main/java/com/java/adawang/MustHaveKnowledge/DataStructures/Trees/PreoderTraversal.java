package com.java.adawang.MustHaveKnowledge.DataStructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreoderTraversal {
	/*Let's start from the root and then at each iteration
	pop the current node out of the stack and push its child
	nodes. In the implemented strategy we push nodes into
	output list following the order Top->Bottom and
	Left->Right, that naturally reproduces preorder traversal.
	Time Complexity : O(n)
	Space Complexity : O(n)*/
	public List<Integer> preorderTraversalIterator(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> output = new LinkedList<>();
		if (root == null) {
			return output;
		}

		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pollLast();
			output.add(node.val);
			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.left != null) {
				stack.add(node.left);
			}
		}
		return output;
	}

	/*This approach is based on Morris's article which
	is intended to optimize the space complexity.  The
	algorithm does not use additional space for the
	computation, and the memory is only used to keep
	the output. If one prints the output directly along
	the computation, the space complexity would be O(1)*/
	public List<Integer> preorderTraversalMorris(TreeNode root) {
		LinkedList<Integer> output = new LinkedList<>();

		TreeNode node = root;
		while (node != null) {
			if (node.left == null) {
				output.add(node.val);
				node = node.right;
			}
			else {
				TreeNode predecessor = node.left;
				while ((predecessor.right != null) && (predecessor.right != node)) {
					predecessor = predecessor.right;
				}

				if (predecessor.right == null) {
					output.add(node.val);
					predecessor.right = node;
					node = node.left;
				}
				else{
					predecessor.right = null;
					node = node.right;
				}
			}
		}
		return output;
	}

	final List<Integer> l = new ArrayList<>();
	public List<Integer> preorderTraversalRecursive(TreeNode root) {
		if(root == null) return l;
		l.add(root.val);
		preorderTraversalRecursive(root.left);
		preorderTraversalRecursive(root.right);
		return l;
	}
}
