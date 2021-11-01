package com.java.adawang.problems;

import com.java.adawang.datastructure.ListAndIterator.ArrayList;

import java.util.HashSet;
import java.util.Set;

public class GreedyAlgorithms {
	static class ActivitySelectionProblem{
		public static Set<Integer> recursiveActivitySelector(int[] startTime, int[] finishTime, int k, int n){
			int m = k + 1;
			while(m <= n && startTime[m] < finishTime[k])
				m = m + 1;
			Set<Integer> result = new HashSet<>();
			if( m <= n) {
				result = recursiveActivitySelector(startTime, finishTime, m, n);
				result.add(m);
			}
			else{
				result.add(0);
			}
			return result;
		}

		public static Set<Integer> greedyActivitySelector(int[] startTime, int[] finishTime){
			Set<Integer> result = new HashSet<>();
			int n = startTime.length;
			result.add(0);
			int k = 0, m = 1;
			while( m < n){
				if( startTime[m] >= finishTime[k]){
					result.add(m);
					k = m;
				}
				m++;
			}
			return result;
		}
	}

	public static void main(String[] args){
		// test ActivitySelectionProblem
		int[] startTime = new int[]{1,3,0,5,3,5,6,8,8,2,
				12};
		int[] finishTime = new int[]{4,5,6,7,9,9,10,11,12
				,14,16};
		Set<Integer> result =
				ActivitySelectionProblem.greedyActivitySelector(startTime,
						finishTime);
		System.out.println(result);
	}
}
