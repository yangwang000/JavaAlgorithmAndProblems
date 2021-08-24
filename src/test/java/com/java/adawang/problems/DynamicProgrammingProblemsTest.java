package com.java.adawang.problems;

import com.java.adawang.problems.DynamicProgrammingProblems;
import org.testng.Assert;

public class DynamicProgrammingProblemsTest {
	class RegularExpressionMatchingTestData{
		String patter;
		String text;
		boolean output;
	}

	void testRegularExpressionMatching(){
		RegularExpressionMatchingTestData testData =
				new RegularExpressionMatchingTestData();
//		["aa", "a", false]
//		["aa", "a*", true]
//		["ab", ".*", true]
//		["aab", "c*a*b", true]
//		["mississippi", "mis*is*p*.", false]
//		["aaa", "ab*a*c*a", false]
//		["aaa", "a*a", false]
		testData.patter = "a";
		testData.text = "aa";
		testData.output = false;

		DynamicProgrammingProblems.RegularExpressionMatching testClass =
				new DynamicProgrammingProblems.RegularExpressionMatching();
		Assert.assertEquals(testClass.isMatchTopDown(testData.text, testData.patter), testData.output);
	}
}
