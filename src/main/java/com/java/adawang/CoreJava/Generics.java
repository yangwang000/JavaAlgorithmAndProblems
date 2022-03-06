package com.java.adawang.CoreJava;

import org.junit.Test;

public class Generics {
	public class Box<T>{
		private T t;
		public void set(T t) {this.t = t;}
		public T get() {return this.t;}
	}

	@Test
	public void testBox(){
		Box<Integer> integerBox = new Box<>();
	}

	public interface Pair<K, V>{
		public K getKey();
		public V getValue();
	}

	public static class Util{
		public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2){
			return p1.getKey().equals(p2.getKey()) &&
					p1.getValue().equals(p2.getValue());
		}
	}

	public class OrderedPair<K, V> implements Pair<K, V>{
		private K key;
		private V value;

		public OrderedPair(K key, V value){
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}
	}

	@Test
	public void testPair(){
		OrderedPair<String, Integer> orderedPair1 = new OrderedPair<>("a", 1);
		OrderedPair<String, String> orderedPair2 = new OrderedPair<>("b","c");
	}
}
