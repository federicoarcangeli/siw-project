package it.uniroma3.project.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.uniroma3.project.facade.UtenteFacade;
import it.uniroma3.project.model.Utente;
import it.uniroma3.project.services.security.MD5Encrypter;

@ManagedBean(name="registrazione")
@RequestScoped
@EJB(name = "uFacade", beanInterface = UtenteFacade.class)
public class RegistrazioneUtenteControllerBean {

	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String telefono;
	private String password;
	private String confPassword;

	private Utente utente;

	@EJB(name="uFacade")
	private UtenteFacade uFacade;

	public String create() {
		this.utente = uFacade.create(this.getNome(),this.getCognome(),this.getUsername(),this.getTelefono(),this.getEmail(),this.getPasswordCriptata());
		return "registrazioneOperatore";
	}

	public String getPasswordCriptata(){
		MD5Encrypter crypter = new MD5Encrypter();
		return crypter.cryptWithMD5(this.getPassword());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public UtenteFacade getuFacade() {
		return uFacade;
	}

	public void setuFacade(UtenteFacade uFacade) {
		this.uFacade = uFacade;
	}

}
