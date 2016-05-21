package it.uniroma3.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.project.controller.action.NewComandaAction;
import it.uniroma3.project.controller.helper.NewComandaHelper;

/**
 * Registrazione di una nuova comanda per un tavolo
 * Caso d'uso: l'operatore va al tavolo per prendere un ordine
 * @author Federico
 *
 */
@WebServlet("/NewComandaController")
public class NewComandaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewComandaController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewComandaAction newComandaAction = new NewComandaAction();
		NewComandaHelper newComandaHelper = new NewComandaHelper();
		String nextPage = "./sala.jsp";
		if(newComandaHelper.validate(request))
			nextPage = newComandaAction.execute(request);
		nextPage = response.encodeURL(nextPage);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
