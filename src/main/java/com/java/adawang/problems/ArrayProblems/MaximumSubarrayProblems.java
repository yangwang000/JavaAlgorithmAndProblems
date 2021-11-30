package com.java.adawang.problems.ArrayProblems;

public class MaximumSubarrayProblems {

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
		// #53
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
}
