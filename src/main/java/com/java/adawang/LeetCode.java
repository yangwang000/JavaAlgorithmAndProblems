package com.java.adawang;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.channels.IllegalChannelGroupException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode {
	public static boolean canWin(int leap, int[] game) {
		// Return true if you can win the game; otherwise, return false.
		int len = game.length;
		boolean[] map = new boolean[len];
		map[0] = true;
		for(int i = 0; i < len; i++){
			if(game[i] == 0 && map[i]){

			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}

			System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
		}
		scan.close();
	}

	@Test
	public void test(){
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1,1);
		if(map.get(2) == null){
			System.out.println("null");
		}
	}
}