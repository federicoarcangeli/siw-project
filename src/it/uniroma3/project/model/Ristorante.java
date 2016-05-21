package it.uniroma3.project.model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Tavolo;

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
		Tavolo tavolo = null;
		/*
		 * prima controlla se esiste un tavolo con l'esatto numero di posti
		 * richiesto
		 */
		for (Tavolo t : tavoli) {
			if (posti == t.getCoperti())
				return t;
		}
		/*
		 * In caso negativo controllo gli altri tavoli per trovare un numero di
		 * posti soddisfacente
		 */
		while (posti <= MAX) {
			for (Tavolo t : tavoli) {
				if (posti == t.getCoperti()) {
					tavolo = t;
				}
				posti++;
			}
		}

		return tavolo;

	}

	/**
	 * controlla se il tavolo è libero per la data scelta
	 * 
	 * @return
	 */
	public boolean checkTavoloLiberoToday(List<Prenotazione> prenotazioni, Tavolo t, int day) {
		boolean tavoloLibero = true;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		System.out.println("[Ristorante.java] giorno in cui si vuole prenotare: " + day);
		for (Prenotazione prenotazione : prenotazioni) {
			cal.setTime(prenotazione.getData());
			int reservationDay = cal.get(Calendar.DAY_OF_MONTH);
			System.out.print("[Ristorante.java] reservationDay: " + reservationDay);
			if (day == reservationDay
					&& prenotazione.getTavoloPrenotato().getCodiceTavolo().equals(t.getCodiceTavolo())) {
				/* il tavolo scelto in questo giorno è occupato */
				return false;
			} else {
				tavoloLibero = true;
			}
		}
		return tavoloLibero;
	}

}
