package it.uniroma3.project.model;

import java.util.List;

import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Tavolo;

public class Ristorante {
	private int numeroOspiti;

	public Ristorante(int numeroOspiti) {
		this.numeroOspiti = numeroOspiti;
	}
	
	public Tavolo setTavoloPrenotazione(List<Tavolo> tavoli) {
		int posti = this.numeroOspiti;
		for(Tavolo t : tavoli) {
			if(posti == t.getCoperti()) {
				return t;
			} else {
				posti++;
			}
		}
		return null;
	}

}
