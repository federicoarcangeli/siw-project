package it.uniroma3.persistence;

import java.util.Date;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.persistence.entity.Comanda;
import it.uniroma3.project.persistence.entity.Tavolo;
import it.uniroma3.project.persistence.entity.Utente;

public class inserimentoComandaTest {
	
	public static void main(String[] args) {
		Facade facade = new Facade();
		Comanda comanda = new Comanda();
		Utente operatore = facade.findUtente("frociombi");
		Tavolo tavolo = facade.findTavoloByNumero("49");
		System.out.println(operatore);
		System.out.println(tavolo);
		comanda.setDataOraEmissione(new Date());
		comanda.setOperatore(operatore);
		comanda.setTavolo(tavolo);
		comanda.setPrezzoTotale(0.0);
		System.out.println(comanda);
		facade.inserisciComanda(comanda);
	}

}
