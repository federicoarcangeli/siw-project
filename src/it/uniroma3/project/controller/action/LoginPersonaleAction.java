package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Utente;


public class LoginPersonaleAction {
	public LoginPersonaleAction() {
	}

	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		Utente personale = facade.findUtente(request.getParameter("username"));
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(-1); //la sessione non scade mai
		session.setAttribute("amministratoreCorrente", personale);
		if(personale.getRole().equals("amministratore")){
			return "/home_Administrator.jsp";
		}else{
			return "/home_Operatore.jsp";
		}
	}

}