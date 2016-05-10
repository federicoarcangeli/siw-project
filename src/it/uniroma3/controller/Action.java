package it.uniroma3.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
//import org.apache.commons.validator.routines.DateValidator;
import it.uniroma3.project.model.Prenotazione;

public class Action {

	public Action() {
		// TODO Auto-generated constructor stub
	}
	
	public String execute(HttpServletRequest request){
		Prenotazione prenotazione = new Prenotazione();
		Facade facade= new Facade();
//		DateValidator validator = new DateValidator();
		DateFormat data = new SimpleDateFormat("mm/dd/yyyy");
		DateFormat ora = new SimpleDateFormat("hh:mm");
		
		
//		HttpSession session = request.getSession();
//	
		try {
			prenotazione.setData(data.parse(request.getParameter("data")));
		} catch (ParseException e) {
		} 
		prenotazione.setNome(request.getParameter("nome"));
		try {
			prenotazione.setOra(ora.parse(request.getParameter("ora")));
		} catch (ParseException e) {
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
