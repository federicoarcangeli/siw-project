package it.uniroma3.project.controller.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.DateValidator;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.project.persistence.entity.Tavolo;
import it.uniroma3.validator.Time24HoursValidator;

public class PrenotazioneHelper {

	public PrenotazioneHelper() {
	}

	public boolean validate(HttpServletRequest request) {
		boolean corretto = true;
		Facade facade = new Facade();
		DateValidator validator = new DateValidator();
		Time24HoursValidator validatorTime = new Time24HoursValidator();

		HttpSession session = request.getSession(true);

		String data = request.getParameter("data");
		String ora = request.getParameter("ora");
		String ospiti = request.getParameter("ospiti");
		
		List<Tavolo> tavoli = facade.findAllTavolo();
		facade.closeEntityManager();
		Ristorante checkTavoli = new Ristorante();
		List<Tavolo> tavoliDisponibili = checkTavoli.setTavoloPrenotazione(tavoli,Integer.parseInt(ospiti));
		Tavolo tavoloDaPrenotare = checkTavoli.checkTavoliLiberiForDate(tavoliDisponibili, validator.validate(data));


		if (validator.validate(data) == null) {
			corretto = false;
			request.setAttribute("dataError", "Formato data non valido");
		}
		if (data.equals("")) {
			corretto = false;
			request.setAttribute("dataError", "Data obbigatoria");
		}
		if (validatorTime.validate(ora) == null) {
			corretto = false;
			request.setAttribute("oraError", "Formato ora non valido");
		}
		if (ora.equals("")) {
			corretto = false;
			request.setAttribute("oraError", "Ora obbligatoria");
		}
		if (ospiti.equals("0")) {
			corretto = false;
			request.setAttribute("ospitiError", "Numero ospiti obbligatorio");
		}else{
			if (tavoliDisponibili.isEmpty()) {
				corretto = false;
				request.setAttribute("tavoliError", "Non ci sono tavoli disponibili per questo numero di ospiti");
			}
			if (!tavoliDisponibili.isEmpty() && tavoloDaPrenotare==null) {
				corretto = false;
				request.setAttribute("prenotazioniError", "Non ci sono tavoli disponibili per il " + data + " per "+ ospiti + " persone");
			} else 
				session.setAttribute("tavoloAssegnato", tavoloDaPrenotare);
		}
		if (corretto == false) {
			request.setAttribute("ERROR", "error");
		}
		else
			request.setAttribute("OK", "La prenotazione è stata registrata correttamente alle "+ ora + " del " + data + " per "+ ospiti + " ospiti");
		return corretto;
	}

}
