package com.java.adawang.problems;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.java.adawang.problems.StringProblems;

import java.util.List;

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
		StringProblems.LongestPalindromicSubstring longestPalindrome = new StringProblems.LongestPalindromicSubstring();
		Assert.assertEquals(longestPalindrome.longestPalindrome(testData0.input), testData0.output);
	}

	class StringToIntegerTestData{
		String input;
		int output;
	}

	@Test
	void testStringToInteger(){
		StringToIntegerTestData testData0 =
				new StringToIntegerTestData();
		testData0.input = "42";
		testData0.output = 42;

		StringToIntegerTestData testData1 =
				new StringToIntegerTestData();
		testData1.input = "   -42";
		testData1.output = -42;

		StringToIntegerTestData testData2 =
				new StringToIntegerTestData();
		testData2.input = "4193 with words";
		testData2.output = 4193;

		StringToIntegerTestData testData3 =
				new StringToIntegerTestData();
		testData3.input = "words and 987";
		testData3.output = 0;

		StringToIntegerTestData testData4 =
				new StringToIntegerTestData();
		testData4.input = "-91283472332";
		testData4.output = -2147483648;

		StringToIntegerTestData testData5 =
				new StringToIntegerTestData();
		testData5.input = "+-12";
		testData5.output = 0;

		StringToIntegerTestData testData6 =
				new StringToIntegerTestData();
		testData6.input = "+1";
		testData6.output = 1;

		StringToIntegerTestData testData7 =
				new StringToIntegerTestData();
		testData7.input = "21474836460";
		testData7.output = 2147483647;

		StringToIntegerTestData testData8 =
				new StringToIntegerTestData();
		testData8.input = "00000-42a1234";
		testData8.output = 0;

		StringToIntegerTestData testData9 =
				new StringToIntegerTestData();
		testData9.input = "   +0 123";
		testData9.output = 0;

		StringToIntegerTestData testData10 =
				new StringToIntegerTestData();
		testData10.input = "2147483647";
		testData10.output =
				2147483647;

		StringToIntegerTestData testData11 =
				new StringToIntegerTestData();
		testData11.input = "  +  413";
		testData11.output = 0;

		StringToIntegerTestData testData12 =
				new StringToIntegerTestData();
		testData12.input = "++1";
		testData12.output = 0;

		StringProblems.StringToInteger stringToInteger =
				new StringProblems.StringToInteger();
		Assert.assertEquals(stringToInteger.myAtoi(testData12.input), testData12.output);
	}

	@Test
	void testLetterCombinationsofPhoneNumber(){
		// test Letter Combinations of a Phone Number
		String input = "23";
		List<String> output =
				StringProblems.LetterCombinationsofPhoneNumber.letterCombinations(input);
		System.out.print(output);
	}
}
