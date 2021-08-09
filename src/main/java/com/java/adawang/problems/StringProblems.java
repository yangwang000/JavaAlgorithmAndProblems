package com.java.adawang.problems;

import java.util.HashSet;

public class StringProblems {
	/*
	* Given a string s, find the length of the longest
	* substring without repeating characters.
	* #3 Medium
	* */
	static class LengthOfLongestSubstring{
		public int lengthOfLongestSubstring(String s) {
			int maxLength = 0;
			int start = 0;
			int end = 0;
			HashSet longestSubstring = new HashSet();
			while(end < s.length()){
				if(longestSubstring.add(s.charAt(end))){
					end ++;
					maxLength = Math.max(maxLength,
							longestSubstring.size());
				}else{
					longestSubstring.remove(s.charAt(start));
					start++;
				}
			}
			return maxLength;
		}
	}

	/* #5 Longest Palindromic Substring

	* Given a string s, return the longest palindromic substring in s.
	*Example 1:
	Input: s = "babad"
	Output: "bab"
	Note: "aba" is also a valid answer.

	* Example 2:
	Input: s = "cbbd"
	Output: "bb"

	* Example 3:
	Input: s = "a"
	Output: "a"

	* Example 4:
	Input: s = "ac"
	Output: "a"
	*
	* Approach 3: Dynamic Programming
	* To improve over the brute force solution, we first observe how we can avoid unnecessary re-computation while validating palindromes.
	* Consider the case "ababa". If we already knew that "bab" is a palindrome,
	* it is obvious that "ababa" must be a palindrome since the two left and right end letters are the same.
	*
	* We define P(i,j) as following:
	* P(i,j) = true, if the substring Si...Sj is a
	* palindrome.
	* P(i,j) = false, otherwise.
	*
	* Therefore P(i,j) = (P(i+1, j-1) and Si==Sj)
	*
	* The base cases are:
	* P(i,i) = true
	* P(i, i+1) = (Si==Si+1)
	*
	* This yields a straight forward DP solution, which we first initialize the one and two letters palindromes,
	* and work our way up finding all three letters palindromes, and so on...

	Approach 5: Manacher's Algorithm
	There is even an O(n) algorithm called Manacher's algorithm.
	However, it is a non-trivial algorithm, and no one expects you to come up with this algorithm in a 45 minutes coding session.
	But, please go ahead and understand it, I promise it will be a lot of fun.
	* */
	static class LongestPalindrome{
		/*
		** Approach 4: Expand Around Center
		 * We observe that a palindrome mirrors around its center.
		 * Therefore, a palindrome can be expanded from its center, and there are only 2n−1 such centers.
		 * You might be asking why there are 2n - 1 but not n centers? The reason is the center of a palindrome can be in between two letters.
		 * Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
		* */
		String longestPalindrome(String s){
			if(s==null || s.length()<1) return "";
			int start = 0, end = 0;
			for(int i=0; i<s.length(); i++){
				int len1 = expendAroundCenter(s, i, i);
				int len2 = expendAroundCenter(s, i, i+1);
				int len = Math.max(len1, len2);
				if(len > end - start + 1){
					start = i - (len-1)/2;
					end = i + len/2;
				}
			}
			return s.substring(start, end+1);
		}

		private int expendAroundCenter(String s,
										int leftIndex,
										int rightIndex){
			while (leftIndex >=0 && rightIndex < s.length() && s.charAt(leftIndex)==s.charAt(rightIndex)){
				leftIndex--;
				rightIndex++;
			}
			return rightIndex - leftIndex - 1;
		}
	}

	/*
	* #6 ZigZag Conversion
	* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
	*  (you may want to display this pattern in a fixed font for better legibility)
		P   A   H   N
		A P L S I I G
		Y   I   R
		And then read line by line: "PAHNAPLSIIGYIR"
	* */
	static class ZigZagConversion{
		public String convert(String s, int numRows) {
			String[] resultArray = new String[numRows];
			for(int i = 0; i < numRows; i++){
				resultArray[i] = "";
			}
			if(numRows == 1) return s;
			for(int i = 0; i < s.length(); i++){
				int zigNum = numRows*2 - 2;
				int zigIndex = i % zigNum;
				if(zigIndex < numRows){
					resultArray[zigIndex] =
							resultArray[zigIndex] + s.charAt(i);
				}else {
					resultArray[zigNum-zigIndex] =
							resultArray[zigNum-zigIndex] + s.charAt(i);
				}
			}

			String resultString = "";
			for(int i = 0; i < numRows; i++){
				resultString =
						resultString + resultArray[i];
			}
			return resultString;
		}

		public String convert1(String s, int numRows) {
			if(numRows == 1) return s;

			int singleZipNum = numRows*2 - 2;
			int loop = s.length() / singleZipNum;
			String resultString = "";
			for(int i = 0; i < numRows; i++){
				int j = i;
				if(j == 0 || j == (numRows-1)){
					while(j < s.length()){
						resultString =
								resultString + s.charAt(j);
						j = j + singleZipNum;
					}
				}else {
					int gapParam = numRows - i -1;
					while (j < s.length()){
						int gap = j + gapParam*2;
						resultString =
								resultString + s.charAt(j);
						if(gap < s.length()){
							resultString =
									resultString + s.charAt(gap);
						}
						j = j + singleZipNum;
					}
				}
			}
			return resultString;
		}

		public String convert2(String s, int numRows) {
			if(numRows == 1) return s;

			int singleZipNum = numRows*2 - 2;
			int n = s.length();
			StringBuilder resultString =
					new StringBuilder();
			for(int i = 0; i < numRows; i++){
				for (int j = 0; j+i < n; j += singleZipNum){
					resultString.append(s.charAt(j+i));
					if(i != 0 && i != (numRows-1) && (j+singleZipNum-i) < n){
						resultString.append(s.charAt(j+singleZipNum-i));
					}
				}
			}
			return resultString.toString();
		}
	}
}
