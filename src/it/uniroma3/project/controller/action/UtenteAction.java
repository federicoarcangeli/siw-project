package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Utente;


public class UtenteAction {
	public UtenteAction() {
	}

	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		Utente utente = facade.findUtente(request.getParameter("email"));
		HttpSession session = request.getSession();
		session.setAttribute("utenteCorrente", utente);
		return "/home_Utente.jsp";
	}

}