package it.uniroma3.project.controller.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.validator.routines.DateValidator;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Tavolo;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.validator.Time24HoursValidator;
public class PrenotazioneHelper {

	public PrenotazioneHelper() {
	}
	
	public boolean validate(HttpServletRequest request){
		String data,ora,ospiti;
		boolean corretto=true;
		data=request.getParameter("data");
		ora=request.getParameter("ora");
		ospiti = request.getParameter("ospiti");
		
		Facade facade = new Facade();
		List<Tavolo> tavoli = facade.findAllTavolo();
		Ristorante checkTavoli = new Ristorante(Integer.parseInt(ospiti));
		
		if(checkTavoli.setTavoloPrenotazione(tavoli) == null) {
			corretto = false;
			request.setAttribute("tavoliError", "Non ci sono tavoli disponibili");
		}
		
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
