package com.java.adawang.CoreJava.AnnotationsReflect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectExmaple {
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

			ReflectExmaple.Inner ob=new ReflectExmaple.Inner();
			Class<?> c = ReflectExmaple.Inner.class.getDeclaredClasses()[0];
			Constructor<?> constructor = c.getDeclaredConstructor(ReflectExmaple.Inner.class);
			constructor.setAccessible(true);
			o = constructor.newInstance(ob);
			Method m = c.getDeclaredMethod("powerof2",new Class[]{int.class}) ;
			m.setAccessible(true);
			String ans = (String) m.invoke(o,num);
			System.out.println(num+" is "+ans);

			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

		}//end of try

		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}//end of main
}
