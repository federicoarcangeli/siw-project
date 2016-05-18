package it.uniroma3.project.model;

import it.uniroma3.project.entity.Prenotazione;

public class PrenotazioneModel {
	private Prenotazione prenotazione;
	private Ristorante ristorante;

	public PrenotazioneModel(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

	/**
	 * verifica se il numero di posti della prenotazione sia minore dei posti
	 * attualmente disponibili nel ristorante
	 * 
	 * @param prenotazione
	 * @param ristorante
	 * @return
	 */
	public boolean checkPosti(Prenotazione prenotazione, Ristorante ristorante) {
		return prenotazione.getNumeroOspiti() < ristorante.getNumeroPosti();
	}
	
	public void occupaPosti(Prenotazione prenotazione, Ristorante ristorante) {
		ristorante.setNumeroPosti(ristorante.getNumeroPosti() - prenotazione.getNumeroOspiti());
	}
	
	public void liberaPosti(Prenotazione prenotazione, Ristorante ristorante) {
		ristorante.setNumeroPosti(ristorante.getNumeroPosti() + prenotazione.getNumeroOspiti());
	}

}
