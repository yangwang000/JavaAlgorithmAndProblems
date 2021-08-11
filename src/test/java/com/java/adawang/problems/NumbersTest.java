package com.java.adawang.problems;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.java.adawang.problems.Numbers;

public class NumbersTest {
	class PalindromeNumberTestData{
		int input;
		boolean output;
	}

	@Test
	void isPalindromeTest(){
		/*
		* [121, true] [-121, false] [10,false] [0,true]
		* */
		PalindromeNumberTestData testData0 =
				new PalindromeNumberTestData();
		testData0.input = 0;
		testData0.output = true;

		Numbers.PalindromeNumber palindromeNumber =
				new Numbers.PalindromeNumber();
		Assert.assertEquals(palindromeNumber.isPalindrome(testData0.input), testData0.output);
	}
}
