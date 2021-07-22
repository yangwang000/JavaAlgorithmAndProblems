package com.java.adawang.problems;

import com.java.adawang.problems.utils.ListNode;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.java.adawang.problems.LinkedList;

public class LinkedListTest {
	class AddTwoNumbersTestData{
		ListNode l1;
		ListNode l2;
		ListNode output;
	}

	@Test
	void testAddTwoNumbers(){
		AddTwoNumbersTestData testData0 =
				new AddTwoNumbersTestData();
		testData0.l1 = new ListNode(2);
		testData0.l1.next = new ListNode(4);
		testData0.l1.next.next = new ListNode(3);
		testData0.l2 = new ListNode(5);
		testData0.l2.next = new ListNode(6);
		testData0.l2.next.next = new ListNode(4);
		testData0.output = new ListNode(7);
		testData0.output.next = new ListNode(0);
		testData0.output.next.next = new ListNode(8);
		LinkedList.AddTwoNumbers addTwoNumbers =
				new LinkedList.AddTwoNumbers();
		ListNode sum =
				addTwoNumbers.addTwoNumbers(testData0.l1,
				testData0.l2);
		while (testData0.output != null && sum !=null){
			Assert.assertEquals(testData0.output.val,
					sum.val);
			testData0.output = testData0.output.next;
			sum = sum.next;
		}
	}
}
