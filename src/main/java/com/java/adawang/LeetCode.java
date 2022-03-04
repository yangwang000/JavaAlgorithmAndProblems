package com.java.adawang;
import org.junit.Test;

import java.nio.channels.IllegalChannelGroupException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode {
	static int count;
	int i;
	{
//This is an instance initializers. Run every time an object is created. //static and instance variables can be accessed System.out.println("Instance Initializer");
		i = 6;
		count = count + 1;
		System.out.println("Count when Instance Initializer is run is " + count); }

	public static void main(String[] args){
		String regex = "(\\b\\w+\\b)(\\s+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		int numSentences = 1;

		while (numSentences-- > 0) {
			String input = "I love Love to To tO code .";

			Matcher m = p.matcher(input);

			// Check for subsequences of input that match the compiled pattern
			while (m.find()) {
				input = input.replaceAll(m.group(), m.group(1));
			}

			// Prints the modified sentence.
			System.out.println(input);
		}
	}
}