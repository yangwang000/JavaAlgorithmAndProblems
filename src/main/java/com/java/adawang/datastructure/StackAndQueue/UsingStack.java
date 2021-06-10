package com.java.adawang.datastructure.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class UsingStack {
	public static <E> void reverse(E[] a){
		Stack<E> buffer = new ArrayStack<>(a.length);
		for(int i=0;i<a.length;i++){
			buffer.push(a[i]);
		}
		for(int i=0;i<a.length;i++){
			a[i] = buffer.pop();
		}
	}

	public static boolean isMatched(String expression){
		final String opening="({[";
		final String closing=")}]";
		Stack<Character> buffer = new LinkedStack<>();
		for(char c: expression.toCharArray()){
			if(opening.indexOf(c) != -1)
				buffer.push(c);
			else if(closing.indexOf(c) != -1){
				if (buffer.isEmpty())
					return false;
				if(closing.indexOf(c) != opening.indexOf(buffer.pop()))
					return false;
			}
		}
		return buffer.isEmpty();
	}

	public static boolean isHTMLMatched(String html){
		Stack<String> buffer = new LinkedStack<>();
		int j=html.indexOf('<');
		while (j!=-1){
			int k=html.indexOf('>', j+1);
			if(k==-1)
				return false;
			String tag=html.substring(j+1,k);
			if(!tag.startsWith("/"))
				buffer.push(tag);
			else{
				if(buffer.isEmpty())
					return false;
				if(!tag.substring(1).equals(buffer.pop()))
					return false;
			}
			j=html.indexOf('<', k+1);
		}
		return buffer.isEmpty();
	}

	public static void main(String[] args){
		Integer[] a = {2,3,5,6,9};
		String[] s = {"Jack", "Kate", "Hurley", "Jin"};
		System.out.println("a="+ Arrays.toString(a));
		System.out.println("s="+Arrays.toString(s));
		System.out.println("Reversing...");
		reverse(a);
		reverse(s);
		System.out.println("a="+Arrays.toString(a));
		System.out.println("s="+Arrays.toString(s));
	}
}
