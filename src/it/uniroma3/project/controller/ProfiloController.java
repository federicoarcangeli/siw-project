package it.uniroma3.project.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import it.uniroma3.project.facade.PrenotazioneFacade;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Utente;

@ManagedBean(name="profiloController")
@RequestScoped
@EJB(name = "pFacade", beanInterface = PrenotazioneFacade.class)
public class ProfiloController {

	private Date datepicker;
	private int coperti;
	private Date timepicker;
	private List<Prenotazione> prenotazioniUtente;

	@EJB
	private PrenotazioneFacade pFacade;

	public String eliminaPrenotazioneDaProfilo(){
		this.pFacade.eliminaPrenotazioneByID(Long.parseLong(this.getByRequest("idPrenotazione")));
		return "profilo?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		if(this.getUtenteCorrente()==null)
			try {
				this.redirectPage("./sessioneScaduta.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		this.prenotazioniUtente = pFacade.findAllPrenotazioniUtente(this.getUtenteCorrente().getId());
	}

	private void redirectPage(String page) throws IOException{
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect(page);
	}

	private String getByRequest(String name){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		return params.get(name);
	}

	private Utente getUtenteCorrente(){
		FacesContext context = FacesContext.getCurrentInstance();
		return (Utente) context.getExternalContext().getSessionMap().get("utenteCorrente");
	}

	public PrenotazioneFacade getpFacade() {
		return pFacade;
	}

	public void setpFacade(PrenotazioneFacade pFacade) {
		this.pFacade = pFacade;
	}

	public List<Prenotazione> getPrenotazioniUtente() {
		return prenotazioniUtente;
	}

	public void setPrenotazioniUtente(List<Prenotazione> prenotazioniUtente) {
		this.prenotazioniUtente = prenotazioniUtente;
	}

	public Date getDatepicker() {
		return datepicker;
	}

	public void setDatepicker(Date datepicker) {
		this.datepicker = datepicker;
	}

	public int getCoperti() {
		return coperti;
	}

	public void setCoperti(int coperti) {
		this.coperti = coperti;
	}

	public Date getTimepicker() {
		return timepicker;
	}

	public void setTimepicker(Date timepicker) {
		this.timepicker = timepicker;
	}

}
