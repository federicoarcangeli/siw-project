package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.Comanda;

public class StoricoAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {

		Facade facade = new Facade();

		List<Comanda> comande = facade.findallComanda();
		request.setAttribute("comandeStorico", comande);

		return "/storicoComande.jsp";
	}
}