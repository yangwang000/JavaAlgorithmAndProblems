package com.java.adawang.MustHaveKnowledge.DataStructures.Trees;

import org.junit.Test;

import java.util.LinkedList;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.add(root);
		while(!stack.isEmpty()){
			int l = stack.size();
			int[] vals = new int[l];
			int flag = 0;
			for(int i=0; i < l; i++){
				TreeNode node = stack.pollFirst();
				vals[i] = node.val;
				flag += node.val;

				if(node.left == null){
					stack.add(new TreeNode(101));
				}else{
					stack.add(node.left);
				}

				if(node.right == null){
					stack.add(new TreeNode(101));
				}else{
					stack.add(node.right);
				}
			}

			if(flag/l == 101)
				break;

			if(!isSymArray(vals))
				return false;
		}
		return true;
	}

	public boolean isSymArray(int[] a){
		int head = 0;
		int tail = a.length - 1;
		while(head <= tail){
			if(a[head] != a[tail])
				return false;
			head++;
			tail--;
		}
		return true;
	}

	@Test
	public void test(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		boolean res = isSymmetric(root);
	}
}
