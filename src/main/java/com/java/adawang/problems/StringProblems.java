package com.java.adawang.problems;

import java.util.*;

public class StringProblems {
	static class LetterCombinationsofPhoneNumber{
		private static List<String> combinations =
				new ArrayList<>();
		private static Map<Character, String> letters = Map.of(
				'2', "abc", '3', "def", '4', "ghi", '5', "jkl",
				'6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
		private static String phoneDigits;

		public static List<String> letterCombinations(String digits) {
			// If the input is empty, immediately return an empty answer array
			if (digits.length() == 0) {
				return combinations;
			}

			// Initiate backtracking with an empty path and starting index of 0
			phoneDigits = digits;
			backtrack(0, new StringBuilder());
			return combinations;
		}

		private static void backtrack(int index,
								StringBuilder path) {
			// If the path is the same length as digits, we have a complete combination
			if (path.length() == phoneDigits.length()) {
				combinations.add(path.toString());
				return; // Backtrack
			}

			// Get the letters that the current digit maps to, and loop through them
			String possibleLetters = letters.get(phoneDigits.charAt(index));
			for (char letter: possibleLetters.toCharArray()) {
				// Add the letter to our current path
				path.append(letter);
				// Move on to the next digit
				backtrack(index + 1, path);
				// Backtrack by removing the letter before moving onto the next
				path.deleteCharAt(path.length() - 1);
			}
		}
	}
	static class LongestPalindromicSubstring{
		public static String longestPalindrome(String s) {
			if (s == null || s.length() < 1) return "";
			int start = 0, end = 0;
			for (int i = 0; i < s.length(); i++) {
				int len1 = expandAroundCenter(s, i, i);
				int len2 = expandAroundCenter(s, i, i + 1);
				int len = Math.max(len1, len2);
				if (len > end - start) {
					start = i - (len - 1) / 2;
					end = i + len / 2;
				}
			}
			return s.substring(start, end + 1);
		}

		private static int expandAroundCenter(String s,
										int left, int right) {
			int L = left, R = right;
			while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
				L--;
				R++;
			}
			return R - L - 1;
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

	/* #8 String to Integer (atoi)
	* */
	static class StringToInteger{
		public int myAtoi0(String str) {
			if (str.isEmpty()) return 0;
			int sign = 1, base = 0, i = 0;
			while (i < str.length() && str.charAt(i) == ' ')
				i++;
			if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+'))
				sign = str.charAt(i++) == '-' ? -1 : 1;
			while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
					return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				base = 10 * base + (str.charAt(i++) - '0');
			}
			return base * sign;
		}

		public int myAtoi(String s) {
			Integer resInteger = null;
			int sign = 0;
			for(int i = 0; i < s.length(); i++){
				char temp = s.charAt(i);
				if(temp == ' '){
					if(resInteger == null && sign == 0) continue;
					else break;
				}else if(temp == '+'){
					if(resInteger != null) break;
					else if(sign != 0) break;
					else sign = 1;
				}else if(temp == '-') {
					if(resInteger != null) break;
					else if(sign != 0) break;
					else sign = -1;
				}else if(Character.isDigit(temp)){
					int tempInt =
							Character.getNumericValue(temp);
					if(resInteger == null) {
						resInteger = tempInt;
						continue;
					}
					if(sign > -1){
						if(resInteger > Integer.MAX_VALUE/10){
							return  Integer.MAX_VALUE;
						}else if(resInteger == Integer.MAX_VALUE/10){
							if(tempInt < 7) resInteger = resInteger*10 + tempInt;
							else return Integer.MAX_VALUE;
						}else {
							resInteger =
									resInteger*10 + tempInt;
						}
					}else {
						int nResInteger = resInteger*sign;
						if(nResInteger < Integer.MIN_VALUE/10){
							return Integer.MIN_VALUE;
						}else if(nResInteger == Integer.MIN_VALUE/10){
							if(tempInt < 8) resInteger =
									resInteger*10 + tempInt;
							else return Integer.MIN_VALUE;
						}else {
							resInteger =
									resInteger*10 + tempInt;
						}
					}
				}else {
					break;
				}
			}
			if(resInteger==null) return 0;
			else if(sign == 0) return resInteger;
			else return resInteger*sign;
		}
	}

	static class LongestSubstringWithoutRepeatingCharacters{
		public static int slidingWindow(String s) {
			int[] chars = new int[128];

			int left = 0;
			int right = 0;

			int res = 0;
			while (right < s.length()) {
				char r = s.charAt(right);
				chars[r]++;

				while (chars[r] > 1) {
					char l = s.charAt(left);
					chars[l]--;
					left++;
				}

				res = Math.max(res, right - left + 1);

				right++;
			}
			return res;
		}
		public static int hashMapSlidingWindow(String s) {
			int n = s.length(), ans = 0;
			Map<Character, Integer> map = new HashMap<>(); // current index of character
			// try to extend the range [i, j]
			for (int j = 0, i = 0; j < n; j++) {
				if (map.containsKey(s.charAt(j))) {
					i = Math.max(map.get(s.charAt(j)), i);
				}
				ans = Math.max(ans, j - i + 1);
				map.put(s.charAt(j), j + 1);
			}
			return ans;
		}
		public static int slidingWindowOptimized(String s) {
			Integer[] chars = new Integer[128];

			int left = 0;
			int right = 0;

			int res = 0;
			while (right < s.length()) {
				char r = s.charAt(right);

				Integer index = chars[r];
				if (index != null && index >= left && index < right) {
					left = index + 1;
				}

				res = Math.max(res, right - left + 1);

				chars[r] = right;
				right++;
			}

			return res;
		}
	}

	static class ValidParentheses{
		// Hash table that takes care of the mappings.
		private HashMap<Character, Character> mappings;

		// Initialize hash map with mappings. This simply makes the code easier to read.
		public void Solution() {
			this.mappings = new HashMap<Character, Character>();
			this.mappings.put(')', '(');
			this.mappings.put('}', '{');
			this.mappings.put(']', '[');
		}

		public boolean isValid(String s) {

			// Initialize a stack to be used in the algorithm.
			Stack<Character> stack = new Stack<Character>();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				// If the current character is a closing bracket.
				if (this.mappings.containsKey(c)) {

					// Get the top element of the stack. If the stack is empty, set a dummy value of '#'
					char topElement = stack.empty() ? '#' : stack.pop();

					// If the mapping for this bracket doesn't match the stack's top element, return false.
					if (topElement != this.mappings.get(c)) {
						return false;
					}
				} else {
					// If it was an opening bracket, push to the stack.
					stack.push(c);
				}
			}

			// If the stack still contains elements, then it is an invalid expression.
			return stack.isEmpty();
		}
	}

	public static void main(String[] args){
		// test Letter Combinations of a Phone Number
		String input = "23";
		List<String> output =
				LetterCombinationsofPhoneNumber.letterCombinations(input);
		System.out.print(output);

//		// test LengthOfLongestSubstring
//		String input = "abcabcbb"; //output 3
//		int output =
//				LongestSubstringWithoutRepeatingCharacters.slidingWindowOptimized(input);
	}
}
