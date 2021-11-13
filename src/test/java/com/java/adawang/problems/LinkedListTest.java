package com.java.adawang.problems;

import com.java.adawang.problems.utils.ListNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
		LinkedListProblems.AddTwoNumbers addTwoNumbers =
				new LinkedListProblems.AddTwoNumbers();
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

	@Test
	void testMergeKSortedLists(){
		LinkedListProblems.MergekSortedLists mergekSortedLists =
				new LinkedListProblems.MergekSortedLists();
		ListNode list0 = new ListNode(1);
		list0.next = new ListNode(4);
		list0.next.next = new ListNode(5);

		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(3);
		list1.next.next = new ListNode(4);

		ListNode list2 = new ListNode(2);
		list2.next = new ListNode(6);

		ListNode[] input = new ListNode[]{list0,list1,
				list2};
		ListNode ouput =
				mergekSortedLists.mergeKLists(input);
		while (ouput != null){
			System.out.print(ouput.val);
			ouput = ouput.next;
		}
	}

	@Test
	void testCombinationSum(){
		LinkedListProblems.CombinationSum combinationSum
				= new LinkedListProblems.CombinationSum();
		int[] input = new int[]{2,3,5};
		int target = 8;
		List<List<Integer>> res =
				combinationSum.combinationSum(input,
						target);
		System.out.println(res.toString());
	}
}
