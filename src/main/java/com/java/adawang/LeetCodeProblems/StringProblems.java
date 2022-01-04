package com.java.adawang.LeetCodeProblems;

import java.util.*;

public class StringProblems {
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
	}

	static class FileCreation{
		public String[] creatFiles(String[] input){
			List<String> res = new ArrayList<>();
			for(int i = 0; i < input.length; i++){
				String inputFile = input[i];
				if(res.contains(inputFile)){
					String tempFile = inputFile+"(1)";
					int index = 1;
					while(res.contains(tempFile)){
						index++;
						tempFile = inputFile+"("+index+")";
					}
					res.add(tempFile);
				}else {
					res.add(inputFile);
				}
			}
			String[] resArray = new String[res.size()];
			res.toArray(resArray);
			return resArray;
		}
	}
}
