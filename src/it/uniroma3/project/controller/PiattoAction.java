package it.uniroma3.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.DescrizionePiatto;

public class PiattoAction {
	private List<DescrizionePiatto> descrizioni;
	
	public PiattoAction() {
		this.descrizioni = new ArrayList<DescrizionePiatto>();
	}

	public String execute(HttpServletRequest request) {
		DescrizionePiatto descrizionePiatto = new DescrizionePiatto();
		descrizionePiatto.setDescrizione(request.getParameter("descrizione"));
		descrizionePiatto.setPrice(Double.parseDouble(request.getParameter("prezzo")));
		descrizionePiatto.setUrlImmagine(request.getParameter("url"));
		Facade facade = new Facade();
		facade.inserisciDescrizione(descrizionePiatto);
		HttpSession session = request.getSession();
		this.getDescrizioniPiatti(session).add(descrizionePiatto);
		session.setAttribute("descrizionePiatto", descrizionePiatto);
		session.setAttribute("descrizioniPiatti", this.descrizioni);
		return "/riepilogoDescrizioni.jsp";
	}
	
	@SuppressWarnings("unchecked")
	private List<DescrizionePiatto> getDescrizioniPiatti(HttpSession session) {
		this.descrizioni = (List<DescrizionePiatto>) session.getAttribute("descrizioniPiatti");
		if(this.descrizioni == null)
			this.descrizioni = new ArrayList<>();
		return this.descrizioni;
	}

}
