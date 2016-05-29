package it.uniroma3.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.uniroma3.project.controller.action.PiattoAction;
import it.uniroma3.project.controller.helper.PiattoHelper;

/**
 * Servlet implementation class DescrizionePiattoController
 */
@WebServlet("/processaPiatto")
@MultipartConfig
public class PiattoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public PiattoController() {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PiattoHelper helper = new PiattoHelper();
		PiattoAction action = new PiattoAction();
		String nextPage = "/inserimentoPiatti.jsp";
		
		
			nextPage = action.execute(request);
		

		nextPage = response.encodeURL(nextPage);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
