package br.com.rafaelsoto.java2sql.core;

import java.util.Map;

public class ColumnValueUtil {

	public static void addColumnValue(Map<String, Object> columnsValues, String column, Object value)
	{
		columnsValues.put(column, value);
	}
	
	public static void addColumnValue(Map<String, Object> columnsValues,String column, String value,DataType dataType)
	{
		
		if(dataType == DataType.CHAR)
			columnsValues.put(column, value);
		else if(dataType == DataType.INTEGER)
			columnsValues.put(column, new Integer(value));
		else if(dataType == DataType.DECIMAL)
			columnsValues.put(column, new Double(value));
		else if(dataType == DataType.BOOLEAN)
			columnsValues.put(column, new Boolean(value));
		else if(dataType == DataType.BOOLEAN)
			columnsValues.put(column, new Boolean(value));
	}
	
	public static void addListColumnValue(Map<String, Object> columnsValues,Map<String, Object> columnValueMap)
	{
		
		for (String column : columnValueMap.keySet()) {
			
			columnsValues.put(column, columnValueMap.get(column));
		}
		
	}
}
