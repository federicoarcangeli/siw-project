package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Tavolo;

public class SalaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		List<Prenotazione> prenotazioni = facade.findAllPrenotazioni();
		List<Tavolo> tavoli = facade.findAllTavolo();
		request.setAttribute("tavoli", tavoli);
		request.setAttribute("prenotazione", prenotazioni );
		return "/sala.jsp";
	}

}
