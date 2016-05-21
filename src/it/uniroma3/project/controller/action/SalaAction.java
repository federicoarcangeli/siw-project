package it.uniroma3.project.controller.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Tavolo;

public class SalaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		Date today = new Date();
		List<Tavolo> tavoli = facade.findAllTavoliToday(today);
		for(Tavolo t : tavoli){
			if(!facade.findPrenotazione(t, today).isEmpty())
				t.setOccupato(1);
			else
				t.setOccupato(0);
		}
		request.setAttribute("tavoli", tavoli);
		return "/sala.jsp";
	}

}
