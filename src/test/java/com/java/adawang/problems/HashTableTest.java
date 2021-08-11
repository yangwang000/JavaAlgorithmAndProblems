package com.java.adawang.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HashTableTest {
	class TwoSumTestData{
		int[] input;
		int target;
		int[] output;
	}
	@Test
	void setup(){
		System.out.println("setup");
	}

	@Test
	void testTwoSum(){
		HashmapHashset.TwoSum twoSum = new HashmapHashset.TwoSum();
		TwoSumTestData testData0 = new TwoSumTestData();
		testData0.input = new int[] {2,7,11,15};
		testData0.output = new int[] {0,1};
		testData0.target = 9;
		Assert.assertEquals( twoSum.twoSum(testData0.input, testData0.target),
				testData0.output);

		TwoSumTestData testData1= new TwoSumTestData();
		testData1.input = new int[] {3,2,4};
		testData1.target = 6;
		testData1.output = new int[] {1,2};
		Assert.assertEquals(twoSum.twoSum(testData1.input
				, testData1.target), testData1.output);

		TwoSumTestData testData2 = new TwoSumTestData();
		testData2.input = new int[] {3,3};
		testData2.target = 6;
		testData2.output = new int[] {0,1};
		Assert.assertEquals(twoSum.twoSum(testData2.input
				, testData2.target), testData2.output);
	}
}
