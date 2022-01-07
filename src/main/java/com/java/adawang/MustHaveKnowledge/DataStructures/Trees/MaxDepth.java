package com.java.adawang.MustHaveKnowledge.DataStructures.Trees;

import org.junit.Test;

import java.util.LinkedList;

public class MaxDepth {
	public int maxDepth(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> depths = new LinkedList<>();
		if (root == null) return 0;

		stack.add(root);
		depths.add(1);

		int depth = 0, current_depth = 0;
		while(!stack.isEmpty()) {
			root = stack.pollLast();
			current_depth = depths.pollLast();
			if (root != null) {
				depth = Math.max(depth, current_depth);
				stack.add(root.left);
				stack.add(root.right);
				depths.add(current_depth + 1);
				depths.add(current_depth + 1);
			}
		}
		return depth;
	}

	@Test
	public void test(){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		int depth = maxDepth(root);
	}
}
