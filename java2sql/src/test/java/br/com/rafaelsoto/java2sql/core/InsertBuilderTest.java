package br.com.rafaelsoto.java2sql.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.rafaelsoto.java2sql.core.postgres.PostgresSequence;

public class InsertBuilderTest {

	@Test
	public void testToString()
	{
		
	InsertBuilder ib = new InsertBuilder("pais");
		
		ib.addColumnValue("id", 3);
		ib.addColumnValue("nome", "Rafael Soto");
		ib.addColumnValue("casado", false);
		
		assertEquals("INSERT INTO pais (id,nome,casado) VALUES (3,'Rafael Soto',false);", ib.toString());
		
	}
	
	@Test
	public void testPostgresSequence()
	{
		
		InsertBuilder ib = new InsertBuilder("pais");
		
		ib.addColumnValue("id", new PostgresSequence("seq_pais"));
		ib.addColumnValue("nome", "Rafael Soto");
		ib.addColumnValue("casado", false);
		
		assertEquals("INSERT INTO pais (id,nome,casado) VALUES (nextval('seq_pais'),'Rafael Soto',false);", ib.toString());
		
		
		
	}
	
}
