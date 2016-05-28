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
		String conferma = request.getParameter("conferma");
		System.out.println("----->"+elimina + conferma);
		if(elimina!=null){
			Comanda comanda = facade.findComandaById(Long.parseLong(elimina));
			facade.eliminaComanda(comanda);
		}
		else
			if(conferma!=null){
				Comanda comanda = facade.findComandaById(Long.parseLong(conferma));
				facade.concludiComanda(comanda);
				facade.setTavoloLibero(comanda.getTavolo());
			}
		facade.closeEntityManager();

		return "/processaPannelloControllo";

	}

}
