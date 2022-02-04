package com.java.adawang;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LeetCode {


	   public class TreeNode {
	       int val;
	       TreeNode left;
	       TreeNode right;
	       TreeNode() {}
	       TreeNode(int val) { this.val = val; }
	       TreeNode(int val, TreeNode left, TreeNode right) {
	           this.val = val;
	           this.left = left;
	           this.right = right;
	       }
	   }

	class Solution {
		int curId = 1;

		public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
			Map<String, Integer> serialToId = new HashMap<>();
			Map<Integer, Integer> idToCount = new HashMap<>();
			List<TreeNode> res = new LinkedList<>();
			postorder(root, serialToId, idToCount, res);
			return res;
		}

		private int postorder(TreeNode root, Map<String, Integer> serialToId, Map<Integer, Integer> idToCount, List<TreeNode> res) {
			if (root == null) return 0;
			int leftId = postorder(root.left, serialToId, idToCount, res);
			int rightId = postorder(root.right, serialToId, idToCount, res);
			String curSerial = leftId + "," + root.val + "," + rightId;
			int serialId = serialToId.getOrDefault(curSerial, curId);
			if (serialId == curId) curId++;
			serialToId.put(curSerial, serialId);
			idToCount.put(serialId, idToCount.getOrDefault(serialId, 0) + 1);
			if (idToCount.get(serialId) == 2) res.add(root);
			return serialId;
		}

	}

	@Test
	public void whenExceptionThrown_thenAssertionSucceeds() {
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(4);
		List<TreeNode> output = s.findDuplicateSubtrees(root);
		for(TreeNode node : output)
		    System.out.println(node.val);
	}
}