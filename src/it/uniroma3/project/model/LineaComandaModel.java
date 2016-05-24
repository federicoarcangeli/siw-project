package it.uniroma3.project.model;

import it.uniroma3.project.persistence.entity.LineaComanda;

public class LineaComandaModel {
	
	private LineaComanda lineaComanda;
	
	public LineaComandaModel(LineaComanda lineaComanda) {
		this.lineaComanda = lineaComanda;
	}
	
	
	
	public LineaComanda getLineaComanda() {
		return lineaComanda;
	}



	public void setLineaComanda(LineaComanda lineaComanda) {
		this.lineaComanda = lineaComanda;
	}



	public void updateQuantity(int quantity) {
		this.lineaComanda.setQuantita(this.lineaComanda.getQuantita()+quantity);
	}
	
	public void updateQuantity() {
		this.updateQuantity(1);
	}

}
