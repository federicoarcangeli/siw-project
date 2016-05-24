package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.persistence.entity.Comanda;
import it.uniroma3.project.persistence.entity.LineaComanda;

public class UpdateComandaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		HttpSession session = request.getSession();
		Comanda comandaInCorso = (Comanda) session.getAttribute("comanda");
		LineaComanda linea = new LineaComanda();
		
		return "/comanda.jsp";
	}

}
