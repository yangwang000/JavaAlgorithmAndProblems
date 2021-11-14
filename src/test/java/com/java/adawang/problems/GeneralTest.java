package com.java.adawang.problems;

public class GeneralTest {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("hello");
		sb.deleteCharAt(0).insert(0, "H");
		System.out.println(sb);
	}
}
