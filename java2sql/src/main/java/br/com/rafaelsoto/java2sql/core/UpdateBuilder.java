package br.com.rafaelsoto.java2sql.core;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UpdateBuilder {

	private String tablename;
	
	private Map<String, Object> columnsValuesUpdate;
	
	private Map<String, Object> columnsValuesRestriction;
	
	
	public UpdateBuilder(String tablename) {
	
		this.tablename = tablename;
		this.columnsValuesUpdate = new HashMap<String, Object>();
		this.columnsValuesRestriction = new HashMap<String, Object>();
	}
	
	@Override
	public String toString() {
		
		StringBuffer columnsValue = new StringBuffer();
		StringBuffer sbRestriction = new StringBuffer();
		
		
		
		for (String column : this.columnsValuesUpdate.keySet()) {
			
			columnsValue.append(column).append("=");
			
			if(this.columnsValuesUpdate.get(column) instanceof String || this.columnsValuesUpdate.get(column) instanceof Date)
				columnsValue.append("'").append(this.columnsValuesUpdate.get(column).toString().replace("'","\\'")).append("'").append(",");
			else
				columnsValue.append(this.columnsValuesUpdate.get(column)).append(",");
			
		}
		
		columnsValue.deleteCharAt(columnsValue.length() - 1);
		
		
		if(columnsValuesRestriction.size() > 0)
		{
			
			sbRestriction.append(" WHERE ");
			
			for (String column : this.columnsValuesRestriction.keySet()) {
				
				sbRestriction.append(column).append("=");
				
				if(this.columnsValuesRestriction.get(column) instanceof String || this.columnsValuesRestriction.get(column) instanceof Date)
					sbRestriction.append("'").append(this.columnsValuesRestriction.get(column)).append("'").append(" AND ");
				else
					sbRestriction.append(this.columnsValuesRestriction.get(column)).append(" AND ");
				
			}
			
			sbRestriction.delete(sbRestriction.length() - 5, sbRestriction.length());
			
			
		}
		
		return "UPDATE " + this.getTablename() + " SET " + columnsValue + sbRestriction + ";";
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public Map<String, Object> getColumnsValuesUpdate() {
		return columnsValuesUpdate;
	}

	public void setColumnsValuesUpdate(Map<String, Object> columnsValuesUpdate) {
		this.columnsValuesUpdate = columnsValuesUpdate;
	}

	public Map<String, Object> getColumnsValuesRestriction() {
		return columnsValuesRestriction;
	}

	public void setColumnsValuesRestriction(
			Map<String, Object> columnsValuesRestriction) {
		this.columnsValuesRestriction = columnsValuesRestriction;
	}
	
	public void addColumnValueUpdate(String column, Object value)
	{
	
		ColumnValueUtil.addColumnValue(this.columnsValuesUpdate, column, value);		
		
	}
	
	public void addColumnValueUpdate(String column, String value,DataType dataType)
	{
		
		ColumnValueUtil.addColumnValue(this.columnsValuesUpdate, column, value, dataType);

	}
	
	public void addListColumnValueUpdate(Map<String, Object> columnValueMap)
	{
		
		ColumnValueUtil.addListColumnValue(this.columnsValuesUpdate,columnValueMap);
		
	}
	
	public void addColumnValueRestriction(String column, Object value)
	{
	
		ColumnValueUtil.addColumnValue(this.columnsValuesRestriction, column, value);		
		
	}
	
	public void addColumnValueRestriction(String column, String value,DataType dataType)
	{
		
		ColumnValueUtil.addColumnValue(this.columnsValuesRestriction, column, value, dataType);

	}
	
	public void addListColumnValueRestriction(Map<String, Object> columnValueMap)
	{
		
		ColumnValueUtil.addListColumnValue(this.columnsValuesRestriction,columnValueMap);
		
	}
	
}
