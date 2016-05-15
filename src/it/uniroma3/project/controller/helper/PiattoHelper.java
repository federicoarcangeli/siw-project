package it.uniroma3.project.controller.helper;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.apache.commons.fileupload.*;

import it.uniroma3.validator.DoubleValidator;

public class PiattoHelper {


	public boolean validate(HttpServletRequest request) throws IOException, ServletException {
		String nomePiatto = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String prezzo = request.getParameter("prezzo");
		
		String urlImmagine = request.getParameter("immagine");
				
		String nomeCategoria = request.getParameter("categoria");
		DoubleValidator validator = new DoubleValidator();
		boolean corretto = true;

		if (nomeCategoria.equals("empty")) {
			corretto = false;
			String nomeCategoriaError = "Categoria obbligatoria";
			request.setAttribute("nomeCategoria", nomeCategoriaError);
		}
		if (nomePiatto.equals("")) {
			corretto = false;
			String nomeError = "Nome obbligatorio";
			request.setAttribute("nomeError", nomeError);
		}
		if (descrizione.equals("")) {
			corretto = false;
			String descrizioneError = "Descrizione obbligatoria";
			request.setAttribute("descrizioneError", descrizioneError);
		}

		/* da mettere in metodo validator per double */
		if (validator.doubleValidator(prezzo) == 0.0) {
			corretto = false;
			String prezzoError = "Prezzo obbligatorio";
			request.setAttribute("prezzoError", prezzoError);
		}

		if (prezzo.equals("")) {
			corretto = false;
			String prezzoError = "Prezzo obbligatorio";
			request.setAttribute("prezzoError", prezzoError);
		}
//		if (urlImmagine.equals("")) { // per ora non gestiamo le foto
//			corretto = false;
//			String urlError = "Url dell'immagine obbligatorio";
//			request.setAttribute("urlError", urlError);
//		}


			if (corretto == false) {
				String error = "ERRORE";
				request.setAttribute("ERRORE", error);
			}
			return corretto;
		

	}
}

