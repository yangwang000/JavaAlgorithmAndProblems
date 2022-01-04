package com.java.adawang.ClassicAlgorithms;

import com.java.adawang.LeetCodeProblems.utils.ListNode;

// # 141
public class FloydCycleFindingAlgorithm {
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
}
