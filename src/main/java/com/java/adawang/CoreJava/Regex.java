package com.java.adawang.CoreJava;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	@Test
	public void duplicateWords(){
		String[] lines = new String[]{
				"Goodbye bye bye world world world",
				"Sam went went to to to his business",
				"Reya is is the the best player in eye eye game",
				"in inthe",
				"Hello hello Ab aB"};

		String regex = "(\\b\\w+\\b)(\\s+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		int numSentences = 0;
		while (numSentences < lines.length) {
			String input = lines[numSentences];
			Matcher m = p.matcher(input);
			// Check for subsequences of input that match the compiled pattern
			while (m.find()) {
				input = input.replaceAll(m.group(), m.group(1));
			}
			// Prints the modified sentence.
			System.out.println(input);
			numSentences++;
		}
	}

	@Test
	public void htmlTagExtraction(){
		String[] lines = new String[]{
				"<h1>Nayeem loves counseling</h1>",
				"<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
				"<Amee>safat codes like a ninja</amee>",
				"<SA premium>Imtiaz has a secret crush</SA premium>"
		};

		String regex = "<([^>]+)>([^<>]+)</\\1>";
		Pattern p = Pattern.compile(regex);
		int i = 0;
		while(i < lines.length){
			String input = lines[i];
			Matcher matcher = p.matcher(input);
			boolean find = false;
			while(matcher.find()){
				System.out.println(matcher.group(2));
				find = true;
			}
			if(!find){
				System.out.println("None");
			}
			i++;
		}
	}
}
