package com.java.adawang.MustHaveKnowledge.DataStructures;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class ArraysStrings {
	static class IsUnique{
		//Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
		public boolean isUnique(String s){
			HashSet<Character> set = new HashSet<>();
			for(Character c : s.toCharArray()){
				if(!set.add(c)){
					return false;
				}
			}
			return true;
		}

		public static boolean isUniqueChars(String s){
			int checker = 0;
			for(char c : s.toCharArray()){
				int val = c - 'a';
				int flag = checker & (1 << val);
				if(flag > 0){
					return false;
				}
				checker |= (1 << val);
			}
			return true;
		}
	}

	@Test
	public void isUniqueTest(){
//		System.out.println(IsUnique.isUniqueChars("abcda"));
		int val = 0;
		int b = 1 << val;
		System.out.println(b);
	}
}
