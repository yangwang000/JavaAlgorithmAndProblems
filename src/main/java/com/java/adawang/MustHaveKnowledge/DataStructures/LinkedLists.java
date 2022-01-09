package com.java.adawang.MustHaveKnowledge.DataStructures;

import com.java.adawang.LeetCodeProblems.utils.ListNode;

public class LinkedLists {
	class LoopDetection{
		//Given a circular linked list, implement an
		//algorithm that returns the node at the
		//beginning of the loop.
		//Input: a-b-c-d-e-c
		//Output: c
		ListNode findBeginning(ListNode head){
			ListNode slow = head;
			ListNode fast = head;
			while(slow != null && fast != null){
				if(slow == fast){
					break;
				}
				slow = slow.next;
				fast = fast.next.next;
			}

			if(fast == null || fast.next == null)
				return null;

			slow = head;
			while(slow != fast){
				slow = slow.next;
				fast = fast.next;
			}
			return fast;
		}
	}
}
