package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.CategoriaPiatto;
import it.uniroma3.project.model.Piatto;

public class MenuAction implements Action {

	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Facade facade = new Facade();
		List<CategoriaPiatto> categorie = facade.findAllCategorie();
		request.setAttribute("categorie", categorie);
		List<Piatto> piatti = facade.findAllPiatti();
		for(Piatto p : piatti) {
			String image = p.getDescrizionePiatto().getBase64Img();
			
		}
		facade.closeEntityManager();
		request.setAttribute("piatti", piatti);
		return "/menu.jsp";
	}

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
