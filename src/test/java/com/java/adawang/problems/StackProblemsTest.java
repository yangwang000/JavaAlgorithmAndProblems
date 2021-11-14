package com.java.adawang.problems;

import org.testng.annotations.Test;

public class StackProblemsTest {
	@Test
	void testStackWithIncrement(){
		StackProblems.StackWithIncrement myStack =
				new StackProblems.StackWithIncrement(3);
		myStack.push(1);
		myStack.push(2);
		System.out.println(myStack.pop());
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.increment(5, 100);
		myStack.increment(2, 100);
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}
}
