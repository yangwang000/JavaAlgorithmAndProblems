package com.java.adawang.JavaBasic;

public class BitwiseOperation {
	public static boolean isEven(int i){
		return ((i & 1) == 0);
	}

	public static void main(String[] args){
		int a = 5;// 101
		int b = 7;// 111

		System.out.println(a & b);
		System.out.println(a | b);
		System.out.println(a ^ b); //010
		System.out.println(~a);//010

		int c = -10;//11010
		System.out.println(a >> 1); //0010
		System.out.println(c >> 1); //10101
		System.out.println(c >>> 1);//unsigned right shift
		System.out.println(a << 1);//1010
		System.out.println(c << 1);//10100

		System.out.println(isEven(c));
	}
}
