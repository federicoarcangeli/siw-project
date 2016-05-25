package it.uniroma3.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.project.model.ComandaModel;
import it.uniroma3.project.persistence.entity.Comanda;

public class ComandaModelTest {
	private Comanda comanda;
	private ComandaModel model;

	@Before
	public void setUp() throws Exception {
		this.comanda = new Comanda();
		this.model = new ComandaModel(this.comanda);
	}

	@Test
	public void testComandaPrice0() {
		assertEquals(0.0, this.comanda.getPrezzoTotale(),0);
	}
	
	@Test
	public void updatePrice() {
		this.comanda = this.model.updatePrice(2D);
		assertEquals(2.0, this.comanda.getPrezzoTotale(),0);
	}

}
