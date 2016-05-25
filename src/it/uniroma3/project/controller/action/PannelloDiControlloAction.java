package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.persistence.entity.Tavolo;

public class PannelloDiControlloAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		float liberi = 0;
		float prenotati = 0;
		float occupati = 0;
		float totali = 0;

		Facade facade = new Facade();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(-1);
		List<Tavolo> tavoli = facade.findAllTavolo();
		facade.closeEntityManager();
		for(Tavolo t : tavoli){
			if(t.getOccupato()==0)
				liberi++;
			if(t.getOccupato()==1)
				prenotati++;
			if(t.getOccupato()==2)
				occupati++;
			totali++;
		}
		request.setAttribute("liberi", (int)liberi);
		request.setAttribute("prenotati", (int)prenotati);
		request.setAttribute("occupati", (int)occupati);
		request.setAttribute("liberiP", (liberi/totali)*100);
		request.setAttribute("prenotatiP", (prenotati/totali)*100);
		request.setAttribute("occupatiP", (occupati/totali)*100);
		request.setAttribute("totali", totali);

		return "/home_Administrator.jsp";
	}
}