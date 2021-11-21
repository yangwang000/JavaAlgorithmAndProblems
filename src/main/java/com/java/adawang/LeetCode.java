package com.java.adawang;

import com.java.adawang.datastructure.ListAndIterator.ArrayList;

import java.util.List;

public class LeetCode {
	public static boolean validPalindrome(String s) {
		int head = 0;
		int tail = s.length() - 1;
		while(head < tail){
			if(s.charAt(head) == s.charAt(tail)){
				head++;
				tail--;
			}else{
				return validP(s, head, tail--) || validP(s, head++, tail);
			}
		}
		return true;
	}

	public static boolean validP(String s, int head,
							   int tail){
		while(head < tail){
			if(s.charAt(head) == s.charAt(tail)){
				head++;
				tail--;
			}else{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		boolean res = validPalindrome(
				"ebcbbececabbacecbbcbe");
		System.out.println(res);
	}
}
