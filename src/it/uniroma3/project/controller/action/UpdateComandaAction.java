package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.model.LineaComanda;
import it.uniroma3.project.model.Piatto;

public class UpdateComandaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		
		Long idPiatto = Long.parseLong(request.getParameter("piatto"));
		Facade facade = new Facade();
		
		HttpSession session = request.getSession();
		
		Comanda comandaInCorso = (Comanda) session.getAttribute("comanda");
		
		LineaComanda lineaComanda = facade.findLineaByIdPiattoAndComanda(idPiatto,comandaInCorso.getId());
		Piatto piatto = facade.findPiatto(idPiatto);

		/*è già presente il piatto nell'ordine*/
		if(lineaComanda!=null){
			lineaComanda.updateQuantity();
			comandaInCorso.updatePrice(piatto.getDescrizionePiatto().getPrezzo());
			lineaComanda.setComanda(comandaInCorso);
			
			facade.updateComanda(comandaInCorso);
		}
		/*nuovo piatto da aggiungere all'ordine*/
		else{	
			lineaComanda = new LineaComanda();
			
			lineaComanda.setPiatto(piatto);
			comandaInCorso.updatePrice(piatto.getDescrizionePiatto().getPrezzo());
			lineaComanda.updateQuantity();
			lineaComanda.setComanda(comandaInCorso);
			facade.updateComanda(comandaInCorso);
		}
		
		List<LineaComanda> linee = facade.findallLineeComanda(comandaInCorso.getId());
		facade.closeEntityManager();
		session.setAttribute("linee", linee);

		return "/comanda.jsp";
	}

}
