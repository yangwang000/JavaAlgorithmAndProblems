package com.java.adawang.problems;

import com.java.adawang.problems.DynamicProgrammingProblems;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicProgrammingProblemsTest {
	class RegularExpressionMatchingTestData{
		String patter;
		String text;
		boolean output;
	}

	@Test
	void testRegularExpressionMatching(){
		RegularExpressionMatchingTestData testData =
				new RegularExpressionMatchingTestData();
//		["aa", "a", false]
//		["aa", "a*", true]
//		["ab", ".*", true]
//		["aab", "c*a*b", true]
//		["mississippi", "mis*is*p*.", false]
//		["aaa", "ab*a*c*a", true]
//		["aaa", "a*a", true]
		testData.patter = ".*";
		testData.text = "ab";
		testData.output = true;

		DynamicProgrammingProblems.RegularExpressionMatching testClass =
				new DynamicProgrammingProblems.RegularExpressionMatching();
		Assert.assertEquals(testClass.isMatchBottomUp1(testData.text, testData.patter), testData.output);
	}
}
