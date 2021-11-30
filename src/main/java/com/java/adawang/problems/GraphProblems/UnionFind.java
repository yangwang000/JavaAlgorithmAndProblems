package com.java.adawang.problems.GraphProblems;

public class UnionFind {
	// Union Find
	public int findCircleNum(int[][] isConnected) {
		if (isConnected == null || isConnected.length == 0) {
			return 0;
		}

		int n = isConnected.length;
		UnionFindS uf = new UnionFindS(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isConnected[i][j] == 1) {
					uf.union(i, j);
				}
			}
		}
		return uf.getCount();
	}

	class UnionFindS {
		private int[] root;
		private int[] rank;
		private int count;

		UnionFindS(int size) {
			root = new int[size];
			rank = new int[size];
			count = size;
			for (int i = 0; i < size; i++) {
				root[i] = i;
				rank[i] = 1;
			}
		}

		int find(int x) {
			if (x == root[x]) {
				return x;
			}
			return root[x] = find(root[x]);
		}

		void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX != rootY) {
				if (rank[rootX] > rank[rootY]) {
					root[rootY] = rootX;
				} else if (rank[rootX] < rank[rootY]) {
					root[rootX] = rootY;
				} else {
					root[rootY] = rootX;
					rank[rootX] += 1;
				}
				count--;
			}
		}

		int getCount() {
			return count;
		}
	}
}