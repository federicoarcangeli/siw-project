package it.uniroma3.project.controller.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.DateValidator;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.persistence.entity.Prenotazione;
import it.uniroma3.project.persistence.entity.Tavolo;
import it.uniroma3.project.services.validator.*;

public class PrenotazioneAdminAction {

	public PrenotazioneAdminAction() {
	}

	public String execute(HttpServletRequest request) {

		Facade facade = new Facade();
		DateValidator validator = new DateValidator();
		Time24HoursValidator validatorD = new Time24HoursValidator();

		Date data = validator.validate(request.getParameter("data"));
		int ospiti = Integer.parseInt(request.getParameter("ospiti"));
		Date ora = validatorD.validate(request.getParameter("ora"));
		String nominativo = request.getParameter("nominativo");

		HttpSession session = request.getSession();

		Tavolo tavolo = (Tavolo) session.getAttribute("tavoloAssegnato");

		Prenotazione prenotazione = new Prenotazione(data, ora, ospiti,	nominativo);
		prenotazione.setTavoloPrenotato(tavolo);

		facade.inserisciPrenotazione(prenotazione);

		if(validatorD.isToday(data))
			facade.setTavoloPrenotato(tavolo);
		facade.closeEntityManager();

		return "/prenotazioneAdmin.jsp";
	}

}
