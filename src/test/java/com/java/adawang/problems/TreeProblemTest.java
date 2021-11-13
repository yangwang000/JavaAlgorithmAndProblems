package com.java.adawang.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TreeProblemTest {
	@Test
	void testMyCalender(){
		TreeProblems.MyCalendar myCalendar =
				new TreeProblems.MyCalendar();
		System.out.println(myCalendar.book(10, 20));
		System.out.println(myCalendar.book(15, 25));
		System.out.println(myCalendar.book(20, 30));
	}
}
