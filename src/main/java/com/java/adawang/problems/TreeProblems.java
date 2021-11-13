package com.java.adawang.problems;

import java.util.TreeMap;

public class TreeProblems {
	static class MyCalendar {
		TreeMap<Integer, Integer> calendar;

		MyCalendar() {
			this.calendar = new TreeMap<>();
		}

		public boolean book(int start, int end) {
			Integer pre = calendar.floorKey(start);
			Integer next = calendar.ceilingKey(start);
			if((pre == null || calendar.get(pre) <= start) && (next == null || end <= next)){
				calendar.put(start,end);
				return true;
			}
			return false;
		}
	}
}
