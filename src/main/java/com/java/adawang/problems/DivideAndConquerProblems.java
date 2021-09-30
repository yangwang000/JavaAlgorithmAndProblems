package com.java.adawang.problems;

public class DivideAndConquerProblems {
	static class MaximumSubarrayProblem{
		/*
		* Given an array A, we now want to find the
		* nonempty, contiguous subarray of A whose value
		* have the largest sum. We call this contiguous
		* subarray the maximum subarray.
		* */
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
	public static void main(String args[]){
		int[] A = new int[]{13,-3,-25,20,-3,-16,-23,18,20
				,-7,12,-5,-22,15,-4,7};
		int[] maxSubArray =
				MaximumSubarrayProblem.findMaximumSubarray(A, 0, A.length-1);
		for(int i=0; i<maxSubArray.length; i++){
			System.out.println(maxSubArray[i]);
		}
	}
}
