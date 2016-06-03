package it.uniroma3.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.project.controller.CategoriaPiattoManagedBean;

public class CategoriaPiattoControllerTest {
	
	private CategoriaPiattoManagedBean controllertest;

	@Before
	public void setUp() throws Exception {
		this.controllertest = new CategoriaPiattoManagedBean();
	}

	@Test
	public void test() {
		assertNull(this.controllertest.getList());
	}

}
