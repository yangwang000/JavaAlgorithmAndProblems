package com.java.adawang.problems;

public class RecursionProblems {
		/* #10 Regular Expression Matching
	*  Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
	'.' Matches any single character.​​​​
	'*' Matches zero or more of the preceding element.
	The matching should cover the entire input string (not partial).
	* */
	static class RegularExpressionMatching{
		/*
		Without a Kleene star, our solution would look
		like this (python):
		def match(text, pattern):
    		if not pattern: return not text
    		first_match = bool(text) and pattern[0] in {text[0], '.'}
    		return first_match and match(text[1:], pattern[1:])
    	If a star is present in the pattern, it will be
    	in the second position pattern[1]. Then, we may
    	ignore this part of the pattern, or delete a matching character in the text.
    	If we have a match on the remaining strings after any of these operations, then the initial inputs matched.
		* */
		public boolean isMatch(String text, String pattern) {
			if (pattern.isEmpty()) return text.isEmpty();
			boolean first_match = (!text.isEmpty() &&
					(pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

			if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
				return (isMatch(text, pattern.substring(2)) ||
						(first_match && isMatch(text.substring(1), pattern)));
			} else {
				return first_match && isMatch(text.substring(1), pattern.substring(1));
			}
		}
	}
}
