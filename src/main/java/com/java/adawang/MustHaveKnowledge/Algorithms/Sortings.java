package com.java.adawang.MustHaveKnowledge.Algorithms;

import org.junit.Test;

public class Sortings {
	public void insertionSort(int[] a){
		int l = a.length;
		for(int i=1; i < a.length; i++){
			int key = a[i];
			int j = i - 1;
			while(j >= 0 && a[j] > key){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void mergeSort(int arr[], int l, int r)
	{
		if (l < r) {
			// Find the middle point
			int m =l+ (r-l)/2;

			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	@Test
	public void test(){
		int[] array = {12,13,11,5,6,7};
		mergeSort(array, 0, array.length -1);
		for(int i : array){
			System.out.print(i + " ");
		}
	}

}
