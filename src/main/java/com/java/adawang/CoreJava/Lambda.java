package com.java.adawang.CoreJava;

import org.junit.Test;

import java.util.ArrayList;

public class Lambda {
	@Test
	public void asParamToFunction(){
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.forEach((n) -> {System.out.println(n);});
	}

	interface StringFunction {
		String run(String str);
	}

	public void printFormatted(String str, StringFunction format) {
		String result = format.run(str);
		System.out.println(result);
	}

	@Test
	public void takeLambdaAsParam(){
		StringFunction exclaim = (s) -> s + "!";
		StringFunction ask = (s) -> s + "?";
		printFormatted("Hello", exclaim);
		printFormatted("Hello", ask);
	}

	interface PerformOperation {
		boolean check(int a);
	}

	class MyMath {
		public boolean checker(PerformOperation p, int num) {
			return p.check(num);
		}

		public PerformOperation isOdd(){
			return (a) ->{
				return (a%2 == 1);
			};
		}

		public PerformOperation isPrime(){
			return (a) -> {
				for(int i = 2; i <= a/2; i++){
					if(a%i == 0){
						return false;
					}
				}
				return true;
			};
		}

		public PerformOperation isPalindrome(){
			return (a) ->{
				int ans = 0;
				int num = a;
				while(num > 0){
					int temp = num % 10;
					ans = ans * 10 + temp;
					num = num/10;
				}
				return a == ans;
			};
		}
	}

	@Test
	public void takeLambdaAsParamAdvanced(){
		int[][] input = new int[][] {{1,4},{2,5},{3,898},{1,3},{2,12}};
		MyMath ob = new MyMath();
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		int i = 0;
		while(i < input.length){
			if (input[i][0] == 1) {
				op = ob.isOdd();
				ret = ob.checker(op, input[i][1]);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (input[i][0] == 2) {
				op = ob.isPrime();
				ret = ob.checker(op, input[i][1]);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (input[i][0] == 3) {
				op = ob.isPalindrome();
				ret = ob.checker(op, input[i][1]);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
			}
			i++;
			System.out.println(ans);
		}
	}
}
