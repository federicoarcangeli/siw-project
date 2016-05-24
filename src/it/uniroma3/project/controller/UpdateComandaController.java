package it.uniroma3.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.project.controller.action.UpdateComandaAction;

/**
 * Servlet implementation class UpdateComandaController
 */
@WebServlet("/UpdateComanda")
public class UpdateComandaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateComandaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateComandaAction updateComandaAction = new UpdateComandaAction();
		String nextPage = updateComandaAction.execute(request);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getNamedDispatcher(nextPage);
		rd.forward(request, response);
	}

}
