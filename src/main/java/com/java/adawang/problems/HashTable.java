package com.java.adawang.problems;

import java.util.HashMap;
import java.util.Map;

public class HashTable {
	class TwoSum{
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
}
