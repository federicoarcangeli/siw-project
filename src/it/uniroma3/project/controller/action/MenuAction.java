package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.persistence.entity.CategoriaPiatto;
import it.uniroma3.project.persistence.entity.Piatto;

public class MenuAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		List<CategoriaPiatto> categorie = facade.findAllCategorie();
		request.setAttribute("categorie", categorie);
		List<Piatto> piatti = facade.findAllPiatti();
		request.setAttribute("piatti", piatti);
		return "/menu.jsp";
	}

}
