package com.java.adawang.MustHaveKnowledge.DataStructures;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class ArraysStrings {
	class IsUnique{
		//Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
		public boolean isUniqueSet(String s){
			HashSet<Character> set = new HashSet<>();
			for(Character c : s.toCharArray()){
				if(!set.add(c)){
					return false;
				}
			}
			return true;
		}

		public boolean isUniqueChars(String s){
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
		String testInput0 = "abcdefghijklmnopqrstuvwxyz";
		String testInput1 = "abcdef";
		String testInput2 = "1234567890";
		String testInput3 = "~!@#$%^&*()_+";
		String testInput = testInput0;

		long start, end;
		boolean setRes;
		IsUnique isUnique = new IsUnique();
		start = System.currentTimeMillis();
		setRes = isUnique.isUniqueSet(testInput);
		end = System.currentTimeMillis();
		System.out.println(setRes+ " " + (end-start));

		start = System.currentTimeMillis();
		setRes = isUnique.isUniqueChars(testInput);
		end = System.currentTimeMillis();
		System.out.println(setRes+ " " + (end-start));
	}
}
