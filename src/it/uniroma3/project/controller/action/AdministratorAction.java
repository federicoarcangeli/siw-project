package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Utente;


public class AdministratorAction {
	public AdministratorAction() {
	}

	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		Utente amministratore = facade.findUtente(request.getParameter("username"));
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(-1); //la sessione non scade mai
		session.setAttribute("amministratoreCorrente", amministratore);

		return "/home_Administrator.jsp";
	}

}