package com.java.adawang.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashmapHashset {
//	Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//	You may assume that each input would have exactly one solution, and you may not use the same element twice.
//	You can return the answer in any order.
//  #1 easy
	static class TwoSum{
		public int[] twoSum(int[] nums, int target){
			Map<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<nums.length; i++){
				int complete = target-nums[i];
				if (map.containsKey(complete)){
					return new int[] {map.get(complete), i};
				}
				map.put(nums[i],i);
			}
			throw new IllegalArgumentException("No two sum solution");
		}
	}

	/*
	 * Given a string s, find the length of the longest
	 * substring without repeating characters.
	 * #3 Medium
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
