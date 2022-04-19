package com.java.adawang.CoreJava.AnnotationsReflect;

public class Goat extends Animal implements Locomotion{
	public Goat(String bird) {
		super(bird);
	}

	@Override
	protected String getSound() {
		return "bleat";
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String eats() {
		return "grass";
	}

	@Override
	public String getLocomotion() {
		return "walks";
	}
}
