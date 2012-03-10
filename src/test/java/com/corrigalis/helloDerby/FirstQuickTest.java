package com.corrigalis.helloDerby;

import static org.junit.Assert.*;

import org.junit.Test;


public class FirstQuickTest {

	@Test
	public void testString() {
		assertTrue("Hello".equals(FirstClass.hello()));
	}
	
}
