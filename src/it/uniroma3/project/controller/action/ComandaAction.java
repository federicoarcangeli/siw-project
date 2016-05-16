package it.uniroma3.project.controller.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Comanda;

public class ComandaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		Comanda comanda = new Comanda();
		comanda.setDataOraEmissione(new Date());
		comanda.setPrezzoTotale(0.0);
		
		return "./inserisciLineaComanda.jsp";
	}

}
