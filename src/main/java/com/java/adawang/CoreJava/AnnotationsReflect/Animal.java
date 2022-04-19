package com.java.adawang.CoreJava.AnnotationsReflect;

public abstract class Animal implements Eating {
	public static String CATEGORY = "domestic";
	private String name;

	public Animal(String bird) {
	}

	protected abstract String getSound();

	public abstract String getName();
}
