package com.corrigalis.helloDerby;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
	
	private static final String TEST_TABLE = "TEST_TABLE";
	
	@Before
	public void setup() throws SQLException {
	}
	
	@Test
	public void testTableExistsFalse() throws SQLException {
		assertFalse(Database.tableExists(TEST_TABLE));
	}
	
	@Test
	public void testTableExistsTrue() throws SQLException {
		Database.createTable(TEST_TABLE);
		assertTrue(Database.tableExists(TEST_TABLE));
		
	}
	
}
