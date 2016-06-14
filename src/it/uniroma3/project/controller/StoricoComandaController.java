package it.uniroma3.project.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import it.uniroma3.project.facade.ComandaFacade;
import it.uniroma3.project.model.Comanda;

@ManagedBean(name = "storicoController")
@RequestScoped
public class StoricoComandaController {

	private Date datepicker;
	private List<Comanda> comande = new ArrayList<>();

	@EJB
	private ComandaFacade cFacade;

	public String getComandeEffettuate() throws IOException, ParseException{
		this.comande = this.cFacade.findComandeCompletateInThisDay(this.datepicker);
		return "storicoComande?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		SessionAndRequestManager.sessionCheckerUtenteOperatori();
		
		this.comande = cFacade.findallComandaCompletate();
	}

	public List<Comanda> getComande() {
		return comande;
	}

	public void setComande(List<Comanda> comande) {
		this.comande = comande;
	}

	public ComandaFacade getcFacade() {
		return cFacade;
	}

	public void setcFacade(ComandaFacade cFacade) {
		this.cFacade = cFacade;
	}

	public Date getDatepicker() {
		return datepicker;
	}

	public void setDatepicker(Date datepicker) {
		this.datepicker = datepicker;
	}

}
