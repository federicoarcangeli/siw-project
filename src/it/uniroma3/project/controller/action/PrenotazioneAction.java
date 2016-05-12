package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.DateValidator;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.validator.Time24HoursValidator;

public class PrenotazioneAction {

	public PrenotazioneAction() {
	}

	public String execute(HttpServletRequest request){
		Prenotazione prenotazione = new Prenotazione();
		Facade facade= new Facade();
		DateValidator validator = new DateValidator();
		Time24HoursValidator validatorTime = new Time24HoursValidator();

		HttpSession session = request.getSession();

		prenotazione.setData(validator.validate(request.getParameter("data")));
//		prenotazione.setNome(request.getParameter("nome"));
		prenotazione.setOra(validatorTime.validate(request.getParameter("ora")));
//		prenotazione.setEmail(request.getParameter("email"));
		prenotazione.setNumeroOspiti(Integer.parseInt(request.getParameter("ospiti")));
//		prenotazione.setTelefono(request.getParameter("telefono"));

		facade.inserisciPrenotazione(prenotazione);

		session.setAttribute("PRENOTAZIONE", prenotazione);

		return "/conferma.jsp";
	}

}
