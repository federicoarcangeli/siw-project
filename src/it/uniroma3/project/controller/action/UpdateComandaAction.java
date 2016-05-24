package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Comanda;
import it.uniroma3.project.entity.LineaComanda;
import it.uniroma3.project.entity.Piatto;

public class UpdateComandaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Long idPiatto = Long.parseLong(request.getParameter("piatto"));
		Facade facade = new Facade();
		HttpSession session = request.getSession(true);
		Comanda comandaInCorso = (Comanda) session.getAttribute("comanda");

		Piatto piatto = facade.findPiatto(idPiatto);
		LineaComanda linea = new LineaComanda();
		linea.setComanda(comandaInCorso);
		linea.setPiatto(piatto);
		linea.setQuantita(1);
		facade.inserisciLinea(linea);

		request.setAttribute("piatti", facade.findallLineeComanda(comandaInCorso.getId()));

		return "./processaComanda";
	}

}
