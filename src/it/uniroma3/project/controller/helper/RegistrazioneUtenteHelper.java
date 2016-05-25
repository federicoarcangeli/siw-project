package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.Facade;
public class RegistrazioneUtenteHelper {

	public RegistrazioneUtenteHelper() {
	}

	public boolean validate(HttpServletRequest request){
		boolean check=true;
		Facade facade = new Facade();
		String username = request.getParameter("username");
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String password = request.getParameter("password");
		String confermaPassword = request.getParameter("confermaPassword");

		if(facade.findUtente(username)!=null){
			facade.closeEntityManager();
			check=false;
			request.setAttribute("userError", "Utente esistente");
		}else{
			if(username.equals("")){
				check=false;
				request.setAttribute("usernameError", "Username obbigatorio");
			}
			if(nome.equals("")){
				check=false;
				request.setAttribute("nomeError", "Nome obbigatorio");
			}
			if(cognome.equals("")){
				check=false;
				request.setAttribute("cognomeError","Cognome obbligatorio" );
			}
			if(email.equals("")){
				check=false;
				request.setAttribute("emailError", "Email obbligatoria");
			}
			if(telefono.equals("")){
				check=false;
				request.setAttribute("telefonoError", "Telefono obbligatorio");
			}
			if(password.equals("")){
				check=false;
				request.setAttribute("passwordError", "Password obbligatoria");
			}
			if(confermaPassword.equals("")){
				check=false;
				request.setAttribute("confermaPasswordError", "Conferma Password obbligatoria");
			}		
			if(!password.equals(confermaPassword)){
				check=false;
				request.setAttribute("passwordConfError", " Le password non coincidono");
			}
		}
		if(check==false){
			request.setAttribute("ERRORE", "error");
		}
		return check;
	}

}
