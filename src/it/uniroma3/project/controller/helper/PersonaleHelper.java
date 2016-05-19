package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
public class PersonaleHelper {

	public PersonaleHelper() {
	}

	public boolean validate(HttpServletRequest request){
		boolean corretto=true;
		Facade facade = new Facade();
		String codice=request.getParameter("codice");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		if(facade.findUtente(codice)!=null){
			corretto=false;
			request.setAttribute("personaleeError", "Personale esistente");
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
		return corretto;
	}

}
