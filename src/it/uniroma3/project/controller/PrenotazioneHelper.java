package it.uniroma3.project.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.validator.routines.DateValidator;
import it.uniroma3.validator.Time24HoursValidator;
public class PrenotazioneHelper {

	public PrenotazioneHelper() {
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
		Time24HoursValidator validatorTime = new Time24HoursValidator();

		if(validator.validate(data)==null){
			corretto=false;
			request.setAttribute("dataError", "Formato data non valido");
		}	
		if(data.equals("")){
			corretto=false;
			request.setAttribute("dataError", "Data obbigatoria");
		}
		if(nome.equals("")){
			corretto=false;
			request.setAttribute("nomeError", "Nome obbligatorio");
		}
		if(validatorTime.validate(ora)==null){
			corretto=false;
			request.setAttribute("oraError","Formato ora non valido" );
		}
		if(ora.equals("")){
			corretto=false;
			request.setAttribute("oraError", "Ora obbligatoria");
		}
		if(email.equals("")){ // verifica email con @ 
			corretto=false;
			request.setAttribute("emailError", "Email obbligatorio");
		}
		if(ospiti.equals("vuoto")){
			corretto=false;
			request.setAttribute("ospitiError", "Numero ospiti obbligatorio");
		}
		if(telefono.equals("")){
			corretto=false;
			request.setAttribute("telefonoError", "Telefono obbligatorio");
			
		if(corretto==false){
			request.setAttribute("ERROR", "error");
		}
		}
		return corretto;
	}

}
