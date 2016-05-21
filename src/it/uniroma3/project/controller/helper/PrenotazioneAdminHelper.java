package it.uniroma3.project.controller.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.validator.routines.DateValidator;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Tavolo;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.validator.Time24HoursValidator;

public class PrenotazioneAdminHelper {

	public PrenotazioneAdminHelper() {
	}

	public boolean validate(HttpServletRequest request) {
		String data, ora, ospiti, nominativo;
		boolean corretto = true;
		nominativo = request.getParameter("nominativo");
		data = request.getParameter("data");
		ora = request.getParameter("ora");
		ospiti = request.getParameter("ospiti");

		DateValidator validator = new DateValidator();
		Time24HoursValidator validatorTime = new Time24HoursValidator();

		Facade facade = new Facade();
		List<Tavolo> tavoli = facade.findAllTavolo();
		List<Prenotazione> prenotazioni = facade.findAllPrenotazioni();
		Ristorante checkTavoli = new Ristorante(Integer.parseInt(ospiti));

		/*
		 * recupero il giorno della prenotazione - non si può prenotare per un
		 * altro mese lo stesso giorno adesso
		 */
		String reservationDate = data.substring(0, 2);
		System.out.println("reservationDate:" + reservationDate);
		Integer resDate = Integer.parseInt(reservationDate);
		/*controllo prima se esiste un tavolo che rispetta il numero di posti scelto*/
		Tavolo t = checkTavoli.setTavoloPrenotazione(tavoli);

		if (t == null) {
			corretto = false;
			request.setAttribute("tavoliError", "Non ci sono tavoli disponibili per questo numero di ospiti");
		}
		
		/*controllo se è libero per il giorno scelto*/
		if (t != null) {
			if (!checkTavoli.checkTavoloLiberoToday(prenotazioni, t, resDate)) {
				corretto = false;
				request.setAttribute("prenotazioniError", "Non ci sono tavoli disponibili per oggi");
			}
		}

		if (nominativo.equals("")) {
			corretto = false;
			request.setAttribute("nominativoError", "Nominativo obbligatorio");
		}
		if (validator.validate(data) == null) {
			corretto = false;
			request.setAttribute("dataError", "Formato data non valido");
		}
		if (data.equals("")) {
			corretto = false;
			request.setAttribute("dataError", "Data obbigatoria");
		}
		if (validatorTime.validate(ora) == null) {
			corretto = false;
			request.setAttribute("oraError", "Formato ora non valido");
		}
		if (ora.equals("")) {
			corretto = false;
			request.setAttribute("oraError", "Ora obbligatoria");
		}
		if (ospiti.equals("vuoto")) {
			corretto = false;
			request.setAttribute("ospitiError", "Numero ospiti obbligatorio");
		}
		if (corretto == false) {
			request.setAttribute("ERROR", "error");
		}
		return corretto;
	}

}
