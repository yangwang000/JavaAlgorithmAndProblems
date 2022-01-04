package com.java.adawang.LeetCodeProblems;

public class DynamicProgrammingProblems {
	/*
	* #5 Longest Palindromic Substring
	* */
	static class LongestPalindromicSubstring{
		static void printSubStr(
				String str, int low, int high)
		{
			System.out.println(
					str.substring(
							low, high + 1));
		}

		static int longestPalSubstr(String str)
		{
			// get length of input string
			int n = str.length();

			// table[i][j] will be false if
			// substring str[i..j] is not palindrome.
			// Else table[i][j] will be true
			boolean table[][] = new boolean[n][n];

			// All substrings of length 1 are palindromes
			int maxLength = 1;
			for (int i = 0; i < n; ++i)
				table[i][i] = true;

			// check for sub-string of length 2.
			int start = 0;
			for (int i = 0; i < n - 1; ++i) {
				if (str.charAt(i) == str.charAt(i + 1)) {
					table[i][i + 1] = true;
					start = i;
					maxLength = 2;
				}
			}

			// Check for lengths greater than 2.
			// k is length of substring
			for (int k = 3; k <= n; ++k) {

				// Fix the starting index
				for (int i = 0; i < n - k + 1; ++i) {
					// Get the ending index of substring from
					// starting index i and length k
					int j = i + k - 1;

					// checking for sub-string from ith index to
					// jth index iff str.charAt(i+1) to
					// str.charAt(j-1) is a palindrome
					if (table[i + 1][j - 1]
							&& str.charAt(i) == str.charAt(j)) {
						table[i][j] = true;

						if (k > maxLength) {
							start = i;
							maxLength = k;
						}
					}
				}
			}
			System.out.print("Longest palindrome substring is; ");
			printSubStr(str, start,
					start + maxLength - 1);

			// return length of LPS
			return maxLength;
		}
	}

	/* #10 Regular Expression Matching
	* Given an input string s and a pattern p, implement
	* regular expression matching with support for '.'
	* and '*' where:'.' Matches any single character. '*'
	* Matches zero or more of the preceding element. The
	* matching should cover the entire input string (not partial).
	* */
	enum Result {
		TRUE, FALSE
	}
	static class RegularExpressionMatching{
		Result[][] memo;
		public boolean isMatchTopDown(String text,
								String pattern) {
			memo = new Result[text.length() + 1][pattern.length() + 1];
			return dp(0, 0, text, pattern);
		}
		public boolean dp(int i, int j, String text, String pattern) {
			if (memo[i][j] != null) {
				return memo[i][j] == Result.TRUE;
			}
			boolean ans;
			if (j == pattern.length()){
				ans = i == text.length();
			} else{
				boolean first_match = (i < text.length() &&
						(pattern.charAt(j) == text.charAt(i) ||
								pattern.charAt(j) == '.'));

				if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
					ans = (dp(i, j+2, text, pattern) ||
							first_match && dp(i+1, j, text, pattern));
				} else {
					ans = first_match && dp(i+1, j+1, text, pattern);
				}
			}
			memo[i][j] = ans ? Result.TRUE : Result.FALSE;
			return ans;
		}

		public boolean isMatchBottomUp(String text,
								String pattern) {
			boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
			dp[text.length()][pattern.length()] = true;

			for (int i = text.length(); i >= 0; i--){
				for (int j = pattern.length() - 1; j >= 0; j--){
					boolean first_match = (i < text.length() &&
							(pattern.charAt(j) == text.charAt(i) ||
									pattern.charAt(j) == '.'));
					if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
						dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
					} else {
						dp[i][j] = first_match && dp[i+1][j+1];
					}
				}
			}
			return dp[0][0];
		}

		public boolean isMatchBottomUp1(String text,
										String pattern){
			boolean[][] match =
					new boolean[text.length()+1][pattern.length()+1];
			match[0][0] = true;
//			deal with a* a*b* a*b*c*
			for(int i = 1; i < pattern.length()+1; i++){
				if(pattern.charAt(i-1) == '*'){
					match[0][i] = match[0][i-2];
				}
			}
			for(int i = 1; i < text.length()+1; i++){
				for(int j = 1; j < pattern.length()+1; j++){
					if(pattern.charAt(j-1) == '.' || pattern.charAt(j-1) == text.charAt(i-1)){
						match[i][j] = match[i-1][j-1];
					}else if(pattern.charAt(j-1) == '*'){
						match[i][j] = match[i][j-2];
						if(pattern.charAt(j-2)=='.' || pattern.charAt(j-2) == text.charAt(i-1))	{
							match[i][j] =
									match[i][j] || match[i-1][j];
						}
					}else {
						match[i][j] = false;
					}
				}
			}
			return match[text.length()][pattern.length()];
		}
	}

	static class CutRodProblem{
//		Problem from <Introduction to algorithms 3rd
//		edition> Chapter 15
//		top-down procedure
		public static int memorizedCutRod(int[] priceTable,
										  int rodLength){
			int[] revenue = new int[rodLength+1];
			for(int i=0; i<=rodLength; i++)
				revenue[i] = Integer.MIN_VALUE;
			return memorizedCutRodAux(priceTable,
					rodLength, revenue);
		}
		static int memorizedCutRodAux(int[] priceTable,
									  int rodLength,
									  int[] revenue){
			int maxRev = Integer.MIN_VALUE;
			if(revenue[rodLength] >= 0)
				return revenue[rodLength];
			if(rodLength == 0){
				maxRev = 0;
			}else {
				maxRev = Integer.MIN_VALUE;
				for(int i=1; i<=rodLength; i++){
					int tempRev =
							priceTable[i] + memorizedCutRodAux(priceTable, rodLength-i, revenue);
					if(tempRev > maxRev)
						maxRev = tempRev;
				}
				revenue[rodLength] = maxRev;
			}
			return maxRev;
		}

//		bottom-up
		public static int bottomUpCutRod(int[] priceTable
				, int rodLength){
			int[] revenue = new int[rodLength+1];
			revenue[0] = 0;
			for(int i=1; i<=rodLength; i++){
				int maxRev = Integer.MIN_VALUE;
				for(int j=1; j<=i; j++){
					int tempRev =
							priceTable[j] + revenue[i-j];
					if(tempRev > maxRev)
						maxRev = tempRev;
				}
				revenue[i] = maxRev;
			}
			return revenue[rodLength];
		}
	}

	static class MatrixChainMultiplication{
		public static Object[] matrixChainOrder(int[] matrixChainSize){
			int n = matrixChainSize.length-1;
//			array m is the scalar multiplication needed
//			when compute the matrix
			int[][] m = new int[n+1][n+1];
			int[][] s = new int[n+1][n+1];
			for(int i=0; i<=n; i++){
				m[i][i] = 0;
			}
			for(int l=2; l<=n; l++){//l is the chain length
				for(int i=1; i<=(n-l+1); i++){
					int j = i+l-1;
					m[i][j] = Integer.MAX_VALUE;
					for(int k=i; k<=j-1; k++){
						int q =
								m[i][k] + m[k+1][j] + matrixChainSize[i-1]*matrixChainSize[k]*matrixChainSize[j];
						if(q < m[i][j]){
							m[i][j] = q;
							s[i][j] = k;
						}
					}
				}
			}
			return new Object[]{m,s};
		}

		public static void printOptimalParens(int[][] s,
											  int i, int j){
			if(i==j){
				System.out.print("A"+Integer.toString(i));
			}else {
				System.out.print("(");
				printOptimalParens(s,i,s[i][j]);
				printOptimalParens(s,s[i][j]+1,j);
				System.out.print(")");
			}
		}
	}

	static class LongestCommonSubsequence{
		public static Object[] longestCommonSubseq(char[] x, char[] y){
			int m = x.length;
			int n = y.length;
			char[][] b = new char[m+1][n+1];
			int[][] c = new int[m+1][n+1];
			for(int i = 0; i <= m; i++)
				c[i][0] = 0;
			for(int i = 0; i <= n; i++)
				c[0][i] = 0;
			for(int i = 1; i <= m; i++){
				for(int j = 1; j <= n; j++){
					if(x[i-1] == y[j-1]){
						c[i][j] = c[i-1][j-1] + 1;
						b[i][j] = 'D';
					}else if(c[i-1][j] >= c[i][j-1]){
						c[i][j] = c[i-1][j];
						b[i][j] = 'U';
					}else {
						c[i][j] = c[i][j-1];
						b[i][j] = 'L';
					}
				}
			}
			return new  Object[]{c,b};
		}

		public static void printLongestCommonSubseq(char[][] b, char[] x, int i, int j){
			if(i==0 || j==0)
				return;
			if(b[i][j] == 'D'){
				printLongestCommonSubseq(b, x, i-1, j-1);
				System.out.print(x[i-1]);
			}else if(b[i][j] == 'U'){
				printLongestCommonSubseq(b, x, i-1, j);
			}else {
				printLongestCommonSubseq(b, x, i, j-1);
			}
		}
	}

	static class OptimalBinarySearchTree{
		public static Object[] optimalBST(double[] p,
										  double[] q,
										  int n){
			double[][] e = new double[n+2][n+2];
			double[][] w = new double[n+2][n+2];
			double[][] root = new double[n+1][n+1];
			for(int i = 1; i <= n+1; i++){
				e[i][i-1] = q[i-1];
				w[i][i-1] = q[i-1];
			}
			for(int l = 1; l <= n; l++){
				for(int i = 1; i<= n-l+1; i++){
					int j = i+l-1;
					e[i][j] = Double.MIN_VALUE;
					w[i][j] = w[i][j-1] + p[j] + q[j];
					for(int r = i; r <= j; r++){
						double t =
								e[i][r-1] + e[r+1][j] + w[i][j];
						if(t < e[i][j]){
							e[i][j] = t;
							root[i][j] = r;
						}
					}
				}
			}
			return new Object[]{e, root};
		}
	}

	public static void main(String[] args){
		/* more problems to be solved on Chapter 15
		problem section*/
//		//test OptimalBinarySearchTree
//		double[] p = {0, 0.15, 0.1, 0.05, 0.1, 0.2};
//		double[] q = {0.05, 0.1, 0.05, 0.05, 0.05, 0.1};
//		Object[] result =
//				OptimalBinarySearchTree.optimalBST(p, q, 5);


//		//test memorizedCutRod
//		int[] priceTable = new int[]{0,1,5,8,9,10,17,17,20,
//				24,30};
//		int maxRev =
//				CutRodProblem.memorizedCutRod(priceTable,
//						4);
//		System.out.println(maxRev);


//		//test MatrixChainMultiplication
//		int[] p = new int[]{30,35,15,5,10,20,25};
//		Object[] result =
//				MatrixChainMultiplication.matrixChainOrder(p);
//		MatrixChainMultiplication.printOptimalParens((int[][]) result[1], 1, 6);


//		//test LongestCommonSubsequence
//		char[] x = new char[]{'a','b','c','b','d','a','b'};
//		char[] y = new char[]{'b','d','c','a','b','a'};
//		Object[] result =
//				LongestCommonSubsequence.longestCommonSubseq(x,y);
//		LongestCommonSubsequence.printLongestCommonSubseq((char[][]) result[1], x, 7, 6);
	}
}
