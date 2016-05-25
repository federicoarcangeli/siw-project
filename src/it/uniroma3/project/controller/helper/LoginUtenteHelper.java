package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.Utente;
import it.uniroma3.project.services.security.MD5Encrypter;
public class LoginUtenteHelper {

	public LoginUtenteHelper() {
	}

	public boolean validate(HttpServletRequest request){
		Facade facade = new Facade();
		MD5Encrypter encrypter = new MD5Encrypter();
		String username;
		String password;
		boolean corretto=true;

		Utente utente = facade.findUtente(request.getParameter("username"));
		facade.closeEntityManager();
		username= request.getParameter("username");
		password = request.getParameter("password");

		if(utente==null || !utente.getRole().equals("utente")){
			corretto=false;
			request.setAttribute("loginError", "Utente non esistente");
		}else {
			if(!(utente.getPassword().equals(encrypter.cryptWithMD5(password)))){
				corretto=false;
				request.setAttribute("loginError", "Username e/o Password errata");
			}
		}
		
		if(username.equals("")){
			corretto=false;
			request.setAttribute("usernameError", "Username obbigatoria");
		}
		if(password.equals("")){
			corretto=false;
			request.setAttribute("passwordError", "Password obbligatoria");
		}	
		if(corretto==false){
			request.setAttribute("ERROR", "error");
		}
		return corretto;
	}

}
