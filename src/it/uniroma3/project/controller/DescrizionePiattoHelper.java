package it.uniroma3.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DescrizionePiattoHelper {

	public boolean validate(HttpServletRequest request) {	
		String descrizione = request.getParameter("descrizione");
		String prezzo = request.getParameter("price");
		String url = request.getParameter("url");
		boolean isValid = true;
		HttpSession session = request.getSession();
		if(descrizione.equals("")) {
			isValid = false;
			String descrizioneError = "Descrizione obbligatoria";
			session.setAttribute("descrizioneError", descrizioneError);
		}
		if(prezzo.equals("")) {
			isValid = false;
			String prezzoError = "Prezzo obbligatorio";
			session.setAttribute("prezzoError", prezzoError);
		}
		if(url.equals("")) {
			isValid = false;
			String urlError = "Url dell'immagine obbligatorio";
			session.setAttribute("urlError", urlError);
		}
		return isValid;
	}

}
