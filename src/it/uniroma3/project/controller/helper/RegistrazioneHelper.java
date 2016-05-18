package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
public class RegistrazioneHelper {

	public RegistrazioneHelper() {
	}
	
	public boolean validate(HttpServletRequest request){
		String nome,cognome,email,telefono,password,confermaPassword;
		boolean corretto=true;
		Facade facade = new Facade();
		nome=request.getParameter("nome");
		cognome=request.getParameter("cognome");
		email = request.getParameter("email");
		telefono = request.getParameter("telefono");
		password = request.getParameter("password");
		confermaPassword = request.getParameter("confermaPassword");

		if(facade.findUtente(email)!=null){
			corretto=false;
			request.setAttribute("utenteError", "Utente esistente");
		}
		if(nome.equals("")){
			corretto=false;
			request.setAttribute("nomeError", "Nome obbigatorio");
		}
		if(cognome.equals("")){
			corretto=false;
			request.setAttribute("cognomeError","Cognome obbligatorio" );
		}
		if(email.equals("")){
			corretto=false;
			request.setAttribute("emailError", "Email obbligatoria");
		}
		if(telefono.equals("")){
			corretto=false;
			request.setAttribute("telefonoError", "Telefono obbligatorio");
		}
		if(password.equals("")){
			corretto=false;
			request.setAttribute("passwordError", "Password obbligatoria");
		}
		if(confermaPassword.equals("")){
			corretto=false;
			request.setAttribute("confermaPasswordError", "Conferma Password obbligatoria");
		}		
		if(!password.equals(confermaPassword)){
			corretto=false;
			request.setAttribute("passwordConfError", " Le password non coincidono");
		}

		if(corretto==false){
			request.setAttribute("ERRORE", "error");
		}
		return corretto;
	}

}
