package com.java.adawang.problems;

import java.util.HashSet;

public class StringProblems {
	/*
	* Given a string s, find the length of the longest
	* substring without repeating characters.
	* Medium
	* */
	static class LengthOfLongestSubstring{
		public int lengthOfLongestSubstring(String s) {
			int maxLength = 0;
			int start = 0;
			int end = 0;
			HashSet longestSubstring = new HashSet();
			while(end < s.length()){
				if(longestSubstring.add(s.charAt(end))){
					end ++;
					maxLength = Math.max(maxLength,
							longestSubstring.size());
				}else{
					longestSubstring.remove(s.charAt(start));
					start++;
				}
			}
			return maxLength;
		}
	}
}
