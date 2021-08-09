package com.java.adawang.problems;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.java.adawang.problems.StringProblems;

public class StringProblemsTest {
	class LongestPalindromeTestData{
		String input;
		String output;
	}

	@Test
	void testLongestPalindrome(){
		LongestPalindromeTestData testData0 =
				new LongestPalindromeTestData();
		testData0.input = "babad";
		testData0.output = "bab";
		StringProblems.LongestPalindrome longestPalindrome = new StringProblems.LongestPalindrome();
		Assert.assertEquals(longestPalindrome.longestPalindrome(testData0.input), testData0.output);
	}
}
