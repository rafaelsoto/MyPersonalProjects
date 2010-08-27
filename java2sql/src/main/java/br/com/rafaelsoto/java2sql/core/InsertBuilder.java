package br.com.rafaelsoto.java2sql.core;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InsertBuilder {
	
	
	private String tablename;
	
	
	private Map<String, Object> columnsValues;
	
	
	public InsertBuilder(String tablename) {
	
		this.tablename = tablename;
		this.columnsValues = new HashMap<String, Object>();
	}
	
	@Override
	public String toString() {
	
		
		StringBuffer columns = new StringBuffer();
		StringBuffer values = new StringBuffer();
		
		
		columns.append("(");
		values.append("(");
		
		for (String column : this.columnsValues.keySet()) {
			
			columns.append(column).append(",");
			
			if(this.columnsValues.get(column) instanceof String)
				values.append("'").append(this.columnsValues.get(column).toString().replace("'", "\\'")).append("'").append(",");
			else if(this.columnsValues.get(column) instanceof Date || this.columnsValues.get(column) instanceof Character)
				values.append("'").append(this.columnsValues.get(column)).append("'").append(",");
			else
			values.append(this.columnsValues.get(column)).append(",");
			
		}
		
		columns.deleteCharAt(columns.length() - 1).append(")");
		values.deleteCharAt(values.length() - 1).append(")");
		
		return "INSERT INTO " + this.getTablename() + " " + columns + " VALUES " + values + ";";
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public Map<String, Object> getColumnsValues() {
		return columnsValues;
	}

	public void setColumnsValues(Map<String, Object> columnsValues) {
		this.columnsValues = columnsValues;
	}
	
	public void addColumnValue(String column, Object value)
	{
	
		ColumnValueUtil.addColumnValue(this.columnsValues, column, value);		
		
	}
	
	public void addColumnValue(String column, String value,DataType dataType)
	{
		
		ColumnValueUtil.addColumnValue(this.columnsValues, column, value, dataType);

	}
	
	public void addListColumnValue(Map<String, Object> columnValueMap)
	{
		
		ColumnValueUtil.addListColumnValue(this.columnsValues,columnValueMap);
		
	}
	
	
}
