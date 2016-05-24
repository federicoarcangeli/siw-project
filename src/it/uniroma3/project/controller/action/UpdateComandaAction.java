package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.persistence.entity.Comanda;
import it.uniroma3.project.persistence.entity.LineaComanda;
import it.uniroma3.project.persistence.entity.Piatto;

public class UpdateComandaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		
		Long idPiatto = Long.parseLong(request.getParameter("piatto"));
		Facade facade = new Facade();
		
		HttpSession session = request.getSession();
		
		Comanda comandaInCorso = (Comanda) session.getAttribute("comanda");
		
		LineaComanda linea = facade.findLineaByIdPiattoAndComanda(idPiatto,comandaInCorso.getId());

		/*è già presente il piatto nell'ordine*/
		if(linea!=null){
			linea.setQuantita(linea.getQuantita()+1);
			facade.updateLinea(linea);
		}
		/*nuovo piatto da aggiungere all'ordine*/
		else{
			Piatto piatto = facade.findPiatto(idPiatto);
			linea = new LineaComanda();
			linea.setComanda(comandaInCorso);
			linea.setPiatto(piatto);
			linea.setQuantita(1);
			comandaInCorso.setPrezzoTotale(piatto.getDescrizionePiatto().getPrezzo());
			facade.inserisciLinea(linea);
		}
		
		List<LineaComanda> linee = facade.findallLineeComanda(comandaInCorso.getId());
		session.setAttribute("linee", linee);

		return "/comanda.jsp";
	}

}
