package it.uniroma3.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.project.controller.action.RegistrazioneTavoloAction;
import it.uniroma3.project.controller.helper.RegistrazioneTavoloHelper;


@WebServlet("/processaTavolo")
public class RegistrazioneTavoloController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrazioneTavoloController() {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrazioneTavoloHelper helper = new RegistrazioneTavoloHelper();
		RegistrazioneTavoloAction action = new RegistrazioneTavoloAction();
		String nextPage = "/registraTavolo.jsp";
		if(helper.validate(request)){
			nextPage=action.execute(request);
		}
		nextPage=response.encodeURL(nextPage);
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
