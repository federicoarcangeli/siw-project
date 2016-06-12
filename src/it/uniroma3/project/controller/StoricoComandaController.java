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
import javax.faces.context.FacesContext;

import it.uniroma3.project.facade.ComandaFacade;
import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.model.Utente;

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
		if(this.getUtenteCorrente()==null)
			try {
				this.redirectPage("./sessioneScaduta.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			if(!this.getUtenteCorrente().getRole().equals("admin"))
				try {
					this.redirectPage("./404.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
		this.comande = cFacade.findallComandaCompletate();
	}

	private Utente getUtenteCorrente(){
		FacesContext context = FacesContext.getCurrentInstance();
		return (Utente) context.getExternalContext().getSessionMap().get("utenteCorrente");
	}

	private void redirectPage(String page) throws IOException{
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect(page);
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
