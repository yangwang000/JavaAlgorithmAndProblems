package com.java.adawang.MustHaveKnowledge.Algorithms.BinarySearch;

public class BinarySearchTemplates {
	// Template #1 is used to search for an element or
	// condition which can be determined by accessing a
	// single index in the array.
	// Initial Condition: left = 0, right = length-1
	// Termination: left > right
	// Searching Left: right = mid-1
	// Searching Right: left = mid+1
	// Problems: 69. Sqrt(x); 374. Guess Number Higher or
	// Lower; 33. Search in Rotated Sorted Array
	int binarySearchTemplate1(int[] nums, int target){
		if(nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length - 1;
		while(left <= right){
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			if(nums[mid] == target){ return mid; }
			else if(nums[mid] < target) { left = mid + 1; }
			else { right = mid - 1; }
		}

		// End Condition: left > right
		return -1;
	}

	// Template #2 is an advanced form of Binary Search.
	// It is used to search for an element or condition
	// which requires accessing the current index and its
	// immediate right neighbor's index in the array.
    //	Initial Condition: left = 0, right = length
    //	Termination: left == right
    //	Searching Left: right = mid
    //	Searching Right: left = mid+1
	// Problems: 278. First Bad Version;153. Find Minimum in Rotated Sorted Array
	// 162. Find Peak Element
	int binarySearchTemplate2(int[] nums, int target){
		if(nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length;
		while(left < right){
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			if(nums[mid] == target){ return mid; }
			else if(nums[mid] < target) { left = mid + 1; }
			else { right = mid; }
		}

		// Post-processing:
		// End Condition: left == right
		if(left != nums.length && nums[left] == target) return left;
		return -1;
	}

	// Template #3 is another unique form of Binary
	// Search. It is used to search for an element or
	// condition which requires accessing the current
	// index and its immediate left and right neighbor's
	// index in the array.
//	Initial Condition: left = 0, right = length-1
//	Termination: left + 1 == right
//	Searching Left: right = mid
//	Searching Right: left = mid
	// problems: 34. Find First and Last Position of Element in Sorted Array
	// 658. Find K Closest Elements
	int binarySearchTemplat3(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length - 1;
		while (left + 1 < right){
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}

		// Post-processing:
		// End Condition: left + 1 == right
		if(nums[left] == target) return left;
		if(nums[right] == target) return right;
		return -1;
	}
}
