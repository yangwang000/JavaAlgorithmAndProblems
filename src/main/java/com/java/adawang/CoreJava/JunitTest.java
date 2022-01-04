package com.java.adawang.CoreJava;

import org.junit.Assert;
import org.junit.Test;

public class JunitTest {
	private double epsilon = 1e-6;

	@Test
	public void accountCannotHaveNegativeOverdraftLimit() {
		Account account = new Account(-20);
		Assert.assertFalse(account.deposit(-1));
		Assert.assertFalse(account.withdraw(-1));
		Assert.assertFalse(account.withdraw(1));
		Assert.assertTrue(account.deposit(10));
		Assert.assertEquals(10d, account.getBalance(), epsilon);
		Assert.assertTrue(account.withdraw(1));
		Assert.assertEquals(9d, account.getBalance(), epsilon);
		Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
	}
}
