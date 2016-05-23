package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Tavolo;
import it.uniroma3.project.model.Ristorante;

public class SalaAction implements Action {
	Ristorante ristorante = new Ristorante();

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();

		// ristorante.setUpGiornaliero();

		List<Tavolo> tavoli = facade.findAllTavolo();
		request.setAttribute("tavoli", tavoli);
		return "/sala.jsp";
	}

}
