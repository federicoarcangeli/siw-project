package it.uniroma3.project.controllerBean;

import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Tavolo;

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


@ManagedBean(name = "pannelloController")
@RequestScoped
@EJBs(value = { @EJB(name = "pFacade", beanInterface = PrenotazioneFacade.class),
		@EJB(name = "cFacade", beanInterface = ComandaFacade.class) ,
		@EJB(name = "tFacade", beanInterface = TavoloFacade.class) })

public class PannelloDiControlloControllerBean {

	private float tavoliLiberi = 0;
	private float tavoliPrenotati = 0;
	private float tavoliOccupati = 0;
	private float tavoliTotali = 0;
	private float tavoliLiberiP = 0;
	private float tavoliPrenotatiP = 0;
	private float tavoliOccupatiP = 0;
	private List<Tavolo> tavoli;
	private List<Comanda> comande;
	private List<Prenotazione> prenotazioni;

	@EJB
	private PrenotazioneFacade pFacade;

	@EJB
	private ComandaFacade cFacade;

	@EJB
	private TavoloFacade tFacade;

	public String eliminaComanda(){
		return "home_Administrator";
	}

	public String confermaComanda(){

		return "home_Administrator";
	}

	@PostConstruct
	public void init(){
		//		calcolo numero tavoli liberi occupati, prenotati e totali
		this.tavoli = tFacade.findAllTavolo();
		for(Tavolo t : this.tavoli){
			if(t.getOccupato()==0)
				this.tavoliLiberi++;
			if(t.getOccupato()==1)
				this.tavoliPrenotati++;
			if(t.getOccupato()==2)
				this.tavoliOccupati++;
		}
		this.tavoliTotali=this.tavoli.size();
		this.tavoliLiberiP= (this.tavoliLiberi/this.tavoliTotali)*100;
		this.tavoliPrenotatiP= (this.tavoliPrenotati/this.tavoliTotali)*100;
		this.tavoliOccupatiP= (this.tavoliOccupati/this.tavoliTotali)*100;

		//		 gestione comande di oggi
		this.comande = cFacade.findallComandaToday(new Date());

		// gestione prenotazioni di oggi
		this.prenotazioni = pFacade.findAllPrenotazioniToday(new Date());
	}

	public float getTavoliLiberi() {
		return tavoliLiberi;
	}

	public void setTavoliLiberi(float tavoliLiberi) {
		this.tavoliLiberi = tavoliLiberi;
	}

	public float getTavoliPrenotati() {
		return tavoliPrenotati;
	}

	public void setTavoliPrenotati(float tavoliPrenotati) {
		this.tavoliPrenotati = tavoliPrenotati;
	}

	public float getTavoliOccupati() {
		return tavoliOccupati;
	}

	public void setTavoliOccupati(float tavoliOccupati) {
		this.tavoliOccupati = tavoliOccupati;
	}

	public float getTavoliTotali() {
		return tavoliTotali;
	}

	public void setTavoliTotali(float tavoliTotali) {
		this.tavoliTotali = tavoliTotali;
	}

	public List<Tavolo> getTavoli() {
		return tavoli;
	}

	public void setTavoli(List<Tavolo> tavoli) {
		this.tavoli = tavoli;
	}

	public List<Comanda> getComande() {
		return comande;
	}

	public void setComande(List<Comanda> comande) {
		this.comande = comande;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public PrenotazioneFacade getpFacade() {
		return pFacade;
	}

	public void setpFacade(PrenotazioneFacade pFacade) {
		this.pFacade = pFacade;
	}

	public ComandaFacade getcFacade() {
		return cFacade;
	}

	public void setcFacade(ComandaFacade cFacade) {
		this.cFacade = cFacade;
	}

	public TavoloFacade gettFacade() {
		return tFacade;
	}

	public void settFacade(TavoloFacade tFacade) {
		this.tFacade = tFacade;
	}

	public float getTavoliLiberiP() {
		return tavoliLiberiP;
	}

	public void setTavoliLiberiP(float tavoliLiberiP) {
		this.tavoliLiberiP = tavoliLiberiP;
	}

	public float getTavoliPrenotatiP() {
		return tavoliPrenotatiP;
	}

	public void setTavoliPrenotatiP(float tavoliPrenotatiP) {
		this.tavoliPrenotatiP = tavoliPrenotatiP;
	}

	public float getTavoliOccupatiP() {
		return tavoliOccupatiP;
	}

	public void setTavoliOccupatiP(float tavoliOccupatiP) {
		this.tavoliOccupatiP = tavoliOccupatiP;
	}

}
