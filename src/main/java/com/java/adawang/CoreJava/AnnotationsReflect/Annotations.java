package com.java.adawang.CoreJava.AnnotationsReflect;

import java.lang.reflect.*;

public class Annotations {
		public static void main(String[] args) {
		String[] roles = new String[] {"SENIOR","DOG", "JUNIOR"};
		int[] spends = new int[]{50, 5, 10};
		int testCases = roles.length - 1;
		while (testCases >= 0) {
			String role = roles[testCases];
			int spend = spends[testCases];
			try {
				Class annotatedClass = FamilyMember.class;
				Method[] methods = annotatedClass.getMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(FamilyBudget.class)) {
						FamilyBudget family = method
								.getAnnotation(FamilyBudget.class);
						String userRole = family.userRole();
						int budgetLimit = family.budgetLimit();
						if (userRole.equals(role)) {
							if(spend <= budgetLimit){
								method.invoke(FamilyMember.class.newInstance(),
										budgetLimit, spend);
							}else{
								System.out.println("Budget Limit Over");
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			testCases--;
		}
	}
}
