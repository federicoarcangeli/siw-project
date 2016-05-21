package it.uniroma3.project.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Tavolo;
import it.uniroma3.validator.Time24HoursValidator;

public class Ristorante {
	private int numeroOspiti;
	private static int MAX = 15;

	public Ristorante(int numeroOspiti) {
		this.numeroOspiti = numeroOspiti;
	}

	/**
	 * Controlla se c'è un tavolo per il numero di posti
	 * 
	 * @param tavoli
	 * @return
	 */
	public Tavolo setTavoloPrenotazione(List<Tavolo> tavoli) {
		int posti = this.numeroOspiti;
		while (posti <= MAX) {
			for (Tavolo t : tavoli) {
				if (posti == t.getCoperti()) {
					return t;
				}	
			}
			posti++;
		}
		return null;
	}

	/**
	 * controlla se il tavolo è libero per la data scelta
	 * 
	 * @return
	 */
	public boolean checkTavoloLiberoToday(List<Prenotazione> prenotazioni, Tavolo t, Date data) {
		boolean tavoloLibero = true;
		Time24HoursValidator validatorD = new Time24HoursValidator();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		for (Prenotazione prenotazione : prenotazioni) {
			if (validatorD.isToday(data)&& prenotazione.getTavoloPrenotato().getCodiceTavolo().equals(t.getCodiceTavolo())) {
				/* il tavolo scelto in questo giorno è occupato */
				return false;
			} 
		}
		return tavoloLibero;
	}

}
