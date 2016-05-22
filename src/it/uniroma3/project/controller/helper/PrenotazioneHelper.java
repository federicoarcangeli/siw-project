package it.uniroma3.project.controller.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.DateValidator;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Tavolo;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.validator.Time24HoursValidator;

public class PrenotazioneHelper {

	public PrenotazioneHelper() {
	}

	public boolean validate(HttpServletRequest request) {
		boolean corretto = true;
		Facade facade = new Facade();
		DateValidator validator = new DateValidator();
		Time24HoursValidator validatorTime = new Time24HoursValidator();


		HttpSession session = request.getSession(true);

		String data = request.getParameter("data");
		String ora = request.getParameter("ora");
		String ospiti = request.getParameter("ospiti");

		List<Tavolo> tavoli = facade.findAllTavolo();

		List<Prenotazione> prenotazioni = facade.findAllPrenotazioni();

		Ristorante checkTavoli = new Ristorante(Integer.parseInt(ospiti));
		List<Tavolo> t = checkTavoli.setTavoloPrenotazione(tavoli);
		Tavolo tav = checkTavoli.checkTavoliLiberoToday(prenotazioni, t, validator.validate(data));

		if (t == null) {
			corretto = false;
			request.setAttribute("tavoliError", "Non ci sono tavoli disponibili per questo numero di ospiti");
		}
		if (t != null) {
			if (tav==null) {
				corretto = false;
				request.setAttribute("prenotazioniError", "Non ci sono tavoli disponibili per il " + data);
			}
			else{
				session.setAttribute("tavoloAssegnato", tav);
			}
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
