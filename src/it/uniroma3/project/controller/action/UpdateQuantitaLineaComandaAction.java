package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.model.LineaComanda;

public class UpdateQuantitaLineaComandaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		HttpSession session = request.getSession(true);
		Comanda comandaInCorso = (Comanda) session.getAttribute("comanda");
		String minus = request.getParameter("minus");
		String plus = request.getParameter("plus");

		if(minus!=null){
			LineaComanda linea = facade.findLineaComanda(Long.parseLong(minus));
			linea.minusQuantity();
			comandaInCorso.setPrezzoTotale(
					comandaInCorso.getPrezzoTotale() - linea.getPiatto().getDescrizionePiatto().getPrezzo());
			facade.updateLinea(linea);
			facade.updateComanda(comandaInCorso);
			if(linea.getQuantita()==0)
				facade.eliminaRigaComanda(linea);
		}
		if(plus!=null){
			LineaComanda linea = facade.findLineaComanda(Long.parseLong(plus));
			linea.plusQuantity();
			comandaInCorso.setPrezzoTotale(
					comandaInCorso.getPrezzoTotale() + linea.getPiatto().getDescrizionePiatto().getPrezzo());
			facade.updateLinea(linea);
			facade.updateComanda(comandaInCorso);
		}

		List<LineaComanda> linee = facade.findallLineeComanda(comandaInCorso.getId());
		session.setAttribute("linee", linee);
		facade.closeEntityManager();
		return "/comanda.jsp";
	}

}
