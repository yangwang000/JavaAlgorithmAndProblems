package com.java.adawang;

import com.java.adawang.problems.GraphProblems.UnionFind;

import java.util.*;

public class LeetCode {
	static class Solution {
		public static int[] numss;

		public static void swap(int a, int b) {
			int tmp = numss[a];
			numss[a] = numss[b];
			numss[b] = tmp;
		}


		public static int partition(int left, int right, int pivot_index) {
			int pivot = numss[pivot_index];
			// 1. move pivot to end
			swap(pivot_index, right);
			int store_index = left;

			// 2. move all smaller elements to the left
			for (int i = left; i <= right; i++) {
				if (numss[i] < pivot) {
					swap(store_index, i);
					store_index++;
				}
			}

			// 3. move pivot to its final place
			swap(store_index, right);

			return store_index;
		}

		public static int quickselect(int left, int right, int k_smallest) {
    /*
    Returns the k-th smallest element of list within left..right.
    */

			if (left == right) // If the list contains only one element,
				return numss[left];  // return that element

			// select a random pivot_index
			Random random_num = new Random();
			int pivot_index = left + random_num.nextInt(right - left);

			pivot_index = partition(left, right, pivot_index);

			// the pivot is on (N - k)th smallest position
			if (k_smallest == pivot_index)
				return numss[k_smallest];
				// go left side
			else if (k_smallest < pivot_index)
				return quickselect(left, pivot_index - 1, k_smallest);
			// go right side
			return quickselect(pivot_index + 1, right, k_smallest);
		}

		public static int findKthLargest(int[] nums, int k) {
			numss = nums;
			int size = nums.length;
			// kth largest is (N - k)th smallest
			return quickselect(0, size - 1, size - k);
		}
	}
	public static void main(String[] args){
		System.out.println(Solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
	}
}
