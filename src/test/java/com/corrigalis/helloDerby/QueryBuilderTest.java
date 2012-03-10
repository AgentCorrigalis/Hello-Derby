package com.corrigalis.helloDerby;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;

public class QueryBuilderTest {

	private static final Logger LOGGER = Logger.getLogger(QueryBuilderTest.class.getName());
	
	private static final String TEST_TABLE = "TEST_TABLE";
	
	@Test
	public void createTableWithOneFieldQuery() {
		CreateTableQuery createTableQuery = new CreateTableQuery(TEST_TABLE).withIntegerField("ID");
		assertQuery(createTableQuery, "CREATE TABLE " + TEST_TABLE + " (ID int)");
	}
	
	@Test
	public void createTableWithTwoFieldTypesQuery() {
		CreateTableQuery createTableQuery = new CreateTableQuery(TEST_TABLE).withIntegerField("ID").withVarCharField("TEXT", 40);
		assertQuery(createTableQuery, "CREATE TABLE " + TEST_TABLE + " (ID int, TEXT varChar(40))");
	}
	
	private void assertQuery(CreateTableQuery createTableQuery, String expectedQueryString) {
		LOGGER.info(createTableQuery.build());
		assertTrue(createTableQuery.build().equals(expectedQueryString));
	}
	
	@Test
	public void createTableWithNoFields() {
		CreateTableQuery createTableQuery = new CreateTableQuery(TEST_TABLE);
		Exception caughtException = null;
		try {
			createTableQuery.build();
		} catch (Exception e) {
			caughtException = e;
		}
		assertTrue("No exception caught.", caughtException != null);
		assertTrue(caughtException.getMessage().equals("Can't build create table query with no table fields"));
	}
	
}
