package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.CategoriaPiatto;
import it.uniroma3.project.model.Piatto;

public class MenuAction implements Action {

	
	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		List<CategoriaPiatto> categorie = facade.findAllCategorie();
		request.setAttribute("categorie", categorie);
		List<Piatto> piatti = facade.findAllPiatti();
		facade.closeEntityManager();
		request.setAttribute("piatti", piatti);
		return "/menu.jsp";
	}
}
