package com.java.adawang.problems;
import com.java.adawang.problems.utils.ListNode;

public class LinkedList {
	/*
	You are given two non-empty linked lists representing two non-negative integers.
	The digits are stored in reverse order, and each of their nodes contains a single digit.
	Add the two numbers and return the sum as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	#2 Medium

	hint : a dumbhead is useful
	*/
	static class AddTwoNumbers{
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			int carry = 0;
			ListNode dumbHead = new ListNode(0);
			ListNode curr = dumbHead;
			while(l1 != null || l2 != null){
				int x = (l1 != null) ? l1.val : 0;
				int y = (l2 != null) ? l2.val : 0;
				int sum = x + y + carry;
				carry = sum/10;
				curr.next = new ListNode(sum%10);
				curr = curr.next;
				if(l1 != null)
					l1 = l1.next;
				if(l2 != null)
					l2 = l2.next;
			}
			if(carry > 0)
				curr.next = new ListNode(carry);
			return dumbHead.next;
		}
	}
}
