package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Utente;
import it.uniroma3.validator.MD5Encrypter;

public class RegistrazioneAction {

	public RegistrazioneAction() {
	}

	public String execute(HttpServletRequest request){
		Utente utente = new Utente();
		Facade facade= new Facade();
		MD5Encrypter encrypter = new MD5Encrypter();

		HttpSession session = request.getSession();

		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setEmail(request.getParameter("email"));
		utente.setTelefono(request.getParameter("telefono"));
		utente.setPassword(encrypter.cryptWithMD5(request.getParameter("password")));

		facade.inserisciUtente(utente);

		session.setAttribute("utenteCorrente", utente);

		return "/conferma.jsp";
	}

}
