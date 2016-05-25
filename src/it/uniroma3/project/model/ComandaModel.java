package it.uniroma3.project.model;

import it.uniroma3.project.persistence.entity.Comanda;

public class ComandaModel {
	
	private Comanda comanda;
	
	public ComandaModel(Comanda comanda) {
		this.comanda = new Comanda();
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	
	public Comanda updatePrice(double price) {
		this.comanda.setPrezzoTotale(this.comanda.getPrezzoTotale()+price);
		return this.comanda;
	}
	
	
	
	

}
