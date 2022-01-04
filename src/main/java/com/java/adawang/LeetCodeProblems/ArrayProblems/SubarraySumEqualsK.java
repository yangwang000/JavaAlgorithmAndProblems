package com.java.adawang.LeetCodeProblems.ArrayProblems;

import java.util.HashMap;

public class SubarraySumEqualsK {
	// #560
	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for(int n : nums){
			sum += n;
			if(map.containsKey( sum - k )){
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}
}
