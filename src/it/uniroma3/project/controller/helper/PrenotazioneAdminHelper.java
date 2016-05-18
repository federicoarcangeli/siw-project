package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.validator.routines.DateValidator;

import it.uniroma3.validator.Time24HoursValidator;
public class PrenotazioneAdminHelper {

	public PrenotazioneAdminHelper() {
	}
	
	public boolean validate(HttpServletRequest request){
		String data,ora,ospiti,nominativo;
		boolean corretto=true;
		nominativo=request.getParameter("nominativo");
		data=request.getParameter("data");
		ora=request.getParameter("ora");
		ospiti = request.getParameter("ospiti");
		
		DateValidator validator = new DateValidator();
		Time24HoursValidator validatorTime = new Time24HoursValidator();

		
		
		if(nominativo.equals("")){
			corretto=false;
			request.setAttribute("nominativoError","Nominativo obbligatorio" );
		}
		if(validator.validate(data)==null){
			corretto=false;
			request.setAttribute("dataError", "Formato data non valido");
		}	
		if(data.equals("")){
			corretto=false;
			request.setAttribute("dataError", "Data obbigatoria");
		}
		if(validatorTime.validate(ora)==null){
			corretto=false;
			request.setAttribute("oraError","Formato ora non valido" );
		}
		if(ora.equals("")){
			corretto=false;
			request.setAttribute("oraError", "Ora obbligatoria");
		}
		if(ospiti.equals("vuoto")){
			corretto=false;
			request.setAttribute("ospitiError", "Numero ospiti obbligatorio");
		}
		if(corretto==false){
			request.setAttribute("ERROR", "error");
		}
		return corretto;
	}

}
