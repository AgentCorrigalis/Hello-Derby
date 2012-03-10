package com.corrigalis.helloDerby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Properties;

public class Database {

	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String PROTOCOL = "jdbc:derby:";
	private static final String DB_NAME = "derbyDB";
	private static Database database = null;
	private Connection connection;
	
	private static Connection getConnection() throws SQLException {
		if (database == null) {
			database = new Database();
		}
		return database.connection;
	}
	
	public static boolean tableExists(String tableName) throws SQLException {
		Statement statement = getConnection().createStatement();
		try {
			statement.executeQuery("SELECT * FROM " + tableName);
		} catch (SQLSyntaxErrorException e) {
			if (e.getMessage().equals("Table/View '" + tableName + "' does not exist.")) {
				return false;
			} else {
				throw e;
			}
		}
		return true;
	}
	
	public static void createTable(String tableName) {
		Statement statement = getConnection().createStatement();
		statement.executeUpdate(arg0);
	}
	
	private Database() throws SQLException {
		loadDriver();
		setConnection();
	}
	
	private void loadDriver() {
		try {
			Class.forName(DRIVER).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void setConnection() throws SQLException {
		Properties props = new Properties();
		connection = DriverManager.getConnection(PROTOCOL + DB_NAME + ";create=true", props);
		connection.setAutoCommit(true);
	}
	
}
