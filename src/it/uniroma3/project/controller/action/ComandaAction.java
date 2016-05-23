package it.uniroma3.project.controller.action;

import java.util.Date;

//import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Comanda;
import it.uniroma3.project.entity.Utente;
//import it.uniroma3.project.entity.Comanda;

public class ComandaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		Comanda comanda = new Comanda();
		HttpSession session = request.getSession();
		
		comanda.setDataOraEmissione(new Date());
		Utente operatore = (Utente) session.getAttribute("amministratoreCorrente");
		String numeroTavolo = request.getParameter("libero");
		System.out.println("ComandaAction - numeroTavolo: "+numeroTavolo);
//		comanda.setPrezzoTotale(0.0);
//		Operatore operatore = facade.findOperatore(request.getParameter("operatore"));
//		comanda.setOperatore(operatore);
//		Tavolo tavolo = facade.findTavoloByNumero(request.getParameter("tavolo"));
//		comanda.setTavolo(tavolo);
//		facade.inserisciComanda(comanda);
//		return "/inserisciLineaComanda.jsp";
		
		
		
		session.setAttribute("categorie", facade.findAllCategorie());
		session.setAttribute("piatti", facade.findAllPiatti());
		

		return "/comanda.jsp";

		
	}

}
