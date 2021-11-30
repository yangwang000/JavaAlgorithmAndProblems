package com.java.adawang.problems.SimulationProblems;

public class RobotBoundedInCircle {
	// # 1041
	public boolean isRobotBounded(String instructions) {
		//north = 0, east = 1, south = 2, west = 3
		int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		// initial position
		int x = 0, y = 0;
		// facing north
		int idx = 0;

		for(char i: instructions.toCharArray()){
			if(i=='L'){
				idx = (idx + 3)%4;
			}else if(i=='R'){
				idx = (idx + 1) % 4;
			}else{
				x += directions[idx][0];
				y += directions[idx][1];
			}
		}

		return ((x==0 && y==0) || idx != 0);
	}
}
