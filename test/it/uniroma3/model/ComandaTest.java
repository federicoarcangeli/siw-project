package it.uniroma3.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.model.DescrizionePiatto;
import it.uniroma3.project.model.LineaComanda;
import it.uniroma3.project.model.Piatto;

public class ComandaTest {
	private Comanda comanda;
	private LineaComanda linea1;
	private Piatto p1;
	private DescrizionePiatto d1;

	@Before
	public void setUp() throws Exception {
		this.comanda = new Comanda(new Date(), 0.0);
		this.d1 = new DescrizionePiatto("test", 10.0);
		this.p1 = new Piatto(this.d1);
		this.linea1 = new LineaComanda(this.comanda, this.p1);
	}

	@Test
	public void testNessunaLineaComanda() {
		assertTrue(this.comanda.getLineeComanda().isEmpty());
	}
	
	@Test
	public void testInserisciUnaLineaComandaSize() {
		this.comanda.addLineeComanda(this.linea1);
		assertEquals(1, this.comanda.getLineeComanda().size());
	}
	
	@Test
	public void testMapQuantity() {
		this.comanda.addLineeComanda(this.linea1);
		this.comanda.addLineeComanda(this.linea1);
		Map<LineaComanda, Integer> map = this.comanda.quantitaLinea();
		assertEquals(1, map.size());
		List<LineaComanda> result = this.comanda.toList(map);
		assertEquals(1, result.size());
		assertEquals(2, result.get(0).getQuantita());
	}
	
	@Test
	public void testMapQuantityTwoLinee() {
		this.comanda.addLineeComanda(this.linea1);
		this.comanda.addLineeComanda(this.linea1);
		this.comanda.addLineeComanda(new LineaComanda(this.comanda, new Piatto()));
		Map<LineaComanda, Integer> map = this.comanda.quantitaLinea();
		assertEquals(2, map.size());
		List<LineaComanda> result = this.comanda.toList(map);
		assertEquals(2, result.size());
		assertEquals(1, result.get(0).getQuantita());
		assertEquals(2, result.get(1).getQuantita());
	}
	
	@Test
	public void testQuantitaLineeComandaInserite() {

	}

}
