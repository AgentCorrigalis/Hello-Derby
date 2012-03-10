package com.corrigalis.helloDerby;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
	
	private static final String TEST_TABLE = "TEST_TABLE";
	
	@Before
	public void setUp() throws SQLException {
		cleanDatabase();
	}
	
	@Test
	public void testCreateAndDropTable() throws SQLException {
		createTestTable();
		assertTrue(Database.tableExists(TEST_TABLE));
		dropTestTable();
		assertFalse(Database.tableExists(TEST_TABLE));
	}

	@After
	public void tearDown() throws SQLException {
		cleanDatabase();
	}
	
	private void cleanDatabase() throws SQLException {
		if (Database.tableExists(TEST_TABLE)) Database.dropTable(TEST_TABLE);
	}
	
	private void createTestTable() throws SQLException {
		CreateTableQuery createTableQuery = new CreateTableQuery(TEST_TABLE).withIntegerField("ID");
		Database.createTable(createTableQuery);
	}

	private void dropTestTable() throws SQLException {
		Database.dropTable(TEST_TABLE);
	}
	
	/* public void testNewConnection() throws SQLException {
		newDbStatement().execute("create table test(id int, text varChar(40))");
		PreparedStatement insert = newInsertStatement("insert into test values (?,?)");
		insert.setInt(1, 1);
		insert.setString(2, "test");
		insert.executeUpdate();
	}
	
	public void testSelectStatement() throws SQLException {
		Collection<TestRecord> testTable = executeSelectQuery();
		assertEquals(1, testTable.size());
		assertTrue(testTable.iterator().next().getId() == 1);
		LOGGER.info(testTable.iterator().next().getId() + " : " + testTable.iterator().next().getText());
		assertEquals("test", testTable.iterator().next().getText());
	} */
	
}
