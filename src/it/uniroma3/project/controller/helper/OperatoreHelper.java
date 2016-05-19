package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
public class OperatoreHelper {

	public OperatoreHelper() {
	}
	
	public boolean validate(HttpServletRequest request){
		String codice,password;
		boolean corretto=true;
		Facade facade = new Facade();
		codice=request.getParameter("codice");
		password = request.getParameter("password");
		if(facade.findUtente(codice)!=null){
			corretto=false;
			request.setAttribute("operatoreError", "Operatore esistente");
		}
		if(codice.equals("")){
			corretto=false;
			request.setAttribute("codiceError", "Codice obbigatorio");
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
