package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.project.persistence.entity.Tavolo;

public class SalaAction implements Action {
	Ristorante ristorante = new Ristorante();

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();

		ristorante.setUpGiornaliero();

		List<Tavolo> tavoli = facade.findAllTavolo();
		request.setAttribute("tavoli", tavoli);
		return "/sala.jsp";
	}

}
