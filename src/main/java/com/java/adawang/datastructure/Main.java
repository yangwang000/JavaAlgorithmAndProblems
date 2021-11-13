package com.java.adawang.datastructure;



public class Main {
	interface One{
		default void method(){
			System.out.println("one");
		}
	}
	interface Two{
		default void method(){
			System.out.println("two");
		}
	}
	class Three implements One, Two{

		@Override
		public void method() {
			One.super.method();
		}
	}

	public static void badMethod(){
		throw new Error();
	}

	static Exception print(int i){
		if (i>0) {
			return new Exception();
		} else {
			throw new RuntimeException();
		}
	}

	public static void main(String[] args){
		System.out.println(print(2));
//		try {
//			System.out.println("A");
//			badMethod();
//			System.out.println("B");
//		} catch (Exception ex) {
//			System.out.println("C");
//		} finally {
//			System.out.println("D");
//		}

//		List<Boolean> list = new ArrayList<>();
//		list.add(true);
//		list.add(Boolean.parseBoolean("FalSe"));
//		System.out.print(list.size());
//		System.out.print(list.get(1) instanceof Boolean);

//		try{
//			System.out.print("Hello World");
//		}catch(Exception e){
//			System.out.println("e");
//		}catch(ArithmeticException e){
//			System.out.println("e");
//		}finally{
//			System.out.println("!");
//		}

//		LinkedList<Integer> list = new LinkedList<>();
//		list.add(5);
//		list.add(1);
//		list.add(10);
//		System.out.println(list);

//		boolean b1=true;
//		boolean b2=false;
//		int i1 = 1;
//		int i2 = 2;
//		System.out.println(i1^i2);

//		List list = new ArrayList();
//		list.add("hello");
//		list.add(2);
//		System.out.print(list.get(0) instanceof Object);
//		System.out.print(list.get(1) instanceof Integer);

//		String message="abcedfet";
//		System.out.println(message.getClass().getSimpleName());
//		System.out.println(message.compareTo("bcedfe"));
//		System.out.println(message.equals("abcedfet"));
//		System.out.println(message.matches("bcedfet"));

//		ArrayList<String> list = new ArrayList<>();
//		list.add("a");
//		list.add("b");
//		list.add("1");
//		list.add("2");
//		list.add("A");
//		list.add("B");
//		list.sort(Comparator.comparing(String::toString));
//		Collections.sort(list);
//		list.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
//		for(String i: list){
//			System.out.print(i);
//		}
	}
}
