package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.CategoriaPiatto;

public class CategoriaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		List<CategoriaPiatto> categorie = facade.findAllCategorie();
		request.setAttribute("categorie", categorie);
		return "/inserimentoPiatti.jsp";
	}

}
