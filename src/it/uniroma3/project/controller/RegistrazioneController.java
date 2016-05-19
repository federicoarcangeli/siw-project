package it.uniroma3.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.project.controller.action.RegistrazioneAction;
import it.uniroma3.project.controller.helper.RegistrazioneHelper;

/**
 * Controller per la registrazione di operatori di sala e nuovi amministratori
 * 
 * @author Federico
 *
 */

@WebServlet("/processaRegistrazione")
public class RegistrazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrazioneController() {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegistrazioneHelper helper = new RegistrazioneHelper();
		RegistrazioneAction action = new RegistrazioneAction();
		String nextPage = "/loginSignup.jsp";
		if (helper.validate(request)) {
			nextPage = action.execute(request);
		}
		nextPage = response.encodeURL(nextPage);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
