package it.uniroma3.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.DateValidator;
import it.uniroma3.project.model.Prenotazione;

public class Action {

	public Action() {
		// TODO Auto-generated constructor stub
	}

	public String execute(HttpServletRequest request){
		Prenotazione prenotazione = new Prenotazione();
		Facade facade= new Facade();
		DateValidator validator = new DateValidator();
		DateFormat formatter = new SimpleDateFormat("hh:mm");

		//		HttpSession session = request.getSession();

		prenotazione.setData(validator.validate(request.getParameter("data")));
		prenotazione.setNome(request.getParameter("nome"));
		try {
			prenotazione.setOra(formatter.parse(request.getParameter("ora")));
		} catch (ParseException e) {
			prenotazione.setOra(null);
		}
		prenotazione.setEmail(request.getParameter("email"));
		prenotazione.setNumeroCoperti(Integer.parseInt(request.getParameter("ospiti")));
		prenotazione.setTelefono(request.getParameter("telefono"));

		facade.inserisciPrenotazione(prenotazione);
		request.setAttribute("prenotazione", prenotazione);
		//		session.setAttribute("PRENOTAZIONE", prenotazione);

		return "/Conferma.jsp";
	}

}
