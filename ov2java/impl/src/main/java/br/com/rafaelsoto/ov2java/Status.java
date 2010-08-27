package br.com.rafaelsoto.ov2java;

public enum Status {

	DELETED (0),
	SKIPPER (1),
	SIMPLE (2),
	EXTENDED (3);
	
	private final int status;
	
	Status(int status)
	{
		this.status = status;
	}
	
	public int status()
	{
		return this.status;
	}
	
	
}
