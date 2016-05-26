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
		System.out.println("Dio porco è qui ---->" + elimina);

		Comanda comanda = facade.findComandaById(Long.parseLong(elimina));
		System.out.println("Madonna lercia --> "+comanda.getId());
		facade.eliminaComanda(comanda);
		System.out.println("fine del cristianesimo");
		facade.closeEntityManager();

		return "/home_Administrator.jsp";

	}

}
