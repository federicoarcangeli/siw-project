package it.uniroma3.project.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import it.uniroma3.project.facade.ComandaFacade;
import it.uniroma3.project.facade.PrenotazioneFacade;
import it.uniroma3.project.facade.TavoloFacade;
import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.project.model.Tavolo;

@ManagedBean(name ="salaController")
@RequestScoped
@EJBs(value = { @EJB(name = "pFacade", beanInterface = PrenotazioneFacade.class),
		@EJB(name = "tFacade", beanInterface = TavoloFacade.class) })
public class SalaController {

	private Comanda comanda;
	private String codiceTavolo;
	private int coperti;
	private List<Tavolo> tavoliSala;
	private Tavolo tavolo;
	private int occupato;

	@EJB
	private TavoloFacade tFacade;

	@EJB
	private PrenotazioneFacade pFacade;

	@EJB
	private ComandaFacade cFacade;

	public String openComanda(){
		this.tavolo = this.tFacade.findTavoloByNumero(SessionAndRequestManager.getByRequest("codiceTavolo"));
		if(this.tavolo.getStato()==0 || this.tavolo.getStato()==1){
			if(this.tavolo.getStato()==1)
				pFacade.setPrenotazioneInCorso(this.tavolo.getId());
			this.comanda = new Comanda();
			tFacade.setTavoloOccupato(tavolo);
			comanda.setOperatore(SessionAndRequestManager.getUtenteCorrente());
			comanda.setTavolo(tavolo);
			comanda.setDataOraEmissione(new Date());
			cFacade.inserisciComanda(comanda);
		}
		else
			if(this.tavolo.getStato()==2){
				this.comanda = cFacade.findComandaByTavolo(this.tavolo.getId());
			}
		SessionAndRequestManager.setInSession("comandaCorrente",comanda); 
		return "comanda";
	}

	@PostConstruct
	public void init() {
		SessionAndRequestManager.sessionCheckerUtenteOperatori();
		
		this.tavoliSala = this.gettFacade().findAllTavolo();
		Ristorante ristorante = new Ristorante();
		for(Tavolo t : tavoliSala){
			List<Prenotazione> prenotazioni = pFacade.findPrenotazione(t);

			if(ristorante.comandaInCorso(t)==true )
				tFacade.setTavoloOccupato(t);

			if(!prenotazioni.isEmpty() && ristorante.comandaInCorso(t)==false)
				tFacade.setTavoloPrenotato(t);

			if(prenotazioni.isEmpty() && ristorante.comandaInCorso(t)==false)
				tFacade.setTavoloLibero(t);
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

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public ComandaFacade getcFacade() {
		return cFacade;
	}

	public void setcFacade(ComandaFacade cFacade) {
		this.cFacade = cFacade;
	}

}
