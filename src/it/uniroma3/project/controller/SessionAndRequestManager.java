package it.uniroma3.project.controller;

import java.io.IOException;
import java.util.Map;

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

	public static Object getBySession(String name) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getSessionMap().get(name);
	}
	
	public static void sessionChecker() {
		if(getUtenteCorrente()==null)
			try {
				redirectPage("./sessioneScaduta.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			if(!getUtenteCorrente().getRole().equals("admin"))
				try {
					redirectPage("./404.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
	}


}
