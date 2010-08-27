package br.com.rafaelsoto.java2sql.core.postgres;

public class PostgresSequence {

	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
	
		return "nextval('"+ this.name + "')";
	}
	
	public PostgresSequence(String name) {
		this.name = name;
	}
	
}
