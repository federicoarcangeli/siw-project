/*Da sistemare nei package corretti
 * test mischiati comanda e lineacomanda*/
package it.uniroma3.persistence;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.model.LineaComanda;
import it.uniroma3.project.model.Piatto;

public class inserimentoLineeComandaTest {
	
	private Facade facade;
	private Comanda comanda;
	private Piatto piatto;
	private LineaComanda linea;

	@Before
	public void setUp() throws Exception {
		this.facade = new Facade();
		this.comanda = facade.findComandaById(270L);
		this.piatto = facade.findPiattoById(1L);
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
	public void testSizeLineeComanda() {
		assertNotEquals(1, this.comanda.getLineeComanda().size());
	}
	
	@Test
	public void testUpdateNumeroLineaComandaPiattoGiaPresente() {
		LineaComanda l1 = new LineaComanda();
		l1.setPiatto(this.piatto);
		
	}
	
	@Test
	public void testControlloQuantitaLineaComanda() {
		
	}

//	@Test
//	public void testInserisciLinea() {
//		this.linea.setComanda(comanda);
//		this.linea.setPiatto(this.piatto);
//		this.linea.setQuantita(1);
//		this.comanda.updatePrice(this.piatto.getDescrizionePiatto().getPrezzo());
//		this.comanda.addLineeComanda(this.linea);
//		facade.updateComanda(comanda);
//		
//	}

}

