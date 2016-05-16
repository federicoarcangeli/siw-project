package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class ComandaHelper implements Helper {

	@Override
	public boolean validate(HttpServletRequest request) {
		boolean check = true;
		String numeroTavolo = request.getParameter("tavolo");
		String codiceOperatore = request.getParameter("operatore");
		
		if(numeroTavolo.equals("")) {
			check = false;
			String numeroTavoloError = "Numero tavolo obbligatorio";
			request.setAttribute("numeroTavoloError", numeroTavoloError);
		}
		
		if(codiceOperatore.equals("")) {
			check = false;
			String codiceOperatoreError = "Codice operatore obbligatorio";
			request.setAttribute("codiceOperatoreError", codiceOperatoreError);
		}
		
		return check;
	}

}
