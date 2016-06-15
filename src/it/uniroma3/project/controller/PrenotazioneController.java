package it.uniroma3.project.controller;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.uniroma3.project.facade.PrenotazioneFacade;
import it.uniroma3.project.facade.TavoloFacade;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.project.model.Tavolo;
import it.uniroma3.project.model.Utente;
import it.uniroma3.project.services.mail.EmailManager;
import it.uniroma3.project.services.validator.Time24HoursValidator;

@ManagedBean(name = "prenotazioneController")
@RequestScoped
@EJBs(value = { @EJB(name = "pFacade", beanInterface = PrenotazioneFacade.class),
		@EJB(name = "tFacade", beanInterface = TavoloFacade.class) })
public class PrenotazioneController {

	private Date datepicker;
	private int coperti;
	private Date timepicker;
	private String nominativo;

	private Prenotazione prenotazione;
	private List<Tavolo> tavoli;

	@EJB
	private PrenotazioneFacade pFacade;

	@EJB
	private TavoloFacade tFacade;

	public String createByAdmin() {
		Time24HoursValidator validatorD = new Time24HoursValidator();
		if (validatorD.isCena(this.timepicker)) {
			Tavolo tavolo = this.validateTable();
			if (tavolo == null)
				return "prenotazioneAdmin";
			this.prenotazione = pFacade.createByPersonale(this.getNominativo(), this.getDatepicker(),
					this.getTimepicker(), this.getCoperti(), tavolo);
			if (validatorD.isToday(this.prenotazione.getData())) {
				tFacade.setTavoloPrenotato(tavolo);
			}
			SessionAndRequestManager.setInRequest("prenotazioneCorrente",
					"Hai prenotato a nome di " + this.nominativo + " per " + this.coperti + " persone per il giorno "
							+ validatorD.ConvertDateToString(datepicker) + " alle ore "
							+ validatorD.ConvertTimeToString(this.getTimepicker()));
		} else
			SessionAndRequestManager.setInRequest("prenotazioneError",
					"è possibile prenotare solo negli orari di eserczio del locale (12:00 - 14:00 e 19:00-22:00) ");
		return "prenotazioneAdmin";
	}

	public String createByUtente() {
		Time24HoursValidator validatorD = new Time24HoursValidator();
		if (validatorD.isCena(this.timepicker)) {
			Tavolo tavolo = this.validateTable();
			if (tavolo == null)
				return "prenotazione";
			Utente utenteCorrente = SessionAndRequestManager.getUtenteCorrente();
			this.prenotazione = pFacade.createByUtente(this.getDatepicker(), this.getTimepicker(), this.getCoperti(),
					utenteCorrente, tavolo);
			EmailManager emailManager = new EmailManager();
			emailManager.sendMailReservation(utenteCorrente.getEmail(),
					utenteCorrente.getUsername(), validatorD.ConvertDateToString(this.datepicker),
					validatorD.ConvertTimeToString(this.timepicker), this.coperti);
			if (validatorD.isToday(this.prenotazione.getData())) {
				tFacade.setTavoloPrenotato(tavolo);
			}
			SessionAndRequestManager.setInRequest("prenotazioneCorrente",
					"La prenotazione è stata registrata correttamente a nome di  " + utenteCorrente.getCognome()
					+ " per " + this.coperti + " persone il giorno "
					+ validatorD.ConvertDateToString(datepicker) + " alle ore "
					+ validatorD.ConvertTimeToString(this.getTimepicker()));
		} else
			SessionAndRequestManager.setInRequest("prenotazioneError",
					"è possibile prenotare solo per l'ora di cena (19:00 - 21:59)");
		return "prenotazione";
	}

	public Tavolo validateTable() {
		Time24HoursValidator validatorD = new Time24HoursValidator();
		this.tavoli = this.tFacade.findAllTavolo();
		Ristorante ristorante = new Ristorante();
		List<Tavolo> tavoliDisponibili = ristorante.setTavoloPrenotazione(this.tavoli, this.coperti);
		Tavolo tavoloDaPrenotare = ristorante.checkTavoliLiberiForDate(tavoliDisponibili, this.datepicker);
		if (tavoliDisponibili.isEmpty()) {
			SessionAndRequestManager.setInRequest("prenotazioneError",
					"Non ci sono tavoli disponibili per questo numero di ospiti");
		} else if (tavoloDaPrenotare == null) {
			SessionAndRequestManager.setInRequest("prenotazioneError",
					"Non ci sono tavoli disponibili per il " + validatorD.ConvertDateToString(this.datepicker) + " per "
							+ this.coperti + " persone");
		}
		return tavoloDaPrenotare;
	}

	@PostConstruct
	public void init() {
		SessionAndRequestManager.sessionCheckerUtente();
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

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

	public PrenotazioneFacade getPaFacade() {
		return pFacade;
	}

	public void setPaFacade(PrenotazioneFacade paFacade) {
		this.pFacade = paFacade;
	}

	public List<Tavolo> getTavoli() {
		return tavoli;
	}

	public void setTavoli(List<Tavolo> tavoli) {
		this.tavoli = tavoli;
	}

	public TavoloFacade gettFacade() {
		return tFacade;
	}

	public void settFacade(TavoloFacade tFacade) {
		this.tFacade = tFacade;
	}

}
