package com.java.adawang.problems;
import com.java.adawang.problems.utils.ListNode;
import java.util.*;

public class LinkedListProblems {
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

	static class LRUCache extends LinkedHashMap<Integer,
		Integer> {
		private int capacity;

		public LRUCache(int capacity) {
			super(capacity, 0.75F, true);
			this.capacity = capacity;
		}

		public int get(int key) {
			return super.getOrDefault(key, -1);
		}

		public void put(int key, int value) {
			super.put(key, value);
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
			return size() > capacity;
		}
	}

	static class LRUCache2 {

		class DLinkedNode {
			int key;
			int value;
			DLinkedNode prev;
			DLinkedNode next;
		}

		private void addNode(DLinkedNode node) {
			/**
			 * Always add the new node right after head.
			 */
			node.prev = head;
			node.next = head.next;

			head.next.prev = node;
			head.next = node;
		}

		private void removeNode(DLinkedNode node){
			/**
			 * Remove an existing node from the linked list.
			 */
			DLinkedNode prev = node.prev;
			DLinkedNode next = node.next;

			prev.next = next;
			next.prev = prev;
		}

		private void moveToHead(DLinkedNode node){
			/**
			 * Move certain node in between to the head.
			 */
			removeNode(node);
			addNode(node);
		}

		private DLinkedNode popTail() {
			/**
			 * Pop the current tail.
			 */
			DLinkedNode res = tail.prev;
			removeNode(res);
			return res;
		}

		private Map<Integer, DLinkedNode> cache = new HashMap<>();
		private int size;
		private int capacity;
		private DLinkedNode head, tail;

		public void LRUCache(int capacity) {
			this.size = 0;
			this.capacity = capacity;

			head = new DLinkedNode();
			// head.prev = null;

			tail = new DLinkedNode();
			// tail.next = null;

			head.next = tail;
			tail.prev = head;
		}

		public int get(int key) {
			DLinkedNode node = cache.get(key);
			if (node == null) return -1;

			// move the accessed node to the head;
			moveToHead(node);

			return node.value;
		}

		public void put(int key, int value) {
			DLinkedNode node = cache.get(key);

			if(node == null) {
				DLinkedNode newNode = new DLinkedNode();
				newNode.key = key;
				newNode.value = value;

				cache.put(key, newNode);
				addNode(newNode);

				++size;

				if(size > capacity) {
					// pop the tail
					DLinkedNode tail = popTail();
					cache.remove(tail.key);
					--size;
				}
			} else {
				// update the value.
				node.value = value;
				moveToHead(node);
			}
		}
	}

	static class MergekSortedLists{
		public ListNode mergeKLists(ListNode[] lists) {
			int min_index = 0;
			ListNode head = new ListNode(0);
			ListNode h = head;
			while (true) {
				boolean isBreak = true;
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < lists.length; i++) {
					if (lists[i] != null) {
						if (lists[i].val < min) {
							min_index = i;
							min = lists[i].val;
						}
						isBreak = false;
					}

				}
				if (isBreak) {
					break;
				}
				h.next = lists[min_index];
				h = h.next;
				lists[min_index] = lists[min_index].next;
			}
			h.next = null;
			return head.next;
		}
	}

	static class CombinationSum{
		protected void backtrack(
				int remain,
				LinkedList<Integer> comb,
				int start, int[] candidates,
				List<List<Integer>> results) {

			if (remain == 0) {
				// make a deep copy of the current combination
				results.add(new ArrayList<Integer>(comb));
				return;
			} else if (remain < 0) {
				// exceed the scope, stop exploration.
				return;
			}

			for (int i = start; i < candidates.length; ++i) {
				// add the number into the combination
				comb.add(candidates[i]);
				this.backtrack(remain - candidates[i], comb, i, candidates, results);
				// backtrack, remove the number from the combination
				comb.removeLast();
			}
		}

		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> results = new ArrayList<List<Integer>>();
			LinkedList<Integer> comb = new LinkedList<Integer>();

			this.backtrack(target, comb, 0, candidates, results);
			return results;
		}
	}
}
