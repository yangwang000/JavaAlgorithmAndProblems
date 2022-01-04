package com.java.adawang.CoreJava;

public class StaticClass {
	static class A{
		public void p(){
			System.out.println("A");
		}
	}

	static class B extends A{
		public void b(){
			System.out.println("b");
		}
	}

	public static void main(String[] args){
		B temp = new B();
		temp.p();
	}
}
