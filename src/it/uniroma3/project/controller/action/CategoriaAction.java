package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.CategoriaPiatto;

public class CategoriaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		List<CategoriaPiatto> categorie = facade.findAllCategorie();
		facade.closeEntityManager();
		request.setAttribute("categorie", categorie);
		return "/inserimentoPiatti.jsp";
	}

}
