package it.uniroma3.project.controllerBean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import it.uniroma3.project.facade.PrenotazioneFacade;
import it.uniroma3.project.facade.TavoloFacade;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.project.model.Tavolo;

@ManagedBean(name ="salaController")
@SessionScoped
@EJBs(value = { @EJB(name = "pFacade", beanInterface = PrenotazioneFacade.class),
		@EJB(name = "tFacade", beanInterface = TavoloFacade.class) })
public class SalaControllerBean {

	private String codiceTavolo;
	private int coperti;
	private List<Tavolo> tavoliSala;
	private Tavolo tavolo;
	private int occupato;

	@EJB
	private TavoloFacade tFacade;

	@EJB
	private PrenotazioneFacade pFacade;

	public String openComanda(){
		this.tavolo = this.tFacade.findTavoloByNumero(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codiceTavolo"));
		System.out.println("sono entrato"+ tavolo);
		if(this.tavolo.getOccupato()==0 || this.tavolo.getOccupato()==1)
			tFacade.setTavoloOccupato(tavolo);
		return "home_administrator";
	}

	@PostConstruct
	public void init() {
		Date today = new Date();
		this.tavoliSala = this.gettFacade().findAllTavolo();

		Ristorante ristorante = new Ristorante();
		for(Tavolo t : tavoliSala){
			List<Prenotazione> prenotazioni = pFacade.findPrenotazione(t, today);

			if(ristorante.comandaInCorso(t)==true )
				tFacade.setTavoloOccupato(t);

			if(!prenotazioni.isEmpty() && ristorante.comandaInCorso(t)==false)
				tFacade.setTavoloPrenotato(t);

			if(prenotazioni.isEmpty() && ristorante.comandaInCorso(t)==false)
				tFacade.setTavoloLibero(t);
			// dobbiamo gestire il caso in cui la prenotazione per quel tavolo è stata completata
		}
	}

	public String getCodiceTavolo() {
		return codiceTavolo;
	}

	public void setCodiceTavolo(String codiceTavolo) {
		this.codiceTavolo = codiceTavolo;
	}

	public int getCoperti() {
		return coperti;
	}

	public void setCoperti(int coperti) {
		this.coperti = coperti;
	}

	public List<Tavolo> getTavoliSala() {
		return tavoliSala;
	}

	public void setTavoliSala(List<Tavolo> tavoliSala) {
		this.tavoliSala = tavoliSala;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public int getOccupato() {
		return occupato;
	}

	public void setOccupato(int occupato) {
		this.occupato = occupato;
	}

	public TavoloFacade gettFacade() {
		return tFacade;
	}

	public void settFacade(TavoloFacade tFacade) {
		this.tFacade = tFacade;
	}

	public PrenotazioneFacade getpFacade() {
		return pFacade;
	}

	public void setpFacade(PrenotazioneFacade pFacade) {
		this.pFacade = pFacade;
	}

}
