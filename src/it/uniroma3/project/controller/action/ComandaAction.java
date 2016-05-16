package it.uniroma3.project.controller.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Comanda;
import it.uniroma3.project.entity.Operatore;
import it.uniroma3.project.entity.Tavolo;

public class ComandaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		Comanda comanda = new Comanda();
		comanda.setDataOraEmissione(new Date());
		comanda.setPrezzoTotale(0.0);
		Operatore operatore = facade.findOperatoreByCodice(request.getParameter("operatore"));
		comanda.setOperatore(operatore);
		Tavolo tavolo = facade.findTavoloByNumero(request.getParameter("tavolo"));
		comanda.setTavolo(tavolo);
		facade.inserisciComanda(comanda);
		return "/inserisciLineaComanda.jsp";
	}

}
