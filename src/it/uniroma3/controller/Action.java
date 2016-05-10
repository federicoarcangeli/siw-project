package it.uniroma3.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.DateValidator;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.validator.Time24HoursValidator;

public class Action {

	public Action() {
		// TODO Auto-generated constructor stub
	}

	public String execute(HttpServletRequest request){
		Prenotazione prenotazione = new Prenotazione();
		Facade facade= new Facade();
		DateValidator validator = new DateValidator();
		Time24HoursValidator validatorTime = new Time24HoursValidator();

		//		HttpSession session = request.getSession();

		prenotazione.setData(validator.validate(request.getParameter("data")));
		prenotazione.setNome(request.getParameter("nome"));
		prenotazione.setOra(validatorTime.validate(request.getParameter("ora")));
		prenotazione.setEmail(request.getParameter("email"));
		prenotazione.setNumeroCoperti(Integer.parseInt(request.getParameter("ospiti")));
		prenotazione.setTelefono(request.getParameter("telefono"));

		facade.inserisciPrenotazione(prenotazione);
		request.setAttribute("prenotazione", prenotazione);
		//		session.setAttribute("PRENOTAZIONE", prenotazione);

		return "/Conferma.jsp";
	}

}
