package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.Facade;
public class RegistrazionePersonaleHelper {

	public RegistrazionePersonaleHelper() {
	}

	public boolean validate(HttpServletRequest request){
		boolean corretto=true;
		Facade facade = new Facade();
		String codice=request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		if(facade.findUtente(codice)!=null){
			corretto=false;
			facade.closeEntityManager();
			request.setAttribute("personaleError", "Personale esistente");
		}
		if(role.equals("vuoto")){
			corretto=false;
			request.setAttribute("roleError","Ruolo personale obbligatorio");
		}
		if(password.equals("")){
			corretto=false;
			request.setAttribute("passwordError", "Password obbligatoria");
		}
		if(corretto==false){
			request.setAttribute("ERROR", "error");
		}
		else
			request.setAttribute("OK", "L'utente "+ codice + " è stato inserito nel sistema con il ruolo di "+ role);
		return corretto;
	}

}
