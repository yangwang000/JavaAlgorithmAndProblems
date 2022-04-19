package com.java.adawang.CoreJava.AnnotationsReflect;

public class Bird extends Animal{
	private boolean walks;

	public Bird() {
		super("bird");
	}

	public Bird(String name, boolean walks) {
		super(name);
		setWalks(walks);
	}

	private void setWalks(boolean walks) {
	}

	public Bird(String name) {
		super(name);
	}

	public boolean walks() {
		return walks;
	}

	@Override
	protected String getSound() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String eats() {
		return null;
	}
}
