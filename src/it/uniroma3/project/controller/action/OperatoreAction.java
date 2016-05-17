package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Operatore;
import it.uniroma3.security.MD5Encrypter;

public class OperatoreAction {


	public OperatoreAction() {
	}

	public String execute(HttpServletRequest request) {
		Operatore operatore = new Operatore();
		Facade facade = new Facade();
		MD5Encrypter encrypter = new MD5Encrypter();


		operatore.setCodice(request.getParameter("codice"));
		operatore.setPassword(encrypter.cryptWithMD5(request.getParameter("password")));
//		this.sendMail(request.getParameter("email"));

		facade.inserisciOperatore(operatore);


		return "/home_Administrator.jsp";
	}

	

}