package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.persistence.entity.Prenotazione;
import it.uniroma3.project.persistence.entity.Utente;

public class ProfiloAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {

		Facade facade = new Facade();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(-1);
		Utente utente = (Utente)session.getAttribute("utenteCorrente");
		List<Prenotazione> prenotazioni = facade.findAllPrenotazioniUtente(utente.getId());
		facade.closeEntityManager();
		request.setAttribute("prenotazioni", prenotazioni);
		return "/profilo.jsp";
	}
}