package it.uniroma3.properties;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.project.persistence.model.Ristorante;
import it.uniroma3.project.persistence.model.Tavolo;

public class PropertiesTestTest {
	private Ristorante ristorante;
	private Tavolo tavolo;

	@Before
	public void setUp() throws Exception {
		this.ristorante = new Ristorante();
		this.tavolo = new Tavolo();
	}

	@Test
	public void testTavoloLibero() {
		assertTrue(this.tavolo.getOccupato()==0);
	}

}
