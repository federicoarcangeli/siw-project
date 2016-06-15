package it.uniroma3.project.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import it.uniroma3.project.facade.ComandaFacade;
import it.uniroma3.project.facade.PrenotazioneFacade;
import it.uniroma3.project.facade.TavoloFacade;
import it.uniroma3.project.facade.UtenteFacade;
import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Tavolo;
import it.uniroma3.project.model.Utente;

@ManagedBean(name = "pannelloController")
@RequestScoped
@EJBs(value = { @EJB(name = "pFacade", beanInterface = PrenotazioneFacade.class),
		@EJB(name = "cFacade", beanInterface = ComandaFacade.class) ,
		@EJB(name = "tFacade", beanInterface = TavoloFacade.class), 
		@EJB(name = "uFacade", beanInterface = UtenteFacade.class) })

public class PannelloDiControlloController {

	private int tavoliLiberi = 0;
	private int tavoliPrenotati = 0;
	private int tavoliOccupati = 0;
	private float tavoliTotali = 0;
	private float tavoliLiberiP = 0;
	private float tavoliPrenotatiP = 0;
	private float tavoliOccupatiP = 0;
	private List<Tavolo> tavoli;
	private List<Comanda> comande;
	private List<Comanda> comandeCompletateToday;
	private List<Prenotazione> prenotazioni;
	private List<Utente> operatoriInServizio;
	private Comanda comanda;

	@EJB
	private PrenotazioneFacade pFacade;

	@EJB
	private ComandaFacade cFacade;

	@EJB
	private TavoloFacade tFacade;

	@EJB
	private UtenteFacade uFacade;

	public String eliminaComanda(){
		Comanda comanda = this.getComandaByRequest();
		Prenotazione prenotazione = pFacade.findPrenotazioneByTavolo(comanda.getTavolo().getId());
		if(prenotazione!=null)
			pFacade.setPrenotazioneError(prenotazione);
		this.tFacade.setTavoloLibero(comanda.getTavolo());
		this.cFacade.eliminaComandaByID(comanda.getId());
		return "home_Administrator?faces-redirect=true";
	}

	public String eliminaPrenotazione (){
		this.pFacade.eliminaPrenotazioneByID(Long.parseLong(SessionAndRequestManager.getByRequest("idPrenotazione")));
		return "home_Administrator?faces-redirect=true";
	}

	public String confermaComanda(){
		Comanda comanda = this.getComandaByRequest();
		cFacade.concludiComanda(comanda.getId());	
		tFacade.setTavoloLibero(comanda.getTavolo());
		Prenotazione prenotazione = pFacade.findPrenotazioneByTavolo(comanda.getTavolo().getId());
		if(prenotazione!=null)
			pFacade.setPrenotazioneCompletata(prenotazione);
		return "home_Administrator?faces-redirect=true";
	}

	@PostConstruct
	public void init(){

		SessionAndRequestManager.sessionCheckerUtenteOperatori();

		//		calcolo numero tavoli liberi occupati, prenotati e totali
		this.tavoli = tFacade.findAllTavolo();
		for(Tavolo t : this.tavoli){
			if(t.getStato()==0)
				this.tavoliLiberi++;
			if(t.getStato()==1)
				this.tavoliPrenotati++;
			if(t.getStato()==2)
				this.tavoliOccupati++;
		}
		this.tavoliTotali=this.tavoli.size();
		this.tavoliLiberiP= (this.tavoliLiberi/this.tavoliTotali)*100;
		this.tavoliPrenotatiP= (this.tavoliPrenotati/this.tavoliTotali)*100;
		this.tavoliOccupatiP= (this.tavoliOccupati/this.tavoliTotali)*100;

		//		 gestione comande di oggi
		this.comande = cFacade.findallComandeInCorso();

		//		gestione operatori in servizio
		this.operatoriInServizio =  uFacade.findOperatori();

		//		 gestione prenotazioni di oggi
		this.prenotazioni = pFacade.findAllPrenotazioniToday();

		//		gestione comande completate oggi
		this.comandeCompletateToday = cFacade.findAllComandeCompletateToday();
	}

	private Comanda getComandaByRequest(){
		return cFacade.findComandaById(this.getIDComandaByRequest());
	}

	private Long getIDComandaByRequest(){
		return Long.parseLong(SessionAndRequestManager.getByRequest("idComanda"));
	}

	public int getTavoliLiberi() {
		return tavoliLiberi;
	}

	public void setTavoliLiberi(int tavoliLiberi) {
		this.tavoliLiberi = tavoliLiberi;
	}

	public int getTavoliPrenotati() {
		return tavoliPrenotati;
	}

	public void setTavoliPrenotati(int tavoliPrenotati) {
		this.tavoliPrenotati = tavoliPrenotati;
	}

	public int getTavoliOccupati() {
		return tavoliOccupati;
	}

	public void setTavoliOccupati(int tavoliOccupati) {
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

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public List<Utente> getOperatoriInServizio() {
		return operatoriInServizio;
	}

	public void setOperatoriInServizio(List<Utente> operatoriInServizio) {
		this.operatoriInServizio = operatoriInServizio;
	}

	public UtenteFacade getuFacade() {
		return uFacade;
	}

	public void setuFacade(UtenteFacade uFacade) {
		this.uFacade = uFacade;
	}

	public List<Comanda> getComandeCompletateToday() {
		return comandeCompletateToday;
	}

	public void setComandeCompletateToday(List<Comanda> comandeCompletateToday) {
		this.comandeCompletateToday = comandeCompletateToday;
	}

}
