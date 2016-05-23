package it.uniroma3.project.controller.action;

import java.util.Date;

//import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Comanda;
import it.uniroma3.project.entity.Tavolo;
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
		comanda.setOperatore(operatore);
		Tavolo tavolo = facade.findTavoloByNumero(numeroTavolo);
		
		/*
		 * Qualcuno si è andato a sedere: aggiorno lo stato del tavolo, da
		 * libero ad occupato
		 */
		facade.setTavoloOccupato(tavolo);
		comanda.setTavolo(tavolo);
		comanda.setDataOraEmissione(new Date());
		comanda.setPrezzoTotale(0.0);
		facade.inserisciComanda(comanda);
		
		session.setAttribute("comanda", comanda);
		session.setAttribute("categorie", facade.findAllCategorie());
		session.setAttribute("piatti", facade.findAllPiatti());

		return "/comanda.jsp";

	}

}
