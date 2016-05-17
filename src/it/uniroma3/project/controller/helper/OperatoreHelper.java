package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;
public class OperatoreHelper {

	public OperatoreHelper() {
	}
	
	public boolean validate(HttpServletRequest request){
		String codice,password;
		boolean corretto=true;
		codice=request.getParameter("codice");
		password = request.getParameter("password");

		if(codice.equals("")){
			corretto=false;
			request.setAttribute("nomeError", "Nome obbigatorio");
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
