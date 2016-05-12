package it.uniroma3.project.controller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.DescrizionePiatto;
import it.uniroma3.project.entity.Piatto;

public class PiattoAction {
	private List<Piatto> piatti;
	
	public PiattoAction() {
		this.piatti = new ArrayList<Piatto>();
	}

	public String execute(HttpServletRequest request) {
		Piatto piatto = new Piatto();
		piatto.setNome(request.getParameter("nome"));

		DescrizionePiatto descrizionePiatto = new DescrizionePiatto();
		descrizionePiatto.setDescrizione(request.getParameter("descrizione"));
		descrizionePiatto.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
		descrizionePiatto.setUrlImmagine(request.getParameter("url"));
		piatto.setDescrizionePiatto(descrizionePiatto);
		Facade facade = new Facade();
		facade.inserisciPiatto(piatto);
		HttpSession session = request.getSession();
		this.getDescrizioniPiatti(session).add(piatto);
		session.setAttribute("piatto", piatto);
		session.setAttribute("piatti", this.piatti);
		return "/riepilogoPiatti.jsp";
	}
	
	@SuppressWarnings("unchecked")
	private List<Piatto> getDescrizioniPiatti(HttpSession session) {
		this.piatti = (List<Piatto>) session.getAttribute("piatti");
		if(this.piatti == null)
			this.piatti = new ArrayList<>();
		return this.piatti;
	}

}
