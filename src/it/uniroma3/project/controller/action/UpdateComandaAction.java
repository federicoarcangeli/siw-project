package it.uniroma3.project.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.ComandaModel;
import it.uniroma3.project.model.LineaComandaModel;
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
		
		LineaComanda lineaComanda = facade.findLineaByIdPiattoAndComanda(idPiatto,comandaInCorso.getId());
		
		ComandaModel comandaModel = new ComandaModel(comandaInCorso);
		

		/*è già presente il piatto nell'ordine*/
		if(lineaComanda!=null){
			LineaComandaModel lineaComandaModel = new LineaComandaModel(lineaComanda);
			lineaComandaModel.updateQuantity(); //aumenta di uno la quantità 
			facade.updateLinea(lineaComanda);
		}
		/*nuovo piatto da aggiungere all'ordine*/
		else{
			Piatto piatto = facade.findPiatto(idPiatto);
			lineaComanda = new LineaComanda();
			lineaComanda.setComanda(comandaInCorso);
			lineaComanda.setPiatto(piatto);
			lineaComanda.setQuantita(1);
			comandaInCorso = comandaModel.updatePrice(piatto.getDescrizionePiatto().getPrezzo());
			comandaInCorso.setPrezzoTotale(comandaInCorso.getPrezzoTotale()+piatto.getDescrizionePiatto().getPrezzo());
			System.out.println("Totale comanda:" + comandaInCorso.getPrezzoTotale());
			comandaInCorso.addLineeComanda(lineaComanda);
			facade.updateComanda(comandaInCorso);
		}
		facade.closeEntityManager();
		List<LineaComanda> linee = facade.findallLineeComanda(comandaInCorso.getId());
		session.setAttribute("linee", linee);

		return "/comanda.jsp";
	}

}
