package com.java.adawang.MustHaveKnowledge.DataStructures;

import com.java.adawang.MustHaveKnowledge.Algorithms.Backtracking.Combinations;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class ArraysStrings {
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
		Combinations comb = new Combinations();
		List<String> strings = comb.stringGenerator();
		System.out.println(strings.size());

		long start, end;
		boolean setRes = false;
		IsUnique isUnique = new IsUnique();
		start = System.currentTimeMillis();
		for(String s : strings){
			setRes = isUnique.isUniqueSet(s);
		}
		end = System.currentTimeMillis();
		System.out.println(setRes+ " " + (end-start));

		start = System.currentTimeMillis();
		for(String s : strings){
			setRes = isUnique.isUniqueChars(s);
		}
		end = System.currentTimeMillis();
		System.out.println(setRes+ " " + (end-start));
	}

	class CheckPermutation{
		//Given two strings, write a method to decide if one is a permutation of the other.
		// Case sensitive and whitespace is significant
		// so "God  " is different from "dog"
		String sort(String s){
			char[] content = s.toCharArray();
			java.util.Arrays.sort(content);
			return new String(content);
		}

		public boolean checkPermutationBySorting(String s
				, String t){
			if(s.length() != t.length())
				return false;
			return sort(s).equals(sort(t));
		}

		public boolean checkPermutationByCharset(String s
				, String t){
			if(s.length() != t.length())
				return false;

			// letters array`s length depends on ASCII or
			// Unicode
			int[] letters = new int[128];
			for(char c : s.toCharArray()){
				letters[c]++;
			}

			for(int i=0; i < t.length(); i++){
				int c = (int) t.charAt(i);
				letters[c]--;
				if(letters[c] < 0)
					return false;
			}
			return true;
		}
	}

	class CheckPalindromePermutation{
		// Given a string, write a function to check if
		// it is a permutation of a palindrome. "Tact
		// Coa" will return true.
		public boolean checkByOddCounts(String s){
			int countOdd = 0;
			int[] charTable =
					new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
			for(char c : s.toCharArray()){
				int x = getCharNumber(c);
				if(x != -1){
					charTable[x]++;
					if(charTable[x]%2 == 1)
						countOdd++;
					else
						countOdd--;
				}
			}
			return countOdd <= 1;
		}

		int getCharNumber(Character c){
			int a = Character.getNumericValue('a');
			int z = Character.getNumericValue('z');
			int val = Character.getNumericValue(c);
			if(a <= val && val <= z){
				return val - a;
			}
			return -1;
		}

		public boolean checkByBitVector(String s){
			int bitVector = creatBitVector(s);
			return checkExactlyOneBitSet(bitVector);
		}

		int creatBitVector(String s){
			int bitVector = 0;
			for(char c : s.toCharArray()){
				int x = getCharNumber(c);
				bitVector = toggle(bitVector, x);
			}
			return bitVector;
		}

		int toggle(int bitVector, int index){
			if (index < 0) return bitVector;

			int mask = 1 << index;
			if((bitVector & mask) == 0)
				bitVector |= mask;
			else
				bitVector &= ~mask;
			return bitVector;
		}

		boolean checkExactlyOneBitSet(int bitVector){
			return ((bitVector - 1) & bitVector) == 0;
		}
	}
}
