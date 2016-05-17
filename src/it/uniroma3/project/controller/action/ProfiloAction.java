package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Piatto;
import it.uniroma3.project.entity.Prenotazione;

public class ProfiloAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		List<Prenotazione> prenotazioni = facade.findAllPrenotazioni();
		request.setAttribute("prenotazioni", prenotazioni);
		return "/profilo.jsp";
	}

}
