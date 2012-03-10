package com.corrigalis.helloDerby;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateTableQuery {

	private String tableName;
	private List<String> tableFields = new ArrayList<String>();
	
	public CreateTableQuery(String tableName) {
		this.tableName = tableName;
	}
	
	public CreateTableQuery withIntegerField(String fieldName) {
		tableFields.add(fieldName + " int");
		return this;
	}
	
	public CreateTableQuery withVarCharField(String fieldName, Integer characters) {
		tableFields.add(fieldName + " varChar(" + characters + ")");
		return this; 
	}
	
	public String build() throws IllegalArgumentException {
		if (tableFields.size() < 1) {
			throw new IllegalArgumentException("Can't build create table query with no table fields");
		}
		StringBuilder query = new StringBuilder();
		query.append("CREATE TABLE " + tableName + " (");
		Iterator<String> tableFieldIterator = tableFields.iterator();
		while (tableFieldIterator.hasNext()) {
			query.append(tableFieldIterator.next());
			if (tableFieldIterator.hasNext()) {
				query.append(", ");
			}
		}
		query.append(")");
		return query.toString();
	}
	
}
