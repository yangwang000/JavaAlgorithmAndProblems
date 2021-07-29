package com.java.adawang.problems;

public class Arrays {
	static class MedianOfTwoSortedArrays{
		/*
		* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
		* The overall run time complexity should be O(log (m+n)).
		* Hard
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
}
