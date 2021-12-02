package com.java.adawang;

import com.java.adawang.problems.GraphProblems.UnionFind;

import java.util.*;

public class LeetCode {
	// "2-3*4"
	public static int md(String s, int index){
		int n1 = 0;
		int n2 = 0;
		int idx1 = index -1;
		// -1-123*456
		while (idx1 >= 0){
			int temp = s.charAt(idx1) - '0';
			if(temp >= 0 && temp <= 9){
				if(n1 == 0){
					n1 = 3;
				}else{
					n1 = temp*10 + n1;
				}
			}else{
				break;
			}
			idx1--;
		}

		while (idx1 >= 0){
			int temp = s.charAt(idx1) - '0';
			if(temp >= 0 && temp <= 9){
				if(n1 == 0){
					n1 = 3;
				}else{
					n1 = temp*10 + n1;
				}
			}else{
				break;
			}
			idx1--;
		}

		// -1*2
		return n1*n2;
 	}

	public static int countNumbers(int[] sortedArray, int lessThan) {
		int start = 0;
		int end = sortedArray.length - 1;
		while(start < end){
			if(sortedArray[start] > lessThan){
				return start;
			}else{
				int mid = start + (end - start)/2;
				if(sortedArray[mid] < lessThan){
					start = mid + 1;
				}else if(sortedArray[mid] >= lessThan){
					end = mid;
				}
			}

		}
		return start;
	}

	public static void main(String[] args) {
		System.out.println(countNumbers(new int[] { 1, 3, 5, 7 }, 4));
	}
}
