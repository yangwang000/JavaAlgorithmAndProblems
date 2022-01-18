package com.java.adawang;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.SortedMap;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class LeetCode {

	class Solution {
		public int minSubArrayLen(int target, int[] nums) {
			int left = 0 , right = 0, ans = nums.length, sum = 0;

			while(right < nums.length){
				sum += nums[right];
				if(sum == target){
					ans = Math.min(right - left + 1, ans);
					sum -= nums[left];
					left++;
					right++;
				}else if(sum < target){
					right++;
				}else{
					sum -= nums[left];
					left++;
					sum -= nums[right];
				}
			}

			return ans;
		}
	}

	@Test
	public void whenExceptionThrown_thenAssertionSucceeds() {
		Solution s = new Solution();
		int[] nums = {2,3,1,2,4,3};
		int ans = s.minSubArrayLen(7, nums);
		System.out.println(ans);
	}
}
