package com.java.adawang.LeetCodeProblems;

import java.util.Arrays;

public class SortingProblems {
	/* Insertion sort is efficient for sorting small
	number of elements*/
	public static int[] insertionSort(int[] inputArray){
		for(int i = 1; i < inputArray.length; i++){
			int currentKey = inputArray[i];
			int j = i - 1;
			while ( j > -1 && inputArray[j] > currentKey){
				inputArray[j+1] = inputArray[j];
				j -= 1;
			}
			inputArray[j+1] = currentKey;
		}
		return inputArray;
	}

	public static void main(String[] args){
		int[] a = {5,2,4,6,1,3};
		int[] b = insertionSort(a);
		System.out.println(Arrays.toString(b));
	}
}
