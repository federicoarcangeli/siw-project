package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.validator.DoubleValidator;

public class PiattoHelper {

	public boolean validate(HttpServletRequest request) {
		String nomePiatto = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String prezzo = request.getParameter("prezzo");
		String url = request.getParameter("immagine");
		String nomeCategoria = request.getParameter("categoria");
		DoubleValidator validator = new DoubleValidator();
		boolean corretto = true;
		
		if(nomeCategoria.equals("empty")) {
			corretto = false;
			String nomeCategoriaError = "Categoria obbligatoria";
			request.setAttribute("nomeCategoria", nomeCategoriaError);
		}
		if(nomePiatto.equals("")) {
			corretto = false;
			String nomeError = "Nome obbligatorio";
			request.setAttribute("nomeError", nomeError);
		}
		if(descrizione.equals("")) {
			corretto = false;
			String descrizioneError = "Descrizione obbligatoria";
			request.setAttribute("descrizioneError", descrizioneError);
		}
		
		/*da mettere in metodo validator per double */
		if(validator.doubleValidator(prezzo)==0.0){
			corretto = false;
			String prezzoError = "Prezzo obbligatorio";
			request.setAttribute("prezzoError", prezzoError);
		}
		
		if(prezzo.equals("")) {
			corretto = false;
			String prezzoError = "Prezzo obbligatorio";
			request.setAttribute("prezzoError", prezzoError);
		}
//		if(url.equals("")) {		// per ora non gestiamo le foto
//			corretto = false;
//			String urlError = "Url dell'immagine obbligatorio";
//			request.setAttribute("urlError", urlError);
//		}
		if(corretto == false) {
			String error = "ERRORE";
			request.setAttribute("ERRORE", error);
		}		
		return corretto;
	}

}
