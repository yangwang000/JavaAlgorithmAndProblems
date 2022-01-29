package com.java.adawang;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class LeetCode {

	class Solution {
		public List<Integer> findDisappearedNumbers(int[] nums) {
			Arrays.sort(nums);
			List<Integer> ans = new ArrayList<>();
			int left = 0, right = 0;
			while(right < nums.length){
				if(nums[left] != nums[right]){
					if(nums[right] - nums[left] > 1){
						int gap = nums[right] - nums[left];
						for(int i = 1; i < gap; i++){
							ans.add(nums[left] + i);
						}
					}
				}
				left = right;
				right++;
			}

			return ans;
		}
	}

	@Test
	public void whenExceptionThrown_thenAssertionSucceeds() {
		Solution s = new Solution();
		List<Integer> ans = s.findDisappearedNumbers(new int[]{1,1});
		System.out.println(ans);
	}
}