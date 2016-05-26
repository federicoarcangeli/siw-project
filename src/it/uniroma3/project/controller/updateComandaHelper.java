package it.uniroma3.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.helper.Helper;
import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.model.LineaComanda;

public class updateComandaHelper implements Helper {

	@Override
	public boolean validate(HttpServletRequest request) {
		boolean check = true;
		Long idPiatto = Long.getLong(request.getParameter("piatto"));
		HttpSession session = request.getSession();
		Comanda comanda = (Comanda) session.getAttribute("comanda");
		
		for(LineaComanda linea : comanda.getLineeComanda()) {
			if(linea.getPiatto().getId().equals(idPiatto)) {
				check = false;
				String piattoError = "piatto già inserito";
				request.setAttribute("piattoError", piattoError);
			}
		}
		
		if(!check) {
			String error = "error";
			request.setAttribute("error", error);
		}
		
		
		return check;
	}

}
