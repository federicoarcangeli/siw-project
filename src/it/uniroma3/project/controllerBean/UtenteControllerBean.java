package it.uniroma3.project.controllerBean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.UtenteFacade;
import it.uniroma3.project.model.Utente;
import it.uniroma3.project.services.security.MD5Encrypter;

@ManagedBean(name = "utenteController")
@SessionScoped
@EJB(name = "uFacade", beanInterface = UtenteFacade.class)
public class UtenteControllerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String telefono;
	private String password;
	private String confPassword;
	private boolean loggedIn;

	private Utente utente;

	private String originalURL;

	@EJB(name = "uFacade")
	private UtenteFacade uFacade;

	public String create() {
		this.utente = new Utente(this.nome, this.cognome, this.username, this.telefono, this.email,
				this.getPasswordCriptata());
		if (this.isAlreadyRegistered(this.utente) || this.equalsPassword()) {
			return "loginSignup";
		} else {
			this.utente = uFacade.signUp(this.utente);
			loggedIn = true;
			this.setUtenteInSession("utenteCorrente");
			return "index_parallax";
		}
	}

	public String createOperatore() {
		this.utente = new Utente(username, this.getPasswordCriptata());
		if (this.isAlreadyRegistered(this.utente))
			return "registraPersonale?faces-redirect=true";
		else {
			this.utente = this.uFacade.signUp(utente);
			return "home_Administrator?faces-redirect=true";
		}
	}

	public String loginUtente() {
		this.utente = this.uFacade.findByUsername(this.getUsername());
		if (this.isNotAlreadyRegistered(this.utente) || this.wrongPassword()) {
			return "loginSignup?faces-redirect=true";
		} else {
			this.utente = this.uFacade.findByUsername(utente.getUsername());
			this.setUtenteInSession("utenteCorrente");
			return "index_parallax?faces-redirect=true";
		}
	}

	public String loginAdmin() {
		this.utente = this.uFacade.findByUsername(this.getUsername());
		//		L'utente che sta tentando di autenticarsi non è registrato nel sistema
		if (this.isNotAlreadyRegistered(this.utente) || this.wrongPassword()) {
			return "administrator";
		} else {
			//			L'utente è registrato
			if(this.utente.getRole().equals("admin")) {
				this.setUtenteInSession("utenteCorrente");
				return "home_Administrator?faces-redirect=true";
			} else if(this.utente.getRole().equals("operatore")) {
				this.setUtenteInSession("utenteCorrente");
				return "home_Operatore?faces-redirect=true";
			} else {
				return "administrator";
			}
		}
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

	public boolean wrongPassword() {
		if (!this.utente.getPassword().equals(this.getPasswordCriptata())) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "password errata!", null));
			return true;
		} else
			return false;
	}

	public boolean equalsPassword() {
		if (!this.password.equals(this.confPassword)) {
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

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		originalURL = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);
		if (originalURL == null) {
			originalURL = externalContext.getRequestContextPath() + "/home_Administrator.jsp";
		} else {
			String originalQuery = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_QUERY_STRING);

			if (originalQuery != null) {
				originalURL += "?" + originalQuery;
			}
		}
	}

	public String doLogin() {
		Utente admin = this.uFacade.findAdmin(username, this.getPasswordCriptata());
		if (admin != null) {
			loggedIn = true;
			return "home_Administrator";
		} else {
			return "administrator";
		}
	}

	public String doLogout() {
		loggedIn = false;
		return "administrator";
	}

	public void login() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

		try {
			request.login(username, password);
			Utente user = this.uFacade.findAdmin(username, password);
			externalContext.getSessionMap().put("admin", user);
			externalContext.redirect(originalURL);
		} catch (ServletException e) {
			// Handle unknown username/password in request.login().
			context.addMessage(null, new FacesMessage("Utente sconosciuto"));
		}
	}

	public void logout() throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.invalidateSession();
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("./index_parallax.jsp");
	}

	public void setUtenteInSession(String name){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put(name, this.utente);
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

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
