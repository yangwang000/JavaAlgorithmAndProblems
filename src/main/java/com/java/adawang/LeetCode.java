package com.java.adawang;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class LeetCode {

	class Solution {
		List<String> output = new ArrayList<>();
		String input;

		private void backtrack(StringBuilder sb, int i){
			if(sb.length() == input.length())
				output.add(sb.toString());

			if(i >= input.length())
				return;

			char c = input.charAt(i);
			sb.append(c);
			backtrack(sb, i+1);
			sb.deleteCharAt(sb.length()-1);

			if(!Character.isDigit(c)){
				sb.append(Character.toUpperCase(c));
				backtrack(sb, i+1);
				sb.deleteCharAt(sb.length()-1);
			}
		}

		public List<String> letterCasePermutation(String s) {
			input = s.toLowerCase();
			backtrack(new StringBuilder(), 0);
			return output;
		}
	}

	@Test
	public void whenExceptionThrown_thenAssertionSucceeds() {
		Solution s = new Solution();
		List<String> ans = s.letterCasePermutation("a1b2");
		System.out.println(ans);
	}
}
