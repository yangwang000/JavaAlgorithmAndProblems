package com.java.adawang.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RecursionProblemsTest {
	class RegularExpressionMatchingTestData{
		String inputS;
		String inputP;
		boolean output;
	}

	@Test
	void regularExpressionMatchingTest(){
		RegularExpressionMatchingTestData testData =
				new RegularExpressionMatchingTestData();
		//["mississippi", "mis*is*p*.", false]
		//["aa", "a", false] ["aa", "a*", true]
		//["ab", ".*", true] ["aab", "c*a*b", true]
		//["aaa", "ab*a*c*a", true]
		testData.inputS = "aab";
		testData.inputP = "c*a*b";
		testData.output = true;

		RecursionProblems.RegularExpressionMatching regularExpressionMatching = new RecursionProblems.RegularExpressionMatching();
		Assert.assertEquals(regularExpressionMatching.isMatch(testData.inputS, testData.inputP), testData.output);
	}
}
