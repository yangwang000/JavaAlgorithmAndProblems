package com.java.adawang.LeetCodeProblems.TwoPointerProblems;

public class ExpressiveWords {
	// # 809
	public int expressiveWords(String s, String[] words) {
		int res = 0;

		for(String word : words){
			if(isMatch(s, word))
				res++;
		}

		return res;
	}

	boolean isMatch(String s, String w){
		int sidx = 0;
		int widx = 0;

		while(sidx < s.length() && widx < w.length()){
			if(s.charAt(sidx) != w.charAt(widx)){
				return false;
			}

			int snum = 1;
			while(sidx < s.length() - 1){
				if(s.charAt(sidx) == s.charAt(sidx+1)){
					snum++;
					sidx++;
				}else{
					break;
				}
			}
			sidx++;

			int wnum = 1;
			while(widx < w.length() - 1){
				if(w.charAt(widx) == w.charAt(widx+1)){
					wnum++;
					widx++;
				}else{
					break;
				}
			}
			widx++;

			if((snum >= 3 && wnum <= snum ) || (snum < 3 && snum == wnum)){
				continue;
			}else{
				return false;
			}
		}

		if(sidx != s.length() || widx != w.length()){
			return false;
		}

		return true;
	}
}
