package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.persistence.entity.Tavolo;

public class RegistrazioneTavoloAction {


	public RegistrazioneTavoloAction() {
	}

	public String execute(HttpServletRequest request) {
		Tavolo tavolo = new Tavolo();
		Facade facade = new Facade();

		tavolo.setCodiceTavolo(request.getParameter("codiceTavolo"));
		tavolo.setCoperti(Integer.parseInt(request.getParameter("coperti")));
		facade.inserisciTavolo(tavolo);

		return "/registraTavolo.jsp";
	}



}