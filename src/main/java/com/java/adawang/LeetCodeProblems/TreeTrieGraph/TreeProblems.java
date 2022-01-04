package com.java.adawang.LeetCodeProblems.TreeTrieGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import com.java.adawang.LeetCodeProblems.utils.TreeNode;

public class TreeProblems {
	static class MyCalendar {
		TreeMap<Integer, Integer> calendar;

		MyCalendar() {
			this.calendar = new TreeMap<>();
		}

		public boolean book(int start, int end) {
			Integer pre = calendar.floorKey(start);
			Integer next = calendar.ceilingKey(start);
			if((pre == null || calendar.get(pre) <= start) && (next == null || end <= next)){
				calendar.put(start,end);
				return true;
			}
			return false;
		}
	}

	static class PrintBinaryTree{
		public List<List<String>> printTree(TreeNode root) {
			int height = height(root,1);
			int len = (int)Math.pow(2,height) - 1;
			List<List<String>> list = new ArrayList<>();
			for(int i = 0;i<height;i++){
				List<String> tempList = new ArrayList<>();
				for(int j = 0;j<len ;j++)
					tempList.add("");
				list.add(new ArrayList(tempList));
			}
			setTree(list,root,0,len - 1,height,0);
			return list;
		}
		private int height(TreeNode root,int level){
			if(root == null) return level - 1;
			return Math.max(height(root.left,level + 1),height(root.right, level + 1));
		}
		private void setTree(List<List<String>> list, TreeNode root,
							 int left, int right, int height,int level){
			if(height == level || root == null) return;
			int mid = left + (right - left)/2; //    Here is the mid
			list.get(level).set(mid,String.valueOf(root.val));
			setTree(list,root.left,left,mid - 1,height,level+ 1);
			setTree(list,root.right,mid + 1,right,height,level+1);
		}
	}
}
