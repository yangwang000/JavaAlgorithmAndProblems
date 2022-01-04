package com.java.adawang.LeetCodeProblems.GreedyProblems;

import java.util.Arrays;

public class MeetingRoomsII {
	public int minMeetingRooms(int[][] intervals) {
		if(intervals == null || intervals.length == 0)
			return 0;

		int[] startTime = new int[intervals.length];
		int[] endTime = new int[intervals.length];
		for(int i = 0; i < intervals.length; i++){
			startTime[i] = intervals[i][0];
			endTime[i] = intervals[i][1];
		}
		Arrays.sort(startTime);
		Arrays.sort(endTime);
		int count = 0, sidx = 0, eidx = 0;
		while(sidx < startTime.length){
			if(startTime[sidx] >= endTime[eidx]){
				count--;
				eidx++;
			}
			sidx++;
			count++;
		}

		return count;
	}
}
