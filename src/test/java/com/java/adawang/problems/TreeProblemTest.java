package com.java.adawang.problems;

import com.java.adawang.problems.utils.TreeNode;
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

	@Test
	void testPrintBinaryTree(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		TreeProblems.PrintBinaryTree printBinaryTree =
				new TreeProblems.PrintBinaryTree();
		System.out.println(printBinaryTree.printTree(root).toString());
	}
}
