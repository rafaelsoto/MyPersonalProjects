package br.com.rafaelsoto.ov2java.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.rafaelsoto.ov2java.Ov2Processor;

public class OV2ProcessorTest {

	@Test
	public void readTest()
	{
		Ov2Processor processor = new Ov2Processor();
		
		processor.read();
		
	}
}
