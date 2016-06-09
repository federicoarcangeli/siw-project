package it.uniroma3.project.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import it.uniroma3.project.facade.UtenteFacade;
import it.uniroma3.project.model.Utente;
import it.uniroma3.project.services.security.MD5Encrypter;

@ManagedBean(name = "utenteController")
@RequestScoped
@EJB(name = "uFacade", beanInterface = UtenteFacade.class)
public class UtenteControllerBean {

	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String telefono;
	private String password;
	private String confPassword;

	private Utente utente;

	@EJB(name = "uFacade")
	private UtenteFacade uFacade;

	public String create() {
		this.utente = new Utente(this.nome, this.cognome, this.username, this.telefono, this.email,
				this.getPasswordCriptata());
		FacesContext context = FacesContext.getCurrentInstance();
		if (this.isAlreadyRegistered(this.utente) || this.equalsPassword()) {
			return "loginSignup";
		} else {
			this.utente = uFacade.signUp(this.utente);
			context.getExternalContext().getSessionMap().put("utenteCorrente", utente);
			return "index_parallax";
		}
	}

	public String loginUtente(){
		this.utente=this.uFacade.findByUsername(this.getUsername());
		FacesContext context = FacesContext.getCurrentInstance();
		if (this.isNotAlreadyRegistered(this.utente) || this.wrongPassword()){
			return "loginSignup";
		}
		else{
			this.utente = this.uFacade.findByUsername(utente.getUsername());
			context.getExternalContext().getSessionMap().put("utenteCorrente", utente);
			return "index_parallax";
		}
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index_parallax";
	}


	public boolean isAlreadyRegistered(Utente utente) {
		if (this.uFacade.findByUsername(utente.getUsername()) != null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, utente.getUsername() + " è già registrato!", null));
			return true;
		} else
			return false;
	}

	public boolean isNotAlreadyRegistered(Utente utente) {
		if (this.uFacade.findByUsername(this.getUsername()) == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, this.getUsername() + " non è registrato!", null));
			return true;
		} else
			return false;
	}

	public boolean wrongPassword(){
		if(!this.utente.getPassword().equals(this.getPasswordCriptata())){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,"password errata!", null));
			return true;
		} else
			return false;
	}

	public boolean equalsPassword() {
		if(!this.password.equals(this.confPassword)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Le password devono coincidere", null));
			return true;
		} else
			return false;
	}

	public String getPasswordCriptata() {
		String toCrypt = this.password;
		MD5Encrypter crypter = new MD5Encrypter();
		return crypter.cryptWithMD5(toCrypt);
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
