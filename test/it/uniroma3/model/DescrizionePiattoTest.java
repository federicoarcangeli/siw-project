package it.uniroma3.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.DescrizionePiatto;
import it.uniroma3.project.model.Piatto;

public class DescrizionePiattoTest {
	
	private DescrizionePiatto descrizione;
	private Facade facade;
	private List<Piatto> piatti;

	@Before
	public void setUp() throws Exception {
		this.descrizione = new DescrizionePiatto();
		this.facade = new Facade();
		this.piatti = facade.findAllPiatti();
	}

	@Test
	public void testInitUrl() {
		assertEquals("img/menu/2/1.jpg", this.descrizione.getUrlImmagine());
	}
	
	@Test
	public void test() {
		for(Piatto p : this.piatti) {
			System.out.println(p.getDescrizionePiatto().getUrlImmagine());
		}
	}

}
