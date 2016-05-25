package it.uniroma3.project.controller.action;


//import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.Comanda;

public class FineComandaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();

		String elimina = request.getParameter("elimina");

		if(elimina!=null){
			Comanda comanda = facade.findComandaById(Long.parseLong(elimina));
			facade.eliminaComanda(comanda);
		}

		facade.closeEntityManager();

		return "/home_Administrator.jsp";

	}

}
