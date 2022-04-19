package com.java.adawang;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode {
	public static void main (String[] args){
		System.out.println(print(-1));
	}
	static Exception print(int i){
		if (i>0) {
			return new Exception();
		} else {
			throw new RuntimeException();
		}
	}


	@Test
	public void test(){
		if('Z' < 'a'){
			System.out.print('A');
		}
	}
}