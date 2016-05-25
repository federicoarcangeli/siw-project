package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.persistence.entity.Utente;


public class LoginUtenteAction {
	public LoginUtenteAction() {
	}

	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		Utente utente = facade.findUtente(request.getParameter("username"));
		facade.closeEntityManager();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(-1); // la sessione non viene mai terminata
		session.setAttribute("utenteCorrente", utente);
		return "/home_Utente.jsp";
	}

}