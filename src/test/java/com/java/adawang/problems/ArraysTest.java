package com.java.adawang.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArraysTest {
	class FindMedianSortedArraysTestData{
		int[] nums1;
		int[] nums2;
		double output;
	}
	@Test
	void testFindMedianSortedArrays(){
		FindMedianSortedArraysTestData testData0 =
				new FindMedianSortedArraysTestData();
		testData0.nums1 = new int[] {1,3};
		testData0.nums2 = new int[] {2};
		testData0.output = 2.0;
		ArrayProblems.MedianOfTwoSortedArrays testClass =
				new ArrayProblems.MedianOfTwoSortedArrays();
		Assert.assertEquals(testClass.findMedianSortedArrays(testData0.nums1, testData0.nums2), testData0.output);

		FindMedianSortedArraysTestData testData1 =
				new FindMedianSortedArraysTestData();
		testData1.nums1 = new int[] {1,2};
		testData1.nums2 = new int[] {3,4};
		testData1.output = 2.5;
		Assert.assertEquals(testClass.findMedianSortedArrays(testData1.nums1, testData1.nums2), testData1.output);

		FindMedianSortedArraysTestData testData2 =
				new FindMedianSortedArraysTestData();
		testData2.nums1 = new int[] {0};
		testData2.nums2 = new int[] {0};
		testData2.output = 0;
		Assert.assertEquals(testClass.findMedianSortedArrays(testData2.nums1, testData2.nums2), testData2.output);

		FindMedianSortedArraysTestData testData3 =
				new FindMedianSortedArraysTestData();
		testData3.nums1 = new int[] {};
		testData3.nums2 = new int[] {1};
		testData3.output = 1;
		Assert.assertEquals(testClass.findMedianSortedArrays(testData3.nums1, testData3.nums2), testData3.output);
	}

	class ZigZagConversionTestData{
		String input;
		int numRows;
		String output;
	}

	@Test
	void testZigZagConversion(){
		ZigZagConversionTestData testData0 =
				new ZigZagConversionTestData();
		testData0.input = "PAYPALISHIRING";
		testData0.numRows = 4;
		testData0.output = "PINALSIGYAHRPI";

		StringProblems.ZigZagConversion zigZagConversion =
				new StringProblems.ZigZagConversion();
		Assert.assertEquals(zigZagConversion.convert2(testData0.input, testData0.numRows), testData0.output);
	}

	@Test
	void testMaximumPopulationYear(){
		int[][] input = new int[][]{{1950,1961},{1960,
				1971},{1970,1981}};
		System.out.println(ArrayProblems.MaximumPopulationYear.maximumPopulation(input));
	}

	@Test
	void testMissingElementInSortedArray(){
		int[] inputArr = new int[]{4,7,9,10};
		int k = 1;
		k = 3;
		ArrayProblems.MissingElementInSortedArray missingEle = new ArrayProblems.MissingElementInSortedArray();
		System.out.println(missingEle.missingElementBinarySearch(inputArr,k));
	}

	@Test
	void testVerifyingAnAlienDictionary(){
		String[] words = new String[]{"word", "world",
				"row"};
		String order = "worldabcefghijkmnpqstuvxyz";
		ArrayProblems.VerifyingAnAlienDictionary vad =
				new ArrayProblems.VerifyingAnAlienDictionary();
		System.out.println(vad.isAlienSorted(words, order));
	}

	@Test
	void testStockPrice(){
		int[] prices = new int[]{100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
		ArrayProblems.StockPrice stockPrice =
				new ArrayProblems.StockPrice();
		System.out.println(stockPrice.onePass(prices));
	}
}
