package com.java.adawang.problems;

import java.util.Stack;

public class StackProblems {
	static class StackWithIncrement{
		int n;
		int[] inc;
		Stack<Integer> stack;
		public StackWithIncrement(int maxSize){
			n = maxSize;
			inc = new int[n];
			stack = new Stack<>();
		}
		public void push(int x){
			if(stack.size() < n)
				stack.push(x);
		}

		public int pop(){
			int index = stack.size() - 1;
			if(index < 0)
				return -1;
			if(index > 0)
				inc[index-1] += inc[index];
			int res = stack.pop() + inc[index];
			inc[index] = 0;
			return res;
		}

		public void increment(int k, int val){
			int index = Math.min(k, stack.size()) - 1;
			if(index > 0)
				inc[index] += val;
		}
	}
}
