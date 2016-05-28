package it.uniroma3.project.controller.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.project.model.Tavolo;

public class SalaAction implements Action {
	Ristorante ristorante = new Ristorante();

	@Override
	public String execute(HttpServletRequest request) {
		Ristorante ristorante = new Ristorante();
		Facade facade = new Facade();
		Date today = new Date();

		List<Tavolo> tavoli = facade.findAllTavoliToday(today);
		for(Tavolo t : tavoli){
			List<Prenotazione> prenotazioni = facade.findPrenotazione(t, today);

			if(ristorante.comandaInCorso(t)==true )
				facade.setTavoloOccupato(t);

			if(!prenotazioni.isEmpty() && ristorante.comandaInCorso(t)==false)
				facade.setTavoloPrenotato(t);

			if(prenotazioni.isEmpty() && ristorante.comandaInCorso(t)==false)
				facade.setTavoloLibero(t);
			// dobbiamo gestire il caso in cui la prenotazione per quel tavolo è stata completata
		}

		facade.closeEntityManager();

		request.setAttribute("tavoli", tavoli);
		return "/sala.jsp";
	}

}
