package com.java.adawang.LeetCodeProblems.SimulationProblems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	// # 54
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();

		int row = matrix.length;
		int col = matrix[0].length;
		int left = 0;
		int right = col - 1;
		int up = 0;
		int down = row - 1;

		while(res.size() < row*col){
			//up: left to right
			for(int i = left; i <= right; i++){
				res.add(matrix[up][i]);
			}

			//right: up to down
			for(int i = up + 1; i <= down; i++){
				res.add(matrix[i][right]);
			}

			//down: right to left
			if(up != down){
				for(int i = right - 1; i >= left; i--){
					res.add(matrix[down][i]);
				}
			}

			//left: down to up
			if(left != right){
				for(int i = down - 1; i > up; i--){
					res.add(matrix[i][left]);
				}
			}

			up++;
			down--;
			left++;
			right--;
		}

		return res;
	}
}
