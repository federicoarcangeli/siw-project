package it.uniroma3.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.project.model.CategoriaPiatto;

public class CategoriaPiattoTest {
	private CategoriaPiatto c1;
	private CategoriaPiatto c2;

	@Before
	public void setUp() throws Exception {
		this.c1 = new CategoriaPiatto();
		this.c1.setNome("primi");
		this.c1.setId(1L);
	}

	@Test
	public void testEquals() {
		this.c2 = new CategoriaPiatto();
		this.c2.setNome("primi");
		this.c2.setId(1L);
		assertTrue(this.c1.equals(this.c2));
	}
	
	@Test
	public void testHashCode() {
		this.c2 = new CategoriaPiatto();
		this.c2.setNome("primi");
		this.c2.setId(1L);
		assertTrue(this.c1.hashCode()==this.c2.hashCode());
	}

}
