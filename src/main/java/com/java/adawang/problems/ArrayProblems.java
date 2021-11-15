package com.java.adawang.problems;

import java.util.*;
import java.util.LinkedList;

public class ArrayProblems {
	static class MedianOfTwoSortedArrays{
		/*
		* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
		* The overall run time complexity should be O(log (m+n)).
		* #4 Hard
		* hint : binary search is faster
		* */
		public double findMedianSortedArrays(int[] nums1,
											 int[] nums2) {
			if(nums1.length > nums2.length){
				int[] temp = nums1;
				nums1 = nums2;
				nums2 = temp;
			}
			int halfLength =
					(nums1.length + nums2.length + 1)/2;
			int leftNums1 = 0;
			int rightNums1 = nums1.length;
			while (leftNums1 <= rightNums1){
				int indexNums1 = (leftNums1 + rightNums1)/2;
				int indexNums2 = halfLength - indexNums1;
				if(indexNums1 < rightNums1 && nums2[indexNums2-1] > nums1[indexNums1]){
					leftNums1 = indexNums1 +1;
				}else if(leftNums1 < indexNums1 && nums1[indexNums1-1] > nums2[indexNums2]){
					rightNums1 = indexNums1 -1;
				}else {
					int maxLeft = 0;
					if(indexNums1 == 0){
						maxLeft = nums2[indexNums2-1];
					}else if(indexNums2 == 0){
						maxLeft = nums1[indexNums1-1];
					}else {
						maxLeft =
								Math.max(nums1[indexNums1-1], nums2[indexNums2-1]);
					}

					if((nums1.length+nums2.length)%2==1)
						return maxLeft;

					int minRight = 0;
					if(indexNums1 == nums1.length){
						minRight = nums2[indexNums2];
					}else if (indexNums2 == nums2.length){
						minRight = nums1[indexNums1];
					}else {
						minRight =
								Math.min(nums1[indexNums1], nums2[indexNums2]);
					}
					return (maxLeft+minRight)/2.0;
				}
			}
			return 0.0;
		}
	}

//	Greedy
	static class ContainerWithMostWater{
		public static int maxArea(int[] height){
			int leftIndex = 0;
			int rightIndex = height.length - 1;
			int maxArea =
					(height[leftIndex] < height[rightIndex]) ? height[leftIndex]*(height.length-1) : height[rightIndex]*(height.length-1);
			while (leftIndex < rightIndex){
				int i = leftIndex + 1;
				int j = rightIndex - 1;
				if(height[leftIndex] <= height[rightIndex]){
					for(; i < rightIndex; i++){
						if(height[i] >= height[leftIndex]){
							leftIndex = i;
							break;
						}
					}
				}else {
					for(; j > leftIndex; j--){
						if(height[j] >= height[rightIndex]){
							rightIndex = j;
							break;
						}
					}
				}
				int width = rightIndex - leftIndex;
				int area =
						(height[leftIndex] < height[rightIndex]) ? height[leftIndex]*width : height[rightIndex]*width;
				if(area > maxArea)
					maxArea = area;
				if( i==rightIndex || j==leftIndex ){
					break;
				}
			}
			return maxArea;
		}
	}

	static class XSum{
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

	static class RemoveDuplicatesFromSortedArray{
		public static int removeDuplicates(int[] nums) {
			int resLength = nums.length;
			int index = 0;
			while (index < resLength-1){
				if(nums[index] == nums[index+1]){
					int tempIndex = index + 1;
					while (tempIndex+1 < resLength){
						nums[tempIndex] = nums[tempIndex+1];
						tempIndex++;
					}
					resLength--;
				}else {
					index++;
				}
			}
			System.out.println(Arrays.toString(nums));
			return resLength;
		}

		public static int removeElement(int[] nums, int val) {
			int i = 0;
			for(int n: nums){
				if(n != val){
					nums[i++] = n;
				}
			}
			System.out.println(Arrays.toString(nums));
			return i;
		}
	}

	static class MaximumPopulationYear{
		public static int maximumPopulation(int[][] logs) {
			int pop[] = new int[101], res = 0;
			for (var l : logs) {
				++pop[l[0]-1950];
				--pop[l[1]-1950];
			}
			for (int i = 1; i < 101; ++i) {
				pop[i] += pop[i - 1];
				res = pop[i] > pop[res] ? i : res;
			}
			return res+1950;
		}
	}

	static class MissingElementInSortedArray{
		public int missingElement(int[] nums, int k) {
			int diff = 0;
			for(int i = 1; i < nums.length; i++){
				diff = nums[i] - nums[i-1] - 1;
				if(diff < k){
					k -= diff;
				}else {
					return nums[i-1] + k;
				}
			}
			return nums[nums.length-1] + k;
		}

		// Return how many numbers are missing until nums[idx]
		int missing(int idx, int[] nums) {
			int res = nums[idx] - nums[0] - idx;
			return res;
		}
		public int missingElementBinarySearch(int[] nums,
										 int k) {
			int n = nums.length;
			// If kth missing number is larger than
			// the last element of the array
			if (k > missing(n - 1, nums))
				return nums[n - 1] + k - missing(n - 1, nums);

			int left = 0, right = n - 1, pivot;
			// find left = right index such that
			// missing(left - 1) < k <= missing(left)
			while (left != right) {
				pivot = left + (right - left) / 2;

				if (missing(pivot, nums) < k) left = pivot + 1;
				else right = pivot;
			}

			// kth missing number is greater than nums[idx - 1]
			// and less than nums[idx]
			return nums[left - 1] + k - missing(left - 1, nums);
		}
	}

	static class VerifyingAnAlienDictionary{
		public boolean isAlienSorted(String[] words,
									 String order) {
			int[] orderMap = new int[26];
			for (int i = 0; i < order.length(); i++){
				orderMap[order.charAt(i) - 'a'] = i;
			}

			for (int i = 0; i < words.length - 1; i++) {

				for (int j = 0; j < words[i].length(); j++) {
					// If we do not find a mismatch letter between words[i] and words[i + 1],
					// we need to examine the case when words are like ("apple", "app").
					if (j >= words[i + 1].length()) return false;

					if (words[i].charAt(j) != words[i + 1].charAt(j)) {
						int currentWordChar = words[i].charAt(j) - 'a';
						int nextWordChar = words[i + 1].charAt(j) - 'a';
						if (orderMap[currentWordChar] > orderMap[nextWordChar]) return false;
							// if we find the first different letter and they are sorted,
							// then there's no need to check remaining letters
						else break;
					}
				}
			}

			return true;
		}
	}

	static class StockPrice{
		public int onePass(int[] prices){
			int buyPrice = prices[0];
			int maxProf = 0;
			for(int i = 0; i< prices.length; i++){
				if(prices[i] < buyPrice){
					buyPrice = prices[i];
				}else if(prices[i] - buyPrice > maxProf){
					maxProf = prices[i] - buyPrice;
				}
			}
			return maxProf;
		}
		public static int[] findMaximumSubarray(int[] A, int low
				, int high){
			if(low == high){
				return new int[]{low, high, A[low]};
			}else {
				int mid = (low + high)/2;
				int[] left = findMaximumSubarray(A,
						low, mid);
				int[] right = findMaximumSubarray(A,
						mid+1, high);
				int[] cross = findMaxCrossingSubarray(A,
						low, mid, high);
				if(left[2] > right[2] && left[2] > cross[2])
					return left;
				else if (right[2] > left[2] && right[2] > cross[2])
					return right;
				else return cross;
			}
		}
		private static int[] findMaxCrossingSubarray(int[] A,
													 int low,
													 int mid,
													 int high){
			int leftSum = Integer.MIN_VALUE;
			int sum = 0;
			int maxLeft = mid;
			for(int i = mid; i >= low; i--){
				sum += A[i];
				if(sum > leftSum){
					leftSum = sum;
					maxLeft = i;
				}
			}
			int rightSum = Integer.MIN_VALUE;
			sum = 0;
			int maxRight = mid + 1;
			for(int j = mid + 1; j <= high; j++){
				sum += A[j];
				if(sum > rightSum){
					rightSum = sum;
					maxRight = j;
				}
			}
			return new int[]{maxLeft, maxRight, leftSum+rightSum};
		}
	}

	static class MaximumSubarray{
		public int maxSubArrayKadane(int[] nums) {
			int currsum = nums[0];
			int maxsum = nums[0];
			for(int i = 1; i < nums.length; i++){
				int num = nums[i];
				currsum = Math.max(num, currsum+num);
				maxsum = Math.max(currsum, maxsum);
			}
			return maxsum;
		}
	}

	static class CountClockDigits{

		public static int[] countClockDigits(int[] startTime, int[] endTime){
			int[] res = new int[60];
			int[] startCount = countFromZero(startTime);
			int[] endCount = countFromZero(endTime);
			for(int i = 0; i < 60; i++){
				res[i] = endCount[i] - startCount[i];
			}
			res[startTime[0]] += 1;
			res[startTime[1]] += 1;
			res[startTime[2]] += 1;
			return res;
		}

		public static int[] countFromZero(int[] input){
			int[] h = new int[60];
			int[] m = new int[60];
			int[] s = new int[60];

			for(int i = 0; i < input[0] ; i++){
				h[i] = 360;
				for(int j = 0; j < 60; j++){
					m[j] += 60;
					s[j] += 60;
				}
			}

			for(int i = 0; i < input[1] ; i++){
				h[input[0]] += 60;
				m[i] += 60;
				for(int j = 0; j < 60; j++){
					s[j] += 1;
				}
			}

			for(int i = 0; i <= input[2]; i++){
				h[input[0]] += 1;
				m[input[1]] += 1;
				s[i] += 1;
			}

			int[] res = new int[60];
			for(int i = 0; i < 60; i++){
				res[i] = h[i] + m[i] + s[i];
			}
			return res;
		}
	}

	public static void main(String[] args){
		// test count clock digits
		int[] startInput = new int[]{0,0,1};
		int[] startOutput =
				CountClockDigits.countFromZero(startInput);
		System.out.println(Arrays.toString(startOutput));
		int[] endInput = new int[]{0,0,5};
		int[] endOutput = CountClockDigits.countFromZero(endInput);
		System.out.println(Arrays.toString(endOutput));
		System.out.println(Arrays.toString(CountClockDigits.countClockDigits(startInput, endInput)));

//		//test removeElement
//		int[] input = new int[] {3,2,2,3};// val=3
//		input = new int[]{0,1,2,2,3,0,4,2};//val=2
//		int res =
//				RemoveDuplicatesFromSortedArray.removeElement(input, 2);
//		System.out.println(res);

//		//test removeDuplicates
//		int[] input = new int[]{1,1,2};//2
////		input = new int[]{0,0,1,1,1,2,2,3,3,4};//5
//		int res =
//				RemoveDuplicatesFromSortedArray.removeDuplicates(input);
//		System.out.println(res);

//		// test fourSum
//		int[] input = new int[]{1,0,-1,0,-2,2};
//		//target = 0
//		//[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
////		input = new int[] {2,2,2,2,2};
//		//target = 8
//		//Output: [[2,2,2,2]]
//		List<List<Integer>> res = XSum.fourSum(input, 0);
//		System.out.println(res);

//		//test fourSum
//		int[] input = new int[] {1,0,-1,0,-2,2};
//		List<List<Integer>> res = XSum.fourSum(input, 0);
//		System.out.println(res);

//		//test threeSumClosest
//		int[] input = new int[] {-1,2,1,-4};
//		input = new int[] {0,0,0};
//		input = new int[] {-3,-2,-5,3,-4};
//		int output = XSum.threeSumClosest(input, -1);
//		System.out.println(output);

//		//test threeSum
//		int[] nums = new int[] {-1,0,1,2,-1,-4};
//		//[[-1,-1,2],[-1,0,1]]
//		List<List<Integer>> result = XSum.threeSum(nums);
//		System.out.println(result);

//		//test ContainerWithMostWater
//		int[] height = new int[] {1,8,6,2,5,4,8,3,7};//49
////		int[] height = new int[] {1,1};//1
////		int[] height = new int[] {4,3,2,1,4};//16
////		int[] height = new int[] {1,2,1};//2
////		int[] height = new int[] {2,3,4,5,18,17,6};//17
////		int[] height = new int[] {1,8,100,2,100,4,8,3,7};
////		//200
////		int[] height = new int[] {6,4,3,1,4,6,99,62,1,2,
////				6}; //62
////		int[] height = new int[] {1,8,6,2,5,4,8,25,7};//49
////		int[] height =
////				new int[] {0,14,6,2,10,9,4,1,10,3};//70
//		int maxArea =
//				ContainerWithMostWater.maxArea(height);
//		System.out.println(maxArea);

//		//test twoSum
//		int[] input = new int[]	{2,7,11,15};
//		int[] output = new int[] {0,1};
//		int target = 9;
//		input = new int[] {3,2,4};
//		output = new int[] {1,2};
//		target = 6;
//		input = new int[] {3,3};
//		target = 6;
//		output = new int[] {0,1};
//		List<List<Integer>> res =
//				XSum.twoSumHashSet(input, 6, 0);
//		System.out.println(res);
	}
}
