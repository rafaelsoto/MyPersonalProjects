package br.com.rafaelsoto.java2sql.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UpdateBuilderTest {

	@Test
	public void testToString() {

		UpdateBuilder ub = new UpdateBuilder("pais");

		ub.addColumnValueUpdate("id", 3);
		ub.addColumnValueUpdate("nome", "Marcelo Soto");
		ub.addColumnValueUpdate("casado", false);


		ub.addColumnValueRestriction("id", 3);
		ub.addColumnValueRestriction("nome", "Rafael Soto");

		assertEquals("UPDATE pais SET id=3,nome='Marcelo Soto',casado=false WHERE id=3 AND nome='Rafael Soto';", ub.toString());

	}

}
