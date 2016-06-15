package it.uniroma3.project.controller;

import java.io.IOException;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import it.uniroma3.project.model.Utente;

public class SessionAndRequestManager {

	public static Utente getUtenteCorrente() {
		FacesContext context = FacesContext.getCurrentInstance();
		return (Utente) context.getExternalContext().getSessionMap().get("utenteCorrente");
	}

	public static void redirectPage(String page) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect(page);
	}

	public static String getByRequest(String name) {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		return params.get(name);
	}

	public static void setInRequest(String name , String messagge){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getRequestMap().put(name,messagge);
	}

	public static Object getBySession(String name) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getSessionMap().get(name);
	}

	public static void setInSession(String name, Object oggetto) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put(name, oggetto);
	}

	public static void logout() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.invalidateSession();
		context.getExternalContext().redirect("index_parallax.jsp");
	}

	public static void sessionCheckerUtente() {
		if(getUtenteCorrente()==null)
			try {
				redirectPage("./sessioneScaduta.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}

	}
	public static void sessionCheckerUtenteOperatori(){
		if(getUtenteCorrente()==null)
			try {
				redirectPage("./sessioneScaduta.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			if(getUtenteCorrente().getRole().equals("utente"))
				try {
					redirectPage("./404.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
	}


}
