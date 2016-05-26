package it.uniroma3.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.services.validator.*;

public class Ristorante {
	private static int MAX = 15;

	public Ristorante() {
	}

	/**
	 * 
	 * @param prenotazioni
	 * @param data
	 * @return true se lista prenotazioni contiene la data altrimenti false
	 */
	public boolean containsDate(List<Prenotazione> prenotazioni, Date data) {
		Time24HoursValidator validatorD = new Time24HoursValidator();
		for (Prenotazione p : prenotazioni) 
			if (validatorD.SameDate(data, p.getData()))
				return true;
		return false;
	}

	/**
	 * Controlla se c'è un tavolo per il numero di posti
	 * 
	 * @param tavoli
	 * @return
	 */
	public List<Tavolo> setTavoloPrenotazione(List<Tavolo> tavoli, int numeroOspiti) {
		List<Tavolo> tavoliCompatibili = new ArrayList<>();
		int posti = numeroOspiti;
		while (posti <= MAX) {
			for (Tavolo t : tavoli) {
				if (posti == t.getCoperti()) {
					tavoliCompatibili.add(t);
				}
			}
			posti++;
		}
		return tavoliCompatibili;
	}
	/**
	 * 
	 * @param t
	 * @return true se il tavolo è occupato altrimenti falses
	 */
	public boolean comandaInCorso(Tavolo t){
		for(Comanda c : t.getComande()){
			if(c.isCompletata()==false)
				return true;
		}
		return false;
	}

	/**
	 * controlla se il tavolo è libero per la data scelta
	 * 
	 * @return
	 */
	public Tavolo checkTavoliLiberiForDate(List<Tavolo> tavoliDisponibili, Date data) {

		for (Tavolo t : tavoliDisponibili) {
			if (t.getPrenotazioni().isEmpty())
				return t;
			else if (!this.containsDate(t.getPrenotazioni(), data))
				return t;
		}
		return null;
	}

	public void setUpGiornaliero(){
		Facade facade = new Facade();
		Date today = new Date();
		List<Tavolo> tavoli = facade.findAllTavoliToday(today);
		for(Tavolo t : tavoli){
			if(!facade.findPrenotazione(t, today).isEmpty())
				facade.setTavoloPrenotato(t);
			else
				facade.setTavoloLibero(t);
		}
		facade.closeEntityManager();
	}

}
