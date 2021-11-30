package com.java.adawang.problems.GreedyProblems;

public class MinimumRemoveMakeValidParentheses {
	// #1249
	public String minRemoveToMakeValid(String s) {
		int balance = 0, left = 0;
		StringBuilder res0 = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == '('){
				balance++;
				left++;
			}else if(c == ')'){
				if(balance == 0) continue;
				balance--;
			}
			res0.append(c);
		}

		StringBuilder res1 = new StringBuilder();
		int rightKeep = left - balance;
		for(int i = 0; i < res0.length(); i++){
			char c = res0.charAt(i);
			if(c == '('){
				rightKeep--;
				if(rightKeep < 0) continue;
			}
			res1.append(c);
		}
		return res1.toString();
	}
}
