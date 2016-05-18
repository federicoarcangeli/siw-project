package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Utente;

public class ProfiloAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {

		Facade facade = new Facade();
		HttpSession session = request.getSession(true);
		Utente utente = (Utente)session.getAttribute("utenteCorrente");
		List<Prenotazione> prenotazioni = facade.findAllPrenotazioniUtente(utente.getEmail());
		request.setAttribute("prenotazioni", prenotazioni);
		return "/profilo.jsp";
	}
}