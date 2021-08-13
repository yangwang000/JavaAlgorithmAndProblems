package com.java.adawang.problems;

public class DynamicProgrammingProblems {
	/* #5 Longest Palindromic Substring
	* Given a string s, return the longest palindromic substring in s.
	* Approach 2: Brute Force
	* The obvious brute force solution is to pick all
	* possible starting and ending positions for a
	* substring, and verify if it is a palindrome.
	* Complexity Analysis
	* Time complexity : O(n^3). Assume that n is the
	* length of the input string, there are a total of \binom{n}{2} = \frac{n(n-1)}{2}(
2
n
​
 )=
2
n(n−1)
​
  such substrings (excluding the trivial solution where a character itself is a palindrome). Since verifying each substring takes O(n)O(n) time, the run time complexity is O(n^3)O(n
3
 ).

Space complexity : O(1)O(1).
	* Approach 3: Dynamic Programming
	* To improve over the brute force solution, we first
	 * observe how we can avoid unnecessary re-computation while validating palindromes. Consider the case "ababa". If we already knew that "bab" is a palindrome, it is obvious that "ababa" must be a palindrome since the two left and right end letters are the same.

We define P(i,j)P(i,j) as following:

P(i,j) = \begin{cases} \text{true,} &\quad\text{if the substring } S_i \dots S_j \text{ is a palindrome}\\ \text{false,} &\quad\text{otherwise.} \end{cases}P(i,j)={
true,
false,
​

if the substring S
i
​
 …S
j
​
  is a palindrome
otherwise.
​


Therefore,

P(i, j) = ( P(i+1, j-1) \text{ and } S_i == S_j )P(i,j)=(P(i+1,j−1) and S
i
​
 ==S
j
​
 )

The base cases are:

P(i, i) = trueP(i,i)=true

P(i, i+1) = ( S_i == S_{i+1} )P(i,i+1)=(S
i
​
 ==S
i+1
​
 )

This yields a straight forward DP solution, which we first initialize the one and two letters palindromes, and work our way up finding all three letters palindromes, and so on...

Complexity Analysis

Time complexity : O(n^2)O(n
2
 ). This gives us a runtime complexity of O(n^2)O(n
2
 ).

Space complexity : O(n^2)O(n
2
 ). It uses O(n^2)O(n
2
 ) space to store the table.

Additional Exercise

Could you improve the above space complexity further and how?
	* */
	static class LongestPalindromicSubstring{

	}
	/* #10 Regular Expression Matching
*  Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
* */
	static class RegularExpressionMatching{
	}
}
