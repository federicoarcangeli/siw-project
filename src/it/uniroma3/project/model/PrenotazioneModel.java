package it.uniroma3.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.persistence.entity.Prenotazione;
import it.uniroma3.project.persistence.entity.Tavolo;
import it.uniroma3.project.services.validator.Time24HoursValidator;

public class PrenotazioneModel {
	private static int MAX = 15;

	public PrenotazioneModel() {
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
	}

}
