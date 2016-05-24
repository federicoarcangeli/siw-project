package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
public class RegistrazioneTavoloHelper {

	public RegistrazioneTavoloHelper() {
	}

	public boolean validate(HttpServletRequest request){
		boolean corretto=true;
		Facade facade = new Facade();
		String codiceTavolo=request.getParameter("codiceTavolo");
		String coperti = request.getParameter("coperti");

		if(codiceTavolo.equals("")){
			corretto=false;
			request.setAttribute("codiceError", "Codice tavolo obbligatorio");
		}else{
			if(facade.findTavoloByNumero(codiceTavolo)!=null){
				corretto=false;
				request.setAttribute("tavoloError", "Tavolo già presente nel sistema");
			}
		}
		if(coperti.equals("0")){
			corretto=false;
			request.setAttribute("copertiError", "Coperti obbligatori");
		}

		if(corretto==false){
			request.setAttribute("ERROR", "error");
		}
		else
			request.setAttribute("OK", "Il tavolo numero " +codiceTavolo+ " con " +coperti+ " coperti è stato inserito correttamente nel sistema");
		return corretto;
	}

}
