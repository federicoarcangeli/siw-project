package it.uniroma3.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.validator.routines.DateValidator;
public class Helper {

	public Helper() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean validate(HttpServletRequest request){
		String data,nome,ora,email,ospiti,telefono;
		boolean corretto=true;
		data=request.getParameter("data");
		nome=request.getParameter("nome");
		ora=request.getParameter("ora");
		email=request.getParameter("email");
		ospiti = request.getParameter("ospiti");
		telefono = request.getParameter("telefono");
		
		DateValidator validator = new DateValidator();
		
		
		if(validator.validate(data)==null){
			corretto=false;
			request.setAttribute("dataError", "Formato data non valido");
		}	
		if(data.equals("")){
			corretto=false;
			request.setAttribute("dataError", "data obbigatoria");
		}
		if(nome.equals("")){
			corretto=false;
			request.setAttribute("nomeError", "Nome Obbligatorio");
		}
		if(ora.equals("")){
			corretto=false;
			request.setAttribute("oraError", "Ora obbligatoria");
		}
		if(email.equals("")){ // verifica email con @ 
			corretto=false;
			request.setAttribute("emailError", "email Obbligatorio");
		}
		if(ospiti.equals("")){
			corretto=false;
			request.setAttribute("ospitiError", "Numero opsiti obbligatorio");
		}
		if(telefono.equals("")){
			corretto=false;
			request.setAttribute("telefonoError", "Telefono obbligatorio");
		}
		return corretto;
	}

}
