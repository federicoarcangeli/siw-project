package it.uniroma3.persistence;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.persistence.entity.Comanda;
import it.uniroma3.project.persistence.entity.LineaComanda;
import it.uniroma3.project.persistence.entity.Piatto;

public class inserimentoLineeComandaTest {
	
	private Facade facade;
	private Comanda comanda;
	private Piatto piatto;
	private LineaComanda linea;

	@Before
	public void setUp() throws Exception {
		this.facade = new Facade();
//		this.comanda = facade.findComandaById(219L);
//		this.piatto = facade.findPiattoById(1L);
		this.linea = new LineaComanda();
	}
	
	@Test
	public void testComandaEsistente() {
		assertNotNull(this.comanda);
	}
	
	@Test
	public void testPiattoEsistente() {
		assertNotNull(this.piatto);
	}

	@Test
	public void testInserisciLinea() {
		this.linea.setComanda(this.comanda);
		this.linea.setPiatto(this.piatto);
		this.linea.setQuantita(1);
//		facade.updateComanda(comanda);
		
	}

}
