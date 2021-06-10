package com.java.adawang.datastructure.UsingArrays;

public class ArraySort {
	public void insertionSort(char[] data){
		int n = data.length;
		for(int k=1; k<n; k++){
			char curr = data[k];
			int j=k;
			while(j>0 && data[j-1]>curr){
				data[j] = data[j-1];
				j--;
			}
			data[j]=curr;
		}
	}
}
