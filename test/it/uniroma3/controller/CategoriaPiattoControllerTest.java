package it.uniroma3.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.project.controller.CategoriaPiattoController;

public class CategoriaPiattoControllerTest {
	
	private CategoriaPiattoController controllertest;

	@Before
	public void setUp() throws Exception {
		this.controllertest = new CategoriaPiattoController();
	}

	@Test
	public void test() {
		assertNull(this.controllertest.getList());
	}

}
