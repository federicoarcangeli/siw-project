package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.DateValidator;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Tavolo;
import it.uniroma3.project.entity.Utente;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.validator.Time24HoursValidator;

public class PrenotazioneAction {

	public PrenotazioneAction() {
	}

	public String execute(HttpServletRequest request) {

		Facade facade = new Facade();
		DateValidator validator = new DateValidator();
		Time24HoursValidator validatorTime = new Time24HoursValidator();
		Ristorante prenotazioneModel = new Ristorante(Integer.parseInt(request.getParameter("ospiti")));

		HttpSession session = request.getSession();
		Utente utente = (Utente) session.getAttribute("utenteCorrente");
		Prenotazione prenotazione = new Prenotazione(validator.validate(request.getParameter("data")),
				validatorTime.validate(request.getParameter("ora")), Integer.parseInt(request.getParameter("ospiti")),
				utente);
		Tavolo tavolo = prenotazioneModel.setTavoloPrenotazione(facade.findAllTavolo());
		prenotazione.setTavoloPrenotato(tavolo);
		facade.inserisciPrenotazione(prenotazione);

		session.setAttribute("PRENOTAZIONE", prenotazione);

		return "/conferma.jsp";
	}

}
