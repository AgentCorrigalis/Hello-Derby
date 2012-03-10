package com.corrigalis.helloDerby;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SecondQuickTest {
	
	@Test
	public void testString() {
		assertTrue("Hello".equals(FirstClass.hello()));
	}
}
