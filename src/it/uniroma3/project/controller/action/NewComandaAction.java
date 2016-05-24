package it.uniroma3.project.controller.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.persistence.entity.Comanda;

public class NewComandaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		Comanda comanda = new Comanda();
		Date date = new Date();
		return "./comanda.jsp";
	}

}
