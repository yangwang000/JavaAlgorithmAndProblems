package com.java.adawang.problems.ArrayProblems;

import java.util.*;

public class XSUM {
	public static List<List<Integer>> twoSumTwoPointers(int[] nums, int target, int start){
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		int lowPointer = start, highPointer =
				nums.length - 1;
		while (lowPointer < highPointer){
			int sum =
					nums[lowPointer] + nums[highPointer];
			if(sum < target || (lowPointer > start && nums[lowPointer] == nums[lowPointer-1])) {
				lowPointer++;
			}else if(sum > target || (highPointer < nums.length-1 && nums[highPointer] == nums[highPointer+1])){
				highPointer--;
			}else {
				res.add(Arrays.asList(nums[lowPointer++], nums[highPointer--]));
			}
		}
		return res;
	}

	public static List<List<Integer>> twoSumHashSet(int[] nums, int target, int start){
		List<List<Integer>> res = new ArrayList<>();
		Set<Integer> s = new HashSet<>();
		for(int i = 0; i < nums.length; i++){
			if(res.isEmpty() || res.get(res.size()-1).get(1) != nums[i]){
				if(s.contains(target-nums[i])){
					res.add(Arrays.asList(target-nums[i], nums[i]));
				}
			}
			s.add(nums[i]);
		}
		return res;
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){
			if(i==0 || nums[i] != nums[i-1]){
				int head = i + 1, tail = nums.length -1,
						sum = 0 - nums[i];
				while(head < tail){
					if(nums[head] + nums[tail] == sum){
						result.add(Arrays.asList(nums[i],
								nums[head], nums[tail]));
						while(head < tail && nums[head] == nums[head+1]) head++;
						while(head < tail && nums[tail] == nums[tail-1]) tail--;
						head++;
						tail--;
					}else if(nums[head] + nums[tail] > sum){
						tail--;
					}else {
						head++;
					}
				}
			}
		}
		return result;
	}

	public static int threeSumClosest(int[] nums,
									  int target) {
		if(nums.length < 3)
			throw new IllegalArgumentException(
					"illegal input");
		int res =
				nums[0] + nums[1] + nums[nums.length-1];
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){
			int head = i + 1;
			int tail = nums.length - 1;
			while (head < tail){
				int sum =
						nums[i] + nums[head] + nums[tail];
				if(sum == target){
					return sum;
				}else if(sum > target){
					tail--;
				}else {
					head++;
				}
				int a = (target > res) ?
						target - res : res - target;
				long b = (target > sum) ?
						target - sum : sum - target;
				if( b < a ){
					res = sum;
				}
			}
		}
		return res;
	}

	public static List<List<Integer>> fourSum(int[] nums,
											  int target) {
		Arrays.sort(nums);
		return kSum(nums, target, 0, 4);
	}

	public static List<List<Integer>> kSum(int[] nums
			, int target, int start, int k){
		List<List<Integer>> res = new ArrayList<>();
		//If we have run out of numbers to add,
		// return res
		if(start == nums.length){
			return res;
		}
		// There are k remaining values to add to the sum. The
		// average of these values is at least target / k.
		int average_value = target / k;
		// We cannot obtain a sum of target if the smallest value
		// in nums is greater than target / k or if the largest
		// value in nums is smaller than target / k.
		if  (nums[start] > average_value || average_value > nums[nums.length - 1]) {
			return res;
		}
		if(k == 2){
			return twoSumTwoPointers(nums, target,
					start);
		}
		for(int i = start; i < nums.length; i++){
			if(i==start || nums[i-1] != nums[i]){
				for(List<Integer> subset : kSum(nums
						, target - nums[i], i+1, k-1)){
					res.add(new ArrayList<>(Arrays.asList(nums[i])));
					res.get(res.size()-1).addAll(subset);
				}
			}
		}
		return res;
	}
}
