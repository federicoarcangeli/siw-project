package it.uniroma3.project.controller.action;


import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.CategoriaPiatto;
import it.uniroma3.project.entity.DescrizionePiatto;
import it.uniroma3.project.entity.Piatto;
import it.uniroma3.validator.DoubleValidator;

public class PiattoAction {
//	private List<Piatto> piatti;
	
	public PiattoAction() {
//		this.piatti = new ArrayList<Piatto>();
	}

	public String execute(HttpServletRequest request) {
		Facade facade= new Facade();
		
		DoubleValidator validator = new DoubleValidator();
		DescrizionePiatto descrizionePiatto = new DescrizionePiatto();
		descrizionePiatto.setDescrizione(request.getParameter("descrizione"));
		descrizionePiatto.setPrezzo(validator.doubleValidator(request.getParameter("prezzo")));
		descrizionePiatto.setUrlImmagine(request.getParameter("immagine"));
		descrizionePiatto.setProdottiAllergizzanti(Boolean.parseBoolean(request.getParameter("allergeni")));
		descrizionePiatto.setProdottiSurgelati(Boolean.parseBoolean(request.getParameter("surgelati")));
		
		CategoriaPiatto categoria = new CategoriaPiatto();
		categoria.setNome(request.getParameter("categoria"));   // sarà una interrogazione
		
		Piatto piatto = new Piatto(descrizionePiatto);
		piatto.setNome(request.getParameter("nome"));
		

		categoria.addPiatto(piatto);
		piatto.setPortata(categoria);
		
//		HttpSession session = request.getSession();
//		this.getDescrizioniPiatti(session).add(piatto);
//		session.setAttribute("piatto", piatto);
//		session.setAttribute("piatti", this.piatti);
		
		facade.inserisciPiatto(piatto);
		
		return "/conferma.jsp";
	}
	
//	@SuppressWarnings("unchecked")
//	private List<Piatto> getDescrizioniPiatti(HttpSession session) {
//		this.piatti = (List<Piatto>) session.getAttribute("piatti");
//		if(this.piatti == null)
//			this.piatti = new ArrayList<>();
//		return this.piatti;
//	}

}
