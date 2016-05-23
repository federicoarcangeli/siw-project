package it.uniroma3.project.controller.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Tavolo;

public class PannelloDiControlloAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		int liberi = 0;
		int prenotati = 0;
		int occupati = 0;

		Facade facade = new Facade();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(-1);
		List<Tavolo> tavoli = facade.findAllTavolo();
		for(Tavolo t : tavoli){
			if(t.getOccupato()==0)
				liberi++;
			if(t.getOccupato()==1)
				prenotati++;
			if(t.getOccupato()==2)
				occupati++;
		}
		request.setAttribute("liberi", liberi);
		request.setAttribute("prenotati", prenotati);
		request.setAttribute("occupati", occupati);
		
		return "/home_Administrator.jsp";
	}
}