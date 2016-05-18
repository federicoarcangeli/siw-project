package it.uniroma3.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.boot.model.source.internal.hbm.Helper;

import it.uniroma3.project.controller.action.ComandaAction;
import it.uniroma3.project.controller.action.ProfiloAction;
import it.uniroma3.project.controller.helper.ComandaHelper;

/**
 * Servlet implementation class ComandaController
 */
@WebServlet("/processaComanda")
public class ComandaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComandaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComandaAction action = new ComandaAction();
		String nextPage = action.execute(request);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
