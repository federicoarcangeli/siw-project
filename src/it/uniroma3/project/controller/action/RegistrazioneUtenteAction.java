package it.uniroma3.project.controller.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.services.mail.*;
import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.persistence.entity.Utente;
import it.uniroma3.security.MD5Encrypter;

public class RegistrazioneUtenteAction {

	public RegistrazioneUtenteAction() {
	}

	public String execute(HttpServletRequest request) {
		Utente utente = new Utente();
		Facade facade = new Facade();
		MD5Encrypter encrypter = new MD5Encrypter();
		EmailManager mail = new EmailManager();

		HttpSession session = request.getSession();

		utente.setUsername(request.getParameter("username"));
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setEmail(request.getParameter("email"));
		utente.setTelefono(request.getParameter("telefono"));
		utente.setPassword(encrypter.cryptWithMD5(request.getParameter("password")));
		utente.setRole("utente");
		//mail.sendMail(request.getParameter("email"));

		facade.inserisciUtente(utente);

		session.setAttribute("utenteCorrente", utente);

		return "/home_Utente.jsp";
	}


}