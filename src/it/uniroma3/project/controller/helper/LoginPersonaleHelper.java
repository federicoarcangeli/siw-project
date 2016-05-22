package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Utente;
import it.uniroma3.security.MD5Encrypter;
public class LoginPersonaleHelper {

	public LoginPersonaleHelper() {
	}

	public boolean validate(HttpServletRequest request){
		Facade facade = new Facade();
		MD5Encrypter encrypter = new MD5Encrypter();
		String username;
		String password;
		boolean corretto=true;

		Utente personale = facade.findUtente(request.getParameter("username"));

		username = request.getParameter("username");
		password = request.getParameter("password");
		

		if(personale==null){
			corretto=false;
			request.setAttribute("loginError", "Utente non esistente");
		}else {
			if(!(personale.getPassword().equals(encrypter.cryptWithMD5(password)))){
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
