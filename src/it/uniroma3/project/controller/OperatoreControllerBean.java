package it.uniroma3.project.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.uniroma3.project.facade.OperatoreFacade;
import it.uniroma3.project.model.Utente;
import it.uniroma3.project.services.security.MD5Encrypter;

@ManagedBean
@RequestScoped
@EJB(name = "oFacade", beanInterface = OperatoreFacade.class)
public class OperatoreControllerBean {

	private String username;
	private String password;
	private String ruolo;
	private Utente utente;

	@EJB(name="oFacade")
	private OperatoreFacade oFacade;

	public String create() {
		this.utente = oFacade.create(this.getUsername(),this.getPasswordCriptata(),this.getRuolo());
		return "registrazioneOperatore";
	}

	public String getPasswordCriptata(){
		MD5Encrypter crypter = new MD5Encrypter();
		return crypter.cryptWithMD5(this.getPassword());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public OperatoreFacade getoFacade() {
		return oFacade;
	}

	public void setoFacade(OperatoreFacade oFacade) {
		this.oFacade = oFacade;
	}
}
