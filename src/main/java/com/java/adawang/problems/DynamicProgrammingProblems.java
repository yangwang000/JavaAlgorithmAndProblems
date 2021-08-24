package com.java.adawang.problems;

public class DynamicProgrammingProblems {
	/*
	* #5 Longest Palindromic Substring
	* Given a string s, return the longest palindromic substring in s.
	*
	* Approach 2: Brute Force
	* The obvious brute force solution is to pick all
	* possible starting and ending positions for a
	* substring, and verify if it is a palindrome.
	* Complexity Analysis
	* Time complexity : O(n^3). Assume that n is the
	* length of the input string, there are a total of
	* Combanition(n,2) = n(n-1)/2 such substrings
	* (excluding the trivial solution where a character
	* itself is a palindrome). Since verifying each
	* substring takes O(n) time, the run time complexity
	* is O(n^3).
	* Space complexity : O(1)O(1).
	*
	* Approach 3: Dynamic Programming
	* To improve over the brute force solution, we first
	* observe how we can avoid unnecessary
	* re-computation while validating palindromes.
	* Consider the case "ababa". If we already knew that
	* "bab" is a palindrome, it is obvious that "ababa"
	* must be a palindrome since the two left and right
	* end letters are the same. We define P(i,j) as
	* following:
	* P(i,j)=true, if the substring Si...Sj is a palindrome
	* P(i,j)=false, otherwise
	* Therefore,
	* P(i,j)=(P(i+1,j-1) and Si==Sj)
	* The base cases are:
	* P(i,i)=true
	* P(i,i+1)=(Si==Si+1)
	* This yields a straight forward DP solution, which
	* we first initialize the one and two letters
	* palindromes, and work our way up finding all three letters palindromes, and so on...
	* Complexity Analysis
	* Time complexity : O(n^2)
	* Space complexity : O(n^2) It uses O(n^2) space to
	* store the table.
	* */
	static class LongestPalindromicSubstring{
		static void printSubStr(
				String str, int low, int high)
		{
			System.out.println(
					str.substring(
							low, high + 1));
		}

		static int longestPalSubstr(String str)
		{
			// get length of input string
			int n = str.length();

			// table[i][j] will be false if
			// substring str[i..j] is not palindrome.
			// Else table[i][j] will be true
			boolean table[][] = new boolean[n][n];

			// All substrings of length 1 are palindromes
			int maxLength = 1;
			for (int i = 0; i < n; ++i)
				table[i][i] = true;

			// check for sub-string of length 2.
			int start = 0;
			for (int i = 0; i < n - 1; ++i) {
				if (str.charAt(i) == str.charAt(i + 1)) {
					table[i][i + 1] = true;
					start = i;
					maxLength = 2;
				}
			}

			// Check for lengths greater than 2.
			// k is length of substring
			for (int k = 3; k <= n; ++k) {

				// Fix the starting index
				for (int i = 0; i < n - k + 1; ++i) {
					// Get the ending index of substring from
					// starting index i and length k
					int j = i + k - 1;

					// checking for sub-string from ith index to
					// jth index iff str.charAt(i+1) to
					// str.charAt(j-1) is a palindrome
					if (table[i + 1][j - 1]
							&& str.charAt(i) == str.charAt(j)) {
						table[i][j] = true;

						if (k > maxLength) {
							start = i;
							maxLength = k;
						}
					}
				}
			}
			System.out.print("Longest palindrome substring is; ");
			printSubStr(str, start,
					start + maxLength - 1);

			// return length of LPS
			return maxLength;
		}
	}

	/* #10 Regular Expression Matching
	* Given an input string s and a pattern p, implement
	* regular expression matching with support for '.'
	* and '*' where:'.' Matches any single character. '*'
	* Matches zero or more of the preceding element. The
	* matching should cover the entire input string (not partial).
	* */
	enum Result {
		TRUE, FALSE
	}
	static class RegularExpressionMatching{
		Result[][] memo;
		public boolean isMatchTopDown(String text,
								String pattern) {
			memo = new Result[text.length() + 1][pattern.length() + 1];
			return dp(0, 0, text, pattern);
		}
		public boolean dp(int i, int j, String text, String pattern) {
			if (memo[i][j] != null) {
				return memo[i][j] == Result.TRUE;
			}
			boolean ans;
			if (j == pattern.length()){
				ans = i == text.length();
			} else{
				boolean first_match = (i < text.length() &&
						(pattern.charAt(j) == text.charAt(i) ||
								pattern.charAt(j) == '.'));

				if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
					ans = (dp(i, j+2, text, pattern) ||
							first_match && dp(i+1, j, text, pattern));
				} else {
					ans = first_match && dp(i+1, j+1, text, pattern);
				}
			}
			memo[i][j] = ans ? Result.TRUE : Result.FALSE;
			return ans;
		}

		public boolean isMatchBottomUp(String text,
								String pattern) {
			boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
			dp[text.length()][pattern.length()] = true;

			for (int i = text.length(); i >= 0; i--){
				for (int j = pattern.length() - 1; j >= 0; j--){
					boolean first_match = (i < text.length() &&
							(pattern.charAt(j) == text.charAt(i) ||
									pattern.charAt(j) == '.'));
					if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
						dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
					} else {
						dp[i][j] = first_match && dp[i+1][j+1];
					}
				}
			}
			return dp[0][0];
		}
	}

	public static void main(String[] args){
		int key = 0;
		int[][] table = new int[2][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 2; j++){
				table[i][j] = key;
				System.out.println(key++);
			}
		}
	}
}
