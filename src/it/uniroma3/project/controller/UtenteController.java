package it.uniroma3.project.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import it.uniroma3.project.facade.UtenteFacade;
import it.uniroma3.project.model.Utente;
import it.uniroma3.project.services.mail.EmailManager;
import it.uniroma3.project.services.security.MD5Encrypter;

@ManagedBean(name = "utenteController")
@SessionScoped
@EJB(name = "uFacade", beanInterface = UtenteFacade.class)
public class UtenteController implements Serializable {

	private static final long serialVersionUID = 1L;
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

	// creazione utente
	public String create() {
		this.utente = new Utente(this.nome, this.cognome, this.username, this.telefono, this.email,
				this.getPasswordCriptata());
		EmailManager emailManager = new EmailManager();
		emailManager.sendMail(this.email, username);
		// L'utente che sta tentando di creare un account ha inserito una username già utilizzata
		if (this.isAlreadyRegistered(this.utente)) {
			SessionAndRequestManager.setInRequest("utenteError",
					"Utente con username " + this.username + " già esistente");
			return "loginSignup";
		} else
			// le passdword inserite non corrispondo
			if (this.equalsPassword()) {
				SessionAndRequestManager.setInRequest("utenteError", "Le password non corrispondo");
				return "loginSignup";
			} else {
				this.utente = uFacade.signUp(this.utente);
				SessionAndRequestManager.setInSession("utenteCorrente", this.utente);
				return "index_parallax";
			}
	}

	public String createOperatore() {
		SessionAndRequestManager.sessionCheckerUtenteOperatori();

		this.utente = new Utente(this.username, this.getPasswordCriptata());
		// L'admin che ha tentato di creare l'operatore ha inserito una username
		// già utilizzata nel sistema
		if (this.isAlreadyRegistered(this.utente)) {
			SessionAndRequestManager.setInRequest("operatoreError",
					"Operatore con username " + this.username + " già esistente");
			return "registraPersonale";
		}
		this.uFacade.signUp(utente);
		SessionAndRequestManager.setInRequest("operatoreCorrente",
				"L' operatore " + this.username + " è stato inserito correttamente");
		return "registraPersonale";

	}

	public String loginUtente() {
		this.utente = this.uFacade.findByUsername(this.getUsername());
		// L'utente che sta tentando di autenticarsi non è registrato nel sistema
		if (this.isNotAlreadyRegistered(this.utente)) {
			SessionAndRequestManager.setInRequest("utenteError", "Utente non esistente");
			return "loginSignup";
		} else
			// la password inserita non è corretta per l'account con tale username
			if (this.wrongPassword()) {
				SessionAndRequestManager.setInRequest("utenteError", "Username e/o password errata");
				return "loginSignup";
			} else {
				this.utente = this.uFacade.findByUsername(utente.getUsername());
				SessionAndRequestManager.setInSession("utenteCorrente", this.utente);
				return "index_parallax";
			}
	}

	public String loginAdmin() {
		this.utente = this.uFacade.findByUsername(this.getUsername());
		// L'utente che sta tentando di autenticarsi non è registrato nel
		// sistema
		if (this.isNotAlreadyRegistered(this.utente)) {
			SessionAndRequestManager.setInRequest("utenteError", "Utente non esistente");
			return "administrator";
		} else
			// la password inserita non è corretta per l'account con tale username
			if (this.wrongPassword()) {
				SessionAndRequestManager.setInRequest("utenteError", "Username e/o password errata");
				return "administrator";
			} else {
				// L'utente è registrato con ruolo admin o operatore
				if (this.utente.getRole().equals("admin")) {
					SessionAndRequestManager.setInSession("utenteCorrente", this.utente);
					return "home_Administrator?faces-redirect=true";
				} else if (this.utente.getRole().equals("operatore")) {
					SessionAndRequestManager.setInSession("utenteCorrente", this.utente);
					return "home_Operatore?faces-redirect=true";
					// il ruolo è utente
				} else {
					SessionAndRequestManager.setInRequest("utenteError",
							this.username + " Cosa ci fai qui? non è un posto per utenti");
					return "administrator";
				}
			}
	}

	public boolean isAlreadyRegistered(Utente utente) {
		if (this.uFacade.findByUsername(utente.getUsername()) != null) {
			return true;
		} else
			return false;
	}

	public boolean isNotAlreadyRegistered(Utente utente) {
		if (this.uFacade.findByUsername(this.getUsername()) == null) {
			return true;
		} else
			return false;
	}

	public boolean wrongPassword() {
		if (!this.utente.getPassword().equals(this.getPasswordCriptata())) {
			return true;
		} else
			return false;
	}

	public boolean equalsPassword() {
		if (!this.password.equals(this.confPassword)) {
			return true;
		} else
			return false;
	}

	public void logout() throws IOException {
		SessionAndRequestManager.logout();
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
