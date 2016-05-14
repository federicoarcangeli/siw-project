package it.uniroma3.project.controller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.CategoriaPiatto;
import it.uniroma3.project.entity.DescrizionePiatto;
import it.uniroma3.project.entity.Piatto;
import it.uniroma3.validator.DoubleValidator;

public class PiattoAction {
	private List<Piatto> piatti;

	public PiattoAction() {
		this.piatti = new ArrayList<Piatto>();
	}

	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();

		DoubleValidator validator = new DoubleValidator();
		DescrizionePiatto descrizionePiatto = new DescrizionePiatto();
		descrizionePiatto.setDescrizione(request.getParameter("descrizione"));
		descrizionePiatto.setPrezzo(validator.doubleValidator(request.getParameter("prezzo")));
		descrizionePiatto.setUrlImmagine(request.getParameter("immagine"));
		descrizionePiatto.setProdottiAllergizzanti(Boolean.parseBoolean(request.getParameter("allergeni")));
		descrizionePiatto.setProdottiSurgelati(Boolean.parseBoolean(request.getParameter("surgelati")));

		CategoriaPiatto categoria = facade.findCategoria(request.getParameter("categoria"));

		Piatto piatto = new Piatto(request.getParameter("nome"), descrizionePiatto, categoria);

		facade.inserisciPiatto(piatto);

		return "/piattoInserito.jsp";
	}

}
