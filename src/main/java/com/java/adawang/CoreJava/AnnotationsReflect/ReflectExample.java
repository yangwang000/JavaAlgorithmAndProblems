package com.java.adawang.CoreJava.AnnotationsReflect;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ReflectExample {
	static class Inner{
		private class Private{
			private String powerof2(int num){
				return ((num&num-1)==0)?"power of 2":"not a power of 2";
			}
		}
	}//end of Inner

	public static void main(String[] args) throws Exception {
		DoNotTerminate.forbidExit();

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private

			if(num<1||num>Math.pow(2,30))
				throw new Exception();

			ReflectExample.Inner ob=new ReflectExample.Inner();
			Class<?> c = ReflectExample.Inner.class.getDeclaredClasses()[0];
			Constructor<?> constructor = c.getDeclaredConstructor(ReflectExample.Inner.class);
			constructor.setAccessible(true);
			o = constructor.newInstance(ob);
//			Method m = c.getDeclaredMethod("powerof2",new Class[]{int.class}) ;
			Method m = c.getDeclaredMethod("powerof2",int.class) ;
			m.setAccessible(true);
			String ans = (String) m.invoke(o,num);
			System.out.println(num+" is "+ans);

			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

		}//end of try

		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}//end of main

	public class Person {
		private String name;
		private int age;
	}

	@Test
	public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
		Object person = new Person();
		Field[] fields = person.getClass().getDeclaredFields();

		List<String> actualFieldNames = new ArrayList<>();
		for(Field f : fields){
			actualFieldNames.add(f.getName());
		}
		assertTrue(Arrays.asList("name", "age", "this$0")
				.containsAll(actualFieldNames));
	}

	@Test
	public void givenObject_whenGetsClassName_thenCorrect() throws ClassNotFoundException {
//		Object goat = new Goat("goat");
//		Class<?> clazz = goat.getClass();

		Class<?> goatClass = Class.forName("com.java.adawang.CoreJava.AnnotationsReflect.Goat");
		Class<?> animalClass = Class.forName("com.java.adawang.CoreJava.AnnotationsReflect.Animal");

		assertEquals("Goat", goatClass.getSimpleName());
		assertEquals("com.java.adawang.CoreJava.AnnotationsReflect.Goat", goatClass.getName());
		assertEquals("com.java.adawang.CoreJava.AnnotationsReflect.Goat", goatClass.getCanonicalName());

		int goatMods = goatClass.getModifiers();
		int animalMods = animalClass.getModifiers();
		assertTrue(Modifier.isPublic(goatMods));
		assertTrue(Modifier.isAbstract(animalMods));
		assertTrue(Modifier.isPublic(animalMods));

		Class<?>[] goatInterfaces = goatClass.getInterfaces();
		Class<?>[] animalInterfaces = animalClass.getInterfaces();
		assertEquals(1, goatInterfaces.length);
		assertEquals(1, animalInterfaces.length);
		assertEquals("Locomotion", goatInterfaces[0].getSimpleName());
		assertEquals("Eating", animalInterfaces[0].getSimpleName());	}

	@Test
	public void givenClass_whenGetsConstructor_thenCorrect() throws ClassNotFoundException {
		Class<?> goatClass = Class.forName("com.java.adawang.CoreJava.AnnotationsReflect.Goat");

		Constructor<?>[] constructors = goatClass.getConstructors();

		assertEquals(1, constructors.length);
		assertEquals("com.java.adawang.CoreJava.AnnotationsReflect.Goat", constructors[0].getName());
	}

	private static List<String> getMethodNames(Method[] methods) {
		List<String> methodNames = new ArrayList<>();
		for (Method method : methods)
			methodNames.add(method.getName());
		return methodNames;
	}

	@Test
	public void givenClass_whenGetsMethods_thenCorrect() throws ClassNotFoundException {
		Class<?> animalClass = Class.forName("com.java.adawang.CoreJava.AnnotationsReflect.Animal");
		Method[] methods = animalClass.getDeclaredMethods();
		List<String> actualMethods = getMethodNames(methods);

		assertEquals(4, actualMethods.size());
		assertTrue(actualMethods.containsAll(Arrays.asList("getName",
				"setName", "getSound")));
	}

	@Test
	public void givenClass_whenGetsAllConstructors_thenCorrect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Class<?> birdClass = Class.forName("com.java.adawang.CoreJava.AnnotationsReflect.Bird");
		Constructor<?>[] constructors = birdClass.getConstructors();

		assertEquals(3, constructors.length);

		Constructor<?> cons1 = birdClass.getConstructor();
		Constructor<?> cons2 = birdClass.getConstructor(String.class);
		Constructor<?> cons3 = birdClass.getConstructor(String.class, boolean.class);

		Bird bird1 = (Bird) cons1.newInstance();
		Bird bird2 = (Bird) cons2.newInstance("Weaver bird");
		Bird bird3 = (Bird) cons3.newInstance("dove", true);

//		assertEquals("bird", bird1.getName());
//		assertEquals("Weaver bird", bird2.getName());
//		assertEquals("dove", bird3.getName());
//
//		assertFalse(bird1.walks());
//		assertTrue(bird3.walks());
	}
}
