//package it.uniroma3.project.controller.action;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import it.uniroma3.project.facade.Facade;
//import it.uniroma3.project.model.Comanda;
//import it.uniroma3.project.model.LineaComanda;
//import it.uniroma3.project.model.Piatto;
//
//public class UpdateComandaAction implements Action {
//
//	@Override
//	public String execute(HttpServletRequest request) {
//		
//		Long idPiatto = Long.parseLong(request.getParameter("piatto"));
//		Facade facade = new Facade();
//		System.out.println("idpiatto:"+idPiatto);
//		HttpSession session = request.getSession();
//		
//		Comanda comandaInCorso = (Comanda)session.getAttribute("comanda");
//		
//		LineaComanda lineaComanda = facade.findLineaByIdPiattoAndComanda(idPiatto,comandaInCorso.getId());
//		Piatto piatto = facade.findPiatto(idPiatto);
//		System.out.println(piatto);
//
//		/*è già presente il piatto nell'ordine*/
//		if(lineaComanda!=null){
//			System.out.println("if");
//			lineaComanda.updateQuantity();
//			comandaInCorso.updatePrice(piatto.getDescrizionePiatto().getPrezzo());
//			lineaComanda.setComanda(comandaInCorso);
//			comandaInCorso.addLineeComanda(lineaComanda);
//			facade.updateComanda(comandaInCorso);
//		}
//		/*nuovo piatto da aggiungere all'ordine*/
//		else{	
//			System.out.println("else");
//
//			lineaComanda = new LineaComanda();
//			
//			lineaComanda.setPiatto(piatto);
//			comandaInCorso.updatePrice(piatto.getDescrizionePiatto().getPrezzo());
//			lineaComanda.updateQuantity();
//			lineaComanda.setComanda(comandaInCorso);
//			comandaInCorso.addLineeComanda(lineaComanda);
//			facade.updateComanda(comandaInCorso);
//		}
//		
//		List<LineaComanda> linee = facade.findallLineeComanda(comandaInCorso.getId());
//		facade.closeEntityManager();
//		request.setAttribute("linee", linee);
//
//		return "/comanda.jsp";
//	}
//
//}
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
		HttpSession session = request.getSession(true);
		Comanda comandaInCorso = (Comanda) session.getAttribute("comanda");
		LineaComanda linea = facade.findLineaByIdPiattoAndComanda(idPiatto, comandaInCorso.getId());

		if (linea != null) {
			linea.plusQuantity();
			comandaInCorso.setPrezzoTotale(
					comandaInCorso.getPrezzoTotale() + linea.getPiatto().getDescrizionePiatto().getPrezzo());
			facade.updateLinea(linea);
			facade.updateComanda(comandaInCorso);
		} else {
			Piatto piatto = facade.findPiatto(idPiatto);
			linea = new LineaComanda();
			linea.setComanda(comandaInCorso);
			linea.setPiatto(piatto);
			linea.setQuantita(1);
			comandaInCorso.setPrezzoTotale(
					comandaInCorso.getPrezzoTotale() + linea.getPiatto().getDescrizionePiatto().getPrezzo());
			facade.inserisciLinea(linea);
			facade.updateComanda(comandaInCorso);
		}
		List<LineaComanda> linee = facade.findallLineeComanda(comandaInCorso.getId());
		session.setAttribute("linee", linee);
		facade.closeEntityManager();
		return "/comanda.jsp";
	}

}
