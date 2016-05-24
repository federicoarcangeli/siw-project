package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.persistence.entity.Utente;
import it.uniroma3.security.MD5Encrypter;

public class RegistrazionePersonaleAction {


	public RegistrazionePersonaleAction() {
	}

	public String execute(HttpServletRequest request) {
		Utente personale = new Utente();
		Facade facade = new Facade();
		MD5Encrypter encrypter = new MD5Encrypter();


		personale.setUsername(request.getParameter("username"));
		personale.setPassword(encrypter.cryptWithMD5(request.getParameter("password")));
		personale.setRole(request.getParameter("role"));
		facade.inserisciUtente(personale);

		return "/home_Administrator.jsp";
	}



}