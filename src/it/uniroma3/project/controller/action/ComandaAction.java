package it.uniroma3.project.controller.action;

import java.util.Date;

//import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.persistence.entity.Comanda;
import it.uniroma3.project.persistence.entity.Tavolo;
import it.uniroma3.project.persistence.entity.Utente;

public class ComandaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		HttpSession session = request.getSession(true);

		Utente operatore = (Utente) session.getAttribute("amministratoreCorrente");
		String numeroTavolo = request.getParameter("tavolo");
		Tavolo tavolo = facade.findTavoloByNumero(numeroTavolo);

		if(tavolo.getOccupato()==2){
			Comanda comanda=facade.findComandaByTavoloAndDay(tavolo.getId(),new Date());
			session.setAttribute("comanda", comanda);
		}
		if(tavolo.getOccupato()==0 || tavolo.getOccupato()==1){
			Comanda comanda = new Comanda();
			facade.setTavoloOccupato(tavolo);
			comanda.setOperatore(operatore);
			comanda.setTavolo(tavolo);
			comanda.setDataOraEmissione(new Date());
			facade.inserisciComanda(comanda);
			session.setAttribute("comanda", comanda);
		}


		request.setAttribute("categorie", facade.findAllCategorie());
		session.setAttribute("piatti", facade.findAllPiatti());

		return "/comanda.jsp";

	}

}
