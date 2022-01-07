package com.java.adawang.MustHaveKnowledge.Algorithms.Backtracking;

import org.junit.Test;

import java.util.*;

public class Combinations {
	class IntegerCombinations{
		// Leetcode #77
		// Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
		List<List<Integer>> output = new LinkedList();
		int n;
		int k;

		public void backtrack(int first, LinkedList<Integer> curr) {
			// if the combination is done
			if (curr.size() == k)
				output.add(new LinkedList(curr));

			for (int i = first; i < n + 1; ++i) {
				// add i into the current combination
				curr.add(i);
				// use next integers to complete the combination
				backtrack(i + 1, curr);
				// backtrack
				curr.removeLast();
			}
		}

		public List<List<Integer>> combine(int n, int k) {
			this.n = n;
			this.k = k;
			backtrack(1, new LinkedList<Integer>());
			return output;
		}
	}

	// String generations
	String charString = "abcdefghijklmnopqrstuvwxyz0123456789";
	List<String> strings = new ArrayList<>();
	int stringLength;

	public void backtrackString(String charString,
								StringBuilder sb){
		if(sb.length() == stringLength){
			strings.add(sb.toString());
			return;
		}

		for(char c : charString.toCharArray()){
			sb.append(c);
			String newString  =
					charString.replace(String.valueOf(c), "");
			backtrackString(newString, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}

	public List<String> stringGenerator(){
		for(int i = 4; i < 5; i++){
			this.stringLength = i;
			backtrackString(charString, new StringBuilder());
		}
		return strings;
	}

	@Test
	public void test(){
		List<String> res = stringGenerator();
		System.out.println(res);
	}
}
