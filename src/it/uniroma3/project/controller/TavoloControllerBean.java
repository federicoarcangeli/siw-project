package it.uniroma3.project.controller;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.uniroma3.project.facade.PrenotazioneFacade;
import it.uniroma3.project.facade.TavoloFacade;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.project.model.Tavolo;

@ManagedBean(name ="salaController")
@RequestScoped
@EJB(name = "tFacade", beanInterface = TavoloFacade.class)
public class TavoloControllerBean {

	private String codiceTavolo;
	private int coperti;
	private List<Tavolo> tavoliSala;
	private Tavolo tavolo;
	private int occupato;

	@EJB
	private TavoloFacade tFacade;

	@EJB
	private PrenotazioneFacade pFacade;

	public String create() {
		this.tavolo = tFacade.create(this.getCodiceTavolo(),this.getCoperti());
		return "registrazioneTavolo";
	}

	public String openComanda(){
		if(this.tavolo.getOccupato()==0 || this.tavolo.getOccupato()==1)
			tFacade.setTavoloOccupato(tavolo);
		return "comanda.jsp";
	}

	//	SECONDO ME IN QUESTO CASO DOBBIAMO GESTIRE UN COTROLLER PER IL SOLO CASO D'USO	
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

	public void setCodiceTavolo(String codice) {
		this.codiceTavolo = codice;
	}

	public int getCoperti() {
		return coperti;
	}

	public void setCoperti(int coperti) {
		this.coperti = coperti;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public TavoloFacade getTavoloFacade() {
		return tFacade;
	}

	public List<Tavolo> getTavoliSala() {
		return tavoliSala;
	}

	public void setTavoliSala(List<Tavolo> tavoliSala) {
		this.tavoliSala = tavoliSala;
	}

	public void setTavoli(List<Tavolo> tavoli) {
		this.tavoliSala = tavoli;
	}

	public TavoloFacade gettFacade() {
		return tFacade;
	}

	public void settFacade(TavoloFacade tFacade) {
		this.tFacade = tFacade;
	}

	public int getOccupato() {
		return occupato;
	}

	public void setOccupato(int occupato) {
		this.occupato = occupato;
	}


}
